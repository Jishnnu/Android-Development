package com.example.a20191cse0215exercise03;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText ed1_215, ed2_215;
    Button btn_215;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ed1_215 = findViewById(R.id.num1_215);
        ed2_215 = findViewById(R.id.num2_215);
        btn_215 = findViewById(R.id.button_215);

        btn_215.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try{
                    Double n1_215 = Double.parseDouble(ed1_215.getText().toString());
                    Double n2_215 = Double.parseDouble(ed2_215.getText().toString());
                    Double result_215 = n1_215 + n2_215;
                    Toast.makeText(MainActivity.this, "SUM = " + result_215.toString(), Toast.LENGTH_LONG).show();
                }
                catch (Exception e){
                    Toast.makeText(MainActivity.this, "Invalid Input", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}