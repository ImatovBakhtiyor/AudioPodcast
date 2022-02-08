package com.example.audiopodcast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Login extends AppCompatActivity {
       TextView register,forgetPass,login;
       EditText Edtemail,Edtpassword;
       String email,password;
       Intent intent;
       int signIn=0;
       private FirebaseAuth mAuth;
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_login);
            init();

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
                            if(checkCredential()){
                                if(signInMethod()>0){
                                    Toast.makeText(Login.this, "User sign in successful", Toast.LENGTH_SHORT).show();
                                    intent = new Intent(Login.this, Welcome.class);
                                    startActivity(intent);
                                    break;
                                }
                                else{
                                    Toast.makeText(Login.this, "Incorrect login or password", Toast.LENGTH_SHORT).show();
                                }

                            }

                    }
                }
            };
            register.setOnClickListener(onClickListener);
            forgetPass.setOnClickListener(onClickListener);
            login.setOnClickListener(onClickListener);
        }


    private  void init(){
            register = findViewById(R.id.register);
            forgetPass = findViewById(R.id.forget_pass);
            login    = findViewById(R.id.login);
            Edtemail = findViewById(R.id.email);
            Edtpassword = findViewById(R.id.password);
            mAuth = FirebaseAuth.getInstance();
        }

    private int signInMethod(){

                mAuth.signInWithEmailAndPassword(Edtemail.getText().toString(),Edtpassword.getText().toString()).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        Toast.makeText(Login.this, task.getResult().toString(), Toast.LENGTH_SHORT).show();
                        if (task.isSuccessful()){

                            signIn = 1;
                        }
                        else{
                            signIn = 0;
                        }
                    }
                });

            return signIn;
    };

    private boolean checkCredential(){
                email = Edtemail.getText().toString();
                password = Edtpassword.getText().toString();

                if(email.isEmpty()){
                    Toast.makeText(this, "Email field is empty ", Toast.LENGTH_SHORT).show();
                    return false;
                }
                else if (password.isEmpty()){
                    Toast.makeText(this, "Password field is empty ", Toast.LENGTH_SHORT).show();
                    return false;
                }
                else
                {
                    return true;
                }
            }
        }