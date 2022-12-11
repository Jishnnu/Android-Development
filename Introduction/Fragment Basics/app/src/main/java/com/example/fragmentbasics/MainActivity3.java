package com.example.fragmentbasics;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.Toast;

public class MainActivity3 extends AppCompatActivity {
    RatingBar rating_215;
    Button btn_215;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        rating_215 = findViewById(R.id.rating_215);
        btn_215 = findViewById(R.id.btn_215);

        btn_215.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String rating = String.valueOf(rating_215.getRating());
                Toast.makeText(MainActivity3.this, "Your Rating : " + rating, Toast.LENGTH_SHORT).show();
            }
        });
    }
}