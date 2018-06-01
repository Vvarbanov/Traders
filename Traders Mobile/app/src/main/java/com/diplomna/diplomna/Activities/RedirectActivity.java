package com.diplomna.diplomna.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.diplomna.diplomna.DTOs.AccountType;
import com.diplomna.diplomna.DTOs.UserDTO;
import com.diplomna.diplomna.R;
import com.diplomna.diplomna.http.API;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class RedirectActivity extends AppCompatActivity {

    @Inject
    Retrofit retrofit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_redirect);

        Bundle extras = getIntent().getExtras();
        String user = extras.getString("Username");

        API service = retrofit.create(API.class);

        service.getUserByUsername(user).enqueue(new Callback<UserDTO>() {
            @Override
            public void onResponse(Call<UserDTO> call, Response<UserDTO> response) {
                if(response.isSuccessful()){

                    AccountType userType;
                    UserDTO userDTO = response.body();
                    if (userDTO.getAccountType() != null) {
                        userType = userDTO.getAccountType();
                    }else
                        userType = AccountType.CUSTOMER;

                    if (userType.equals(AccountType.DEALER)) {
                        Intent intent = new Intent(RedirectActivity.this, MainActivityDealer.class);
                        startActivity(intent);
                    } else if (userType.equals(AccountType.CUSTOMER)) {
                        Intent intent = new Intent(RedirectActivity.this, MainActivityCustomer.class);
                        startActivity(intent);
                    }

                }else {
                    Toast.makeText(getApplicationContext(),response.message(),Toast.LENGTH_SHORT).show();
                    Log.v(this.getClass().getSimpleName(),"response:" + response.message());
                }
            }

            @Override
            public void onFailure(Call<UserDTO> call, Throwable t) {
                Toast.makeText(getApplicationContext(),t.getMessage(),Toast.LENGTH_SHORT).show();
                Log.v(this.getClass().getSimpleName(), "error:" + t.getMessage());
            }
        });

    }
}
