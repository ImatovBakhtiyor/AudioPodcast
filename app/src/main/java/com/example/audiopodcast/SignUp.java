package com.example.audiopodcast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;


import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

public class SignUp extends AppCompatActivity {
 TextView register_link;
 EditText Etemail,Etpassword,Etage;
 Button registerButton,cancelButton;
 ProgressBar progressBar ;
 Intent intent;
 private static final String TAG = "MUSAVVIR";
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
                        if(!TextUtils.isEmpty(Etpassword.getText().toString()) && !TextUtils.isEmpty(Etemail.getText().toString())){
                            progressBar.setVisibility(View.VISIBLE);
                            createUser();
                        }
                        else
                        {
                            Toast.makeText(SignUp.this,  "Empty", Toast.LENGTH_SHORT).show();
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

    private void createUser(){
        String password=Etpassword.getText().toString().trim();
        String email =Etemail.getText().toString().trim();
        String age = Etage.getText().toString().trim();
        Log.d(TAG,"Before SENDING" + ' '+ email +' '+"-"+password);
        mAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(this,new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()){
                    User user = new User(email,age);
                    FirebaseDatabase.getInstance().getReference("Users")
                            .child(FirebaseAuth.getInstance().getCurrentUser().getUid())
                            .setValue(user).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            if(task.isSuccessful()){
                                Toast.makeText(SignUp.this,  "User registered successfully", Toast.LENGTH_LONG).show();
                                Log.d(TAG,"User registered successfully");
                                progressBar.setVisibility(View.GONE);
                                intent = new Intent(SignUp.this,Login.class);
                                //intent.putExtra("userId",mAuth.getUid());
                                startActivity(intent);
                            }else{
                                Toast.makeText(SignUp.this,  "Registration error" + task.getException().getMessage(), Toast.LENGTH_LONG).show();
                                Log.d(TAG,"Registration error" + ' '+mAuth.getCurrentUser());
                                progressBar.setVisibility(View.GONE);
                            }
                        }
                    });
                }
                else{
                    Toast.makeText(SignUp.this,  "Registration error" + task.getException().getMessage(), Toast.LENGTH_LONG).show();
                }

            }
        });
    }
    private  void init(){
        mAuth  = FirebaseAuth.getInstance();
        register_link = findViewById(R.id.register_text);
        register_link.setMovementMethod(LinkMovementMethod.getInstance());
        registerButton = findViewById(R.id.registerBtn);
        cancelButton    = findViewById(R.id.cancel_button);
        Etemail = findViewById(R.id.email);
        Etpassword =findViewById(R.id.password);
        Etage=findViewById(R.id.age);
        progressBar = findViewById(R.id.progressBar);
        progressBar.setVisibility(View.GONE);
        Log.d(TAG,"Init SignUp" + ' '+mAuth.getUid());
    }
}