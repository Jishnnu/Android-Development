package com.example.fragmentframelayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    ImageView apple_215, berry_215, orange_215;
    FrameLayout frameLayout_215;

    public void show(){frameLayout_215.setVisibility(View.VISIBLE);}

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        apple_215 = findViewById(R.id.apple_215);
        berry_215 = findViewById(R.id.blueberry_215);
        orange_215 = findViewById(R.id.orange_215);
        frameLayout_215 = findViewById(R.id.frame_215);

        apple_215.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment frame_215 = new Fragment_Apple();
                FragmentManager fm_215 = getSupportFragmentManager();
                FragmentTransaction ft_215 = fm_215.beginTransaction();
                ft_215.replace(R.id.frame_215, frame_215);
                ft_215.commit();
                show();
            }
        });

        berry_215.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment frame_215 = new Fragment_Blueberry();
                FragmentManager fm_215 = getSupportFragmentManager();
                FragmentTransaction ft_215 = fm_215.beginTransaction();
                ft_215.replace(R.id.frame_215, frame_215);
                ft_215.commit();
                show();
            }
        });

        orange_215.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment frame_215 = new Fragment_Orange();
                FragmentManager fm_215 = getSupportFragmentManager();
                FragmentTransaction ft_215 = fm_215.beginTransaction();
                ft_215.replace(R.id.frame_215, frame_215);
                ft_215.commit();
                show();
            }
        });
    }
}