package com.example.audiopodcast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {
    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthListener;
    Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mAuth = FirebaseAuth.getInstance();
        mAuthListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                checkUser();
            }
        };
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
            }
        },2000);
    }
    @Override
    public void onStart() {
        super.onStart();
        checkUser();
    }
    protected void checkUser() {
        FirebaseUser cUser = mAuth.getCurrentUser();
        if(cUser!=null){
            intent = new Intent(MainActivity.this, HomePage.class);
            Toast.makeText(MainActivity.this, "User exists ", Toast.LENGTH_SHORT).show();
            startActivity(intent);
        }
        else
        {
            intent = new Intent(MainActivity.this, TitleOne.class);
            Toast.makeText(MainActivity.this, "User not exist ", Toast.LENGTH_SHORT).show();
            startActivity(intent);
        }
    }
}