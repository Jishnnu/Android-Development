package com.example.musicapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.NotificationManager;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;


public class MainActivity2 extends AppCompatActivity {
    SharedPreferences sp;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        NotificationManager nm_215 = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        nm_215.cancel(100);
    }
}
