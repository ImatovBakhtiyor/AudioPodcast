package com.example.audiopodcast;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class TitleTwo extends AppCompatActivity {
    Button btn,skip;
    Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_title_two);
        getSupportActionBar().hide();
        btn = findViewById(R.id.next2);
        skip = findViewById(R.id.skip);
        View.OnClickListener onClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()){
                    case R.id.skip:
                        intent = new Intent(TitleTwo.this,Login.class);
                        startActivity(intent);
                        break;
                    case R.id.next2:
                        intent = new Intent(TitleTwo.this,TitleThree.class);
                        startActivity(intent);
                        break;
                }
            }

        };
        btn.setOnClickListener(onClickListener);
        skip.setOnClickListener(onClickListener);
    }
}