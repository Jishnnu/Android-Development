package com.example.cakeshopapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity2 extends AppCompatActivity {
    TextView booking_215;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        booking_215 = findViewById(R.id.booking_215);

        Intent intent = getIntent();
        String str_215 = intent.getStringExtra("booking_confirmation");
        booking_215.setText(str_215);
    }
}