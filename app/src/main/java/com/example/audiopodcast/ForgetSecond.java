package com.example.audiopodcast;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class ForgetSecond extends AppCompatActivity {
Button closeBtn;
TextView wesSentEdt;
Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forget_second);
        closeBtn = findViewById(R.id.closeBtn);
        wesSentEdt   = findViewById(R.id.we_sent);
        Intent myIntent = getIntent();
        String email =  myIntent.getStringExtra("email");
        wesSentEdt.setText(Html.fromHtml(wesSentEdt.getText().toString()+" "+"<b>" + email + "</b>"+  " with a link to get back into your account."));
        closeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(ForgetSecond.this,Login.class);
                startActivity(intent);
            }
        });
    }
}