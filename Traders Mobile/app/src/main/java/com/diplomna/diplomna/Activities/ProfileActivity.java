package com.diplomna.diplomna.Activities;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.diplomna.diplomna.DTOs.UserDTO;
import com.diplomna.diplomna.R;
import com.diplomna.diplomna.http.API;

import javax.inject.Inject;

import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class ProfileActivity extends AppCompatActivity {

    @Inject
    Retrofit retrofit;

    @Inject
    SharedPreferences sharedPreferences;

    public ImageButton btnLogOut;
    private TextView txtName, txtEmail, txtPhone, txtAccountType;

    public void setName(String name){
        txtName.setText(name);
    }

    public void setEmail(String email){
        txtEmail.setText(email);
    }

    public void setPhone(String phone){
        txtPhone.setText(phone);
    }

    public void setAccType(String accType){
        txtAccountType.setText(accType);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        ButterKnife.bind(this);

        init();

        API service = retrofit.create(API.class);

        service.getUserByUsername(sharedPreferences.getString("username", "N/A")).enqueue(new Callback<UserDTO>() {
            @Override
            public void onResponse(Call<UserDTO> call, Response<UserDTO> response) {
                if(response.isSuccessful()){

                    UserDTO userDTO = response.body();
                    if(userDTO.getUsername() != null) {
                        setName(userDTO.getUsername());
                    }else
                        setName("Valentin");

                    if (userDTO.getEmail().equals("")) {
                        setEmail("email@email.com");
                    }else
                        setEmail(userDTO.getEmail());

                    if(userDTO.getPhone().equals("")) {
                        setPhone("66699966642");
                    }else
                        setPhone(userDTO.getPhone());

                    setAccType(userDTO.getAccountType().toString().trim());

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

    private void init() {
        btnLogOut = findViewById(R.id.btnLogOut);
        txtName = findViewById(R.id.textName);
        txtEmail = findViewById(R.id.textEmail);
        txtPhone = findViewById(R.id.textPhone);
        txtAccountType = findViewById(R.id.textAccountType);
    }

    @OnClick(R.id.btnLogOut)
    public void submit(View view){

        //LOGOUT

    }

}
