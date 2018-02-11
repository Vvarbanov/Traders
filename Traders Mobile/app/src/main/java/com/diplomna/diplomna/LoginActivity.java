package com.diplomna.diplomna;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.diplomna.diplomna.Models.User;

public class LoginActivity extends AppCompatActivity {

    public Button loginButton, registerButton;
    private EditText txtPass, txtEmail;

    public EditText getTxtPass() {
        return txtPass;
    }

    public EditText getTxtEmail() {
        return txtEmail;
    }

    public void setTxtEmail(EditText txtEmail) {
        this.txtEmail = txtEmail;
    }

    public void setTxtPass(EditText txtPass) {
        this.txtPass = txtPass;
    }

    //get from database user type
    private String userType = "Buyer";


    public void init(){
        loginButton = findViewById(R.id.loginButton);
        registerButton = findViewById(R.id.registerButton);
        txtPass = findViewById(R.id.txtPassword);
        txtEmail = findViewById(R.id.textEmail);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String passString = getTxtPass().getText().toString();
                String emailString = getTxtEmail().getText().toString();
                //login check
                //if(login){
                    if (userType.equals(User.ACCOUNT_TYPE.DEALER)) {
                        Intent intent = new Intent(LoginActivity.this, MainActivityDealer.class);
                        startActivity(intent);
                    } else if (userType.equals(User.ACCOUNT_TYPE.CUSTOMER)) {
                        Intent intent = new Intent(LoginActivity.this, MainActivityCustomer.class);
                        startActivity(intent);
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
