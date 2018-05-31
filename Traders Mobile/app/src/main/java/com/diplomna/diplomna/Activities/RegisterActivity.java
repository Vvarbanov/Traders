package com.diplomna.diplomna.Activities;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.diplomna.diplomna.DTOs.AccountType;
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

public class RegisterActivity extends AppCompatActivity {

    @Inject
    Retrofit retrofit;

    public ImageButton btnRegister, btnLoginScreen;
    private TextView txtUsername, txtEmail, txtPassword, txtPasswordConfirm, txtPhone;
    private Spinner spnrAccType;

    public String getUsername(){
        return txtUsername.getText().toString().trim();
    }

    public String getEmail(){
        return txtEmail.getText().toString().trim();
    }

    public String getPassword(){
        return txtPassword.getText().toString().trim();
    }

    public String getPasswordConfirmation(){
        return txtPasswordConfirm.getText().toString().trim();
    }

    public String getPhone(){
        return txtPhone.getText().toString().trim();
    }

    public boolean validateFields(){

        boolean validity = true;

        if(getPassword().equals(""))                validity = false;
        if(getPasswordConfirmation().equals(""))    validity = false;
        if(getEmail().equals(""))                   validity = false;
        if(getPhone().equals(""))                   validity = false;
        if(getUsername().equals(""))                validity = false;

        return validity;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        ButterKnife.bind(this);

        init();


    }

    @OnClick(R.id.btnRegister)
    public void submit(View view){

        if(getPassword().equals(getPasswordConfirmation())) {

            API service = retrofit.create(API.class);

            if(validateFields()) {

                UserDTO userDTO = new UserDTO();

                String userType = spnrAccType.getSelectedItem().toString();
                if(userType.equals("DEALER")) userDTO.setAccountType(AccountType.DEALER);
                if (userType.equals("CUSTOMER")) userDTO.setAccountType(AccountType.CUSTOMER);

                userDTO.setEmail(getEmail());
                userDTO.setPassword(getPassword());
                userDTO.setUsername(getUsername());
                userDTO.setPhone(getPhone());

                service.register(userDTO).enqueue(new Callback<Void>() {
                    @Override
                    public void onResponse(Call<Void> call, Response<Void> response) {
                        if(response.isSuccessful()){
                            Log.d("registration", "successful");
                        }else{
                            Log.d("registration","not successful");
                        }
                    }

                    @Override
                    public void onFailure(Call<Void> call, Throwable t) {
                        Toast.makeText(getApplicationContext(),t.getMessage(),Toast.LENGTH_SHORT).show();
                        Log.v(this.getClass().getSimpleName(), "error:" + t.getMessage());
                    }
                });

            }
        }else{
            Toast.makeText(this, "Passwords must match", Toast.LENGTH_SHORT).show();
        }

    }


    public void init(){
        btnRegister = findViewById(R.id.btnRegister);
        btnLoginScreen = findViewById(R.id.btnLoginScreen);
        txtUsername = findViewById(R.id.txtUsername);
        txtEmail = findViewById(R.id.txtEmail);
        txtPassword = findViewById(R.id.txtPassword);
        txtPasswordConfirm = findViewById(R.id.txtPasswordConfirm);
        txtPhone = findViewById(R.id.txtPhone);
        spnrAccType = findViewById(R.id.spnrAccType);

        btnLoginScreen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });
    }

}
