package com.example.endterm_attendance_app_215;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    DatabaseHelper_215 db_215;
    Button submit_215, next_215;
    EditText name_215, roll_215, attendance_215;
    RadioGroup genderGroup_215;
    RadioButton gender_215;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        db_215 = new DatabaseHelper_215(this);
        submit_215 = findViewById(R.id.submit_215);
        next_215 = findViewById(R.id.next_215);
        name_215 = findViewById(R.id.name_215);
        roll_215 = findViewById(R.id.roll_215);
        attendance_215 = findViewById(R.id.attendance_215);
        genderGroup_215 = findViewById(R.id.radioGroup_215);

        submit_215.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gender_215 = (RadioButton) findViewById(genderGroup_215.getCheckedRadioButtonId());
                insertData_215();
            }
        });

        next_215.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent_215 = new Intent(MainActivity.this, MainActivity2.class);
                startActivity(intent_215);
            }
        });
    }

    private void clearInsert() {
        name_215.setText("");
        roll_215.setText("");
        attendance_215.setText("");
        name_215.setFocusable(true);
    }

    private void insertData_215() {
        boolean isInserted_215;
        if(name_215 != null && roll_215 != null && attendance_215 != null && gender_215 != null){
                isInserted_215 = db_215.insert_215(name_215.getText().toString(), roll_215.getText().toString(), Integer.parseInt(attendance_215.getText().toString()), gender_215.getText().toString());
                if(isInserted_215 == true){
                    Toast.makeText(this, "DATA INSERTED SUCCESSFULLY", Toast.LENGTH_SHORT).show();
                    Intent intent_215 = new Intent(MainActivity.this, MainActivity2.class);
                    clearInsert();
                    startActivity(intent_215);
                }
                else{
                    Toast.makeText(this, "UNABLE TO INSERT DATA", Toast.LENGTH_SHORT).show();
                    clearInsert();
                }
        }
        else{
            Toast.makeText(MainActivity.this, "Invalid/Inconsistent Entries. Please check and try again", Toast.LENGTH_SHORT).show();
            clearInsert();
        }
    }
}