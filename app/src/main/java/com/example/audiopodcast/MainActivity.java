package com.example.audiopodcast;

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
    Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mAuth = FirebaseAuth.getInstance();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                checkUser();
            }
        },2000);
    }

    protected void checkUser() {
        FirebaseUser cUser = mAuth.getCurrentUser();
        if(cUser!=null){
            intent = new Intent(MainActivity.this, HomePage.class);
            startActivity(intent);
            finish();
        }
        else
        {
            intent = new Intent(MainActivity.this, TitleOne.class);
            startActivity(intent);
            finish();
        }
    }
}