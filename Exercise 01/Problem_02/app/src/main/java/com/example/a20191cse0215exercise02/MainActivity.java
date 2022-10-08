package com.example.a20191cse0215exercise02;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btn_215;
    EditText ed_215;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn_215 = findViewById(R.id.button_215);
        ed_215 = findViewById(R.id.name_215);

        btn_215.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    String msg = ed_215.getText().toString();
                    Toast.makeText(MainActivity.this, "Welcome " + msg, Toast.LENGTH_SHORT).show();
                }
                catch (Exception e){
                    Toast.makeText(MainActivity.this, "Invalid Input", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}