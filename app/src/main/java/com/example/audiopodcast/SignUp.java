package com.example.audiopodcast;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SignUp extends AppCompatActivity {
 TextView register_link,email;
 Button registerButton,cancelButton;
 Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        getSupportActionBar().hide();
        register_link = findViewById(R.id.register_text);
        email = findViewById(R.id.email);
        register_link.setMovementMethod(LinkMovementMethod.getInstance());
        registerButton = findViewById(R.id.registerBtn);
        cancelButton    = findViewById(R.id.cancel_button);
        View.OnClickListener onClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()){
                    case R.id.registerBtn:
                        intent = new Intent(SignUp.this,Confirmation.class);
                        intent.putExtra("email",email.getText().toString());
                        startActivity(intent);
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
}