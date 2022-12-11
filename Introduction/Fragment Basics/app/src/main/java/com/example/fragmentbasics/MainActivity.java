package com.example.fragmentbasics;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button bluebtn_215, blackbtn_215, redbtn_215;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater mi_215 = getMenuInflater();
        mi_215.inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.frameLayout_215:
                Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                startActivity(intent);
                return true;

            default: return super.onOptionsItemSelected(item);
        }
    }

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