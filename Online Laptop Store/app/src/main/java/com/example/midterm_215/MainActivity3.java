package com.example.midterm_215;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity3 extends AppCompatActivity {

    Button confirm_215;
    TextView confirmation_215;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        // ID CASCADING
        confirm_215 = findViewById(R.id.confirm_215);
        confirmation_215 = findViewById(R.id.confirmation_215);

        Intent intent = getIntent();
        String str_215 = intent.getStringExtra("confirmation_215");
        confirmation_215.setText(str_215);

        confirm_215.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    Fragment fragment_215 = new Confirm_Fragment_215();
                    FragmentManager fm_215 = getSupportFragmentManager();
                    FragmentTransaction ft_215 = fm_215.beginTransaction();
                    ft_215.replace(R.id.fragment_215, fragment_215);
                    ft_215.commit();
            }
        });
    }
}