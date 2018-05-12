package com.diplomna.diplomna.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.diplomna.diplomna.Models.User;
import com.diplomna.diplomna.R;

public class LoginActivity extends AppCompatActivity {

    public Button loginButton, registerButton;
    private EditText txtPass, txtEmail;

    public String getPass() {
        return txtPass.getText().toString().trim();
    }

    public String getEmail() {
        return txtEmail.getText().toString().trim();
    }

    //get from database user type
    private String userType = "CUSTOMER";

    private boolean validateLogin(String username, String password){
        if(username == null || username.trim().length() == 0){
            Toast.makeText(this, "Username is required", Toast.LENGTH_SHORT).show();
            return false;
        }
        if(password == null || password.trim().length() == 0){
            Toast.makeText(this, "Password is required", Toast.LENGTH_SHORT).show();
            return false;
        }
        Toast.makeText(this, "Validation Passed", Toast.LENGTH_SHORT).show();
        return true;
    }


    public void init(){
        loginButton = findViewById(R.id.loginButton);
        registerButton = findViewById(R.id.registerButton);
        txtPass = findViewById(R.id.txtPassword);
        txtEmail = findViewById(R.id.textEmail);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String passString = getPass();
                String emailString = getEmail();
                //login check
                //if(login){
                    if(validateLogin(emailString, passString)) {
                        if (userType.equals(User.ACCOUNT_TYPE.DEALER)) {
                            Intent intent = new Intent(LoginActivity.this, MainActivityDealer.class);
                            startActivity(intent);
                        } else if (userType.equals(User.ACCOUNT_TYPE.CUSTOMER)) {
                            Intent intent = new Intent(LoginActivity.this, MainActivityCustomer.class);
                            startActivity(intent);
                        }
                    }
                //}
            }
        });

        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        init();
    }
}
