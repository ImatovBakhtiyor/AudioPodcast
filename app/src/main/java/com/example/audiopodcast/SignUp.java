package com.example.audiopodcast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class SignUp extends AppCompatActivity {
 TextView register_link,email,password;
 Button registerButton,cancelButton;
 Intent intent;
 private FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        init();
        View.OnClickListener onClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()){
                    case R.id.registerBtn:
                        if(!TextUtils.isEmpty(email.getText().toString()) && !TextUtils.isEmpty(password.getText().toString())){
                            mAuth.createUserWithEmailAndPassword(email.getText().toString(),password.getText().toString()).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                    if (task.isSuccessful()){
                                        Toast.makeText(SignUp.this, "User sign up successful", Toast.LENGTH_SHORT).show();
                                            intent = new Intent(SignUp.this,Login.class);
                                            intent.putExtra("email",email.getText().toString());
                                            startActivity(intent);
                                    }
                                    else{
                                        Toast.makeText(SignUp.this, "User sign up  failed", Toast.LENGTH_SHORT).show();
                                    }

                                }
                            });
                        }
                        break;

                    case R.id.cancel_button:
                        intent = new Intent(SignUp.this,Login.class);
                        startActivity(intent);
                        overridePendingTransition(R.anim.left_in, R.anim.right_in);
                        break;
                }
            }

        };
        registerButton.setOnClickListener(onClickListener);
        cancelButton.setOnClickListener(onClickListener);


    }
    private  void init(){
        mAuth = FirebaseAuth.getInstance();
        register_link = findViewById(R.id.register_text);
        email = findViewById(R.id.email);
        password = findViewById(R.id.email);
        register_link.setMovementMethod(LinkMovementMethod.getInstance());
        registerButton = findViewById(R.id.registerBtn);
        cancelButton    = findViewById(R.id.cancel_button);
    }
}