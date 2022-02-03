package com.example.audiopodcast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.chip.Chip;
import com.google.android.material.chip.ChipGroup;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Personalization extends AppCompatActivity {
    Button submitBtn;
    ChipGroup chipGroup;
    Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personalization);
        submitBtn = findViewById(R.id.submitBtn);
        View.OnClickListener onClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()){
                    case R.id.submitBtn:
                        intent = new Intent(Personalization.this, PersonalizationTwo.class);
                        startActivity(intent);
                        break;
                    case R.id.skipBtn:
                        overridePendingTransition(R.anim.left_in, R.anim.right_in);
                        break;
                }
            }
        };
        submitBtn.setOnClickListener(onClickListener);
    }
    }
