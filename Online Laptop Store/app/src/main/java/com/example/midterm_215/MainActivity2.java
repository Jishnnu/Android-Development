package com.example.midterm_215;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {

    EditText name_215, contact_215;
    Button submit_215;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        // ID CASCADING
        name_215 = findViewById(R.id.name_215);
        contact_215 = findViewById(R.id.contact_215);
        submit_215 = findViewById(R.id.submit_215);

        Intent intent = getIntent();
        String str_215 = intent.getStringExtra("order_summary_215");

        submit_215.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                StringBuilder s_215 = new StringBuilder();
                s_215.append("NAME : " + name_215.getText().toString() + "\nCONTACT : " + contact_215.getText().toString() + "\n\n" + str_215);
                if(name_215.getText().toString() == null || contact_215.getText().toString() == null  || contact_215.getText().toString().length() < 10){
                    Toast.makeText(MainActivity2.this, "Missing fields or incorrect input. Please fill in all the slots correctly", Toast.LENGTH_SHORT).show();
                }
                else{
                    // TO TRANSFER CONTROL TO ANOTHER ACTIVITY
                    Intent intent = new Intent(MainActivity2.this, MainActivity3.class);
                    intent.putExtra("confirmation_215", s_215.toString());
                    startActivity(intent);
                }
            }
        });
    }
}