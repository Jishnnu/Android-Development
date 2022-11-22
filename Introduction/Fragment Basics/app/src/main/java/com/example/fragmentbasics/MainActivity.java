package com.example.fragmentbasics;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button bluebtn_215, blackbtn_215, redbtn_215;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        blackbtn_215 = findViewById(R.id.blackbtn_215);
        bluebtn_215 = findViewById(R.id.bluebtn_215);
        redbtn_215 = findViewById(R.id.redbtn_215);

        blackbtn_215.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment fragment_215 = new Fragment_02();
                FragmentManager fm_215 = getSupportFragmentManager();
                FragmentTransaction ft_215 = fm_215.beginTransaction();
                ft_215.replace(R.id.fragment_215, fragment_215);
                ft_215.commit();
            }
        });

        bluebtn_215.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment fragment_215 = new Fragment_01();
                FragmentManager fm_215 = getSupportFragmentManager();
                FragmentTransaction ft_215 = fm_215.beginTransaction();
                ft_215.replace(R.id.fragment_215, fragment_215);
                ft_215.commit();
            }
        });

        redbtn_215.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment fragment_215 = new Fragment_03();
                FragmentManager fm_215 = getSupportFragmentManager();
                FragmentTransaction ft_215 = fm_215.beginTransaction();
                ft_215.replace(R.id.fragment_215, fragment_215);
                ft_215.commit();
            }
        });
    }
}