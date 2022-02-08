package com.example.audiopodcast;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class TitleOne extends AppCompatActivity {

    Button btn,skip;
    Intent intent=null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_title_one);
        btn = findViewById(R.id.next1);
        skip = findViewById(R.id.skip);

        View.OnClickListener onClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()){
                    case R.id.skip:
                         intent = new Intent(TitleOne.this,Login.class);
                         startActivity(intent);
                         break;
                    case R.id.next1:
                        intent = new Intent(TitleOne.this,TitleTwo.class);
                        startActivity(intent);
                        break;
                }
            }

        };
        btn.setOnClickListener(onClickListener);
        skip.setOnClickListener(onClickListener);
    }
}