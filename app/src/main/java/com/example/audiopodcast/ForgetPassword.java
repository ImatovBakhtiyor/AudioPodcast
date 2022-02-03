package com.example.audiopodcast;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class ForgetPassword extends AppCompatActivity {
Button submitBtn,cancelBtn;
EditText email;
Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forget_password);
        submitBtn = findViewById(R.id.submitBtn);
        cancelBtn = findViewById(R.id.cancelBtn);
        email   = findViewById(R.id.email);
        View.OnClickListener onClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()){
                    case R.id.submitBtn:
                        intent = new Intent(ForgetPassword.this,ForgetSecond.class);
                        intent.putExtra("email",email.getText().toString());
                        startActivity(intent);
                        break;
                    case R.id.cancelBtn:
                        intent = new Intent(ForgetPassword.this,Login.class);

                        startActivity(intent);
                        overridePendingTransition(R.anim.left_in, R.anim.right_in);
                        break;
                }
            }

        };
        submitBtn.setOnClickListener(onClickListener);
        cancelBtn.setOnClickListener(onClickListener);
    }
}