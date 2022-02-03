package com.example.audiopodcast;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

    public class Login extends AppCompatActivity {
       TextView register,forgetPass,login;
        Intent intent;
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_login);
            getSupportActionBar().hide();
            register = findViewById(R.id.register);
            forgetPass = findViewById(R.id.forget_pass);
            login    = findViewById(R.id.login);
            View.OnClickListener onClickListener = new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    switch (v.getId()){
                        case R.id.register:
                            intent = new Intent(Login.this, SignUp.class);
                            startActivity(intent);
                            break;
                        case R.id.forget_pass:
                            intent = new Intent(Login.this, ForgetPassword.class);
                            startActivity(intent);
                            break;
                        case R.id.login:
                            intent = new Intent(Login.this, Welcome.class);
                            startActivity(intent);
                            break;

                    }
                }
            };
            register.setOnClickListener(onClickListener);
            forgetPass.setOnClickListener(onClickListener);
            login.setOnClickListener(onClickListener);
        }
    }