package com.example.audiopodcast;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Welcome extends AppCompatActivity {
    Intent intent;
    Button skipBtn,personalizeBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        skipBtn = findViewById(R.id.skipBtn);
        personalizeBtn  = findViewById(R.id.personalize_btn);
        View.OnClickListener onClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()){
                    case R.id.skipBtn:
                        intent = new Intent(Welcome.this,Welcome.class);
                        startActivity(intent);
                        break;
                    case R.id.personalize_btn:
                        intent = new Intent(Welcome.this,Personalization.class);
                        overridePendingTransition(R.anim.left_in,  R.anim.right_in);
                        startActivity(intent);
                        break;
                }
            }

        };
        skipBtn.setOnClickListener(onClickListener);
        personalizeBtn.setOnClickListener(onClickListener);
    }
}