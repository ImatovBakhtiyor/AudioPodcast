package com.example.audiopodcast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
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
       Intent intent;
       private FirebaseAuth mAuth;
    private static final String TAG = "MUSAVVIR";
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
                                signInMethod();
                            }
                            break;

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
        Log.d(TAG,"Init Login" + ' '+mAuth.getUid());
        }

    private void signInMethod(){
        String password=Edtpassword.getText().toString().trim();
       String email =Edtemail.getText().toString().trim();
                mAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(this,new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {

                        if (task.isSuccessful()){
                            Toast.makeText(Login.this, "User sign in successfuly", Toast.LENGTH_SHORT).show();
                            Log.d(TAG,"User sign in successfuly" + ' '+mAuth.getUid());
                            intent = new Intent(Login.this, Welcome.class);
                            startActivity(intent);
                        }
                        else{

                            Toast.makeText(Login.this, task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                            Log.d(TAG,task.getException().getMessage() + "User sign in failed" + ' '+mAuth.getUid() + email +' '+password);

                        }
                    }
                });
    };

    private boolean checkCredential(){

                if(Edtemail.getText().toString().isEmpty()){
                    Toast.makeText(this, "Email field is empty ", Toast.LENGTH_SHORT).show();
                    Edtemail.setError("Email field is empty ");
                    Edtemail.requestFocus();
                    return false;
                }
                else if (Edtpassword.getText().toString().isEmpty()){
                    Toast.makeText(this, "Password field is empty ", Toast.LENGTH_SHORT).show();
                    Edtpassword.setError("Password field is empty ");
                    Edtpassword.requestFocus();
                    return false;
                }
                else
                {
                    return true;
                }
            }
        }