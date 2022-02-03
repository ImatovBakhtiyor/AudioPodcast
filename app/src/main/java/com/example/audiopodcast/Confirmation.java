package com.example.audiopodcast;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Notification;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.text.Html;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Confirmation extends AppCompatActivity {
TextView sendCodeText;
    Button submitBtn,cancelBtn;
Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirmation);
        sendCodeText = findViewById(R.id.send_code);
        submitBtn =findViewById(R.id.submitBtn);
        cancelBtn=findViewById(R.id.cancelBtn);
        Intent myIntent = getIntent();
        String email =  myIntent.getStringExtra("email");
        sendCodeText.setText(Html.fromHtml(sendCodeText.getText().toString()+" "+"<b>" + email + "</b>"));
        View.OnClickListener onClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()){
                    case R.id.submitBtn:
                        intent = new Intent(Confirmation.this,Welcome.class);
                        startActivity(intent);
                        break;
                    case R.id.cancelBtn:
                        intent = new Intent(Confirmation.this,SignUp.class);
                        overridePendingTransition(R.anim.left_in,  R.anim.right_in);
                        startActivity(intent);
                        break;
                }
            }

        };
        submitBtn.setOnClickListener(onClickListener);
        cancelBtn.setOnClickListener(onClickListener);
    }

}