package com.example.audiopodcast;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class PersonalizationTwo extends AppCompatActivity {
Intent intent;
    Button finishBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personalization_two);
        finishBtn = findViewById(R.id.finish_btn);
        View.OnClickListener onClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()){
                    case R.id.finish_btn:
                        intent = new Intent(PersonalizationTwo.this, LoadingScreen.class);
                        startActivity(intent);
                        break;
                }
            }
        };
        finishBtn.setOnClickListener(onClickListener);
    }
}