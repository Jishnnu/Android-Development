package com.example.a20191cse0215_student_registration;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.sql.Time;
import java.util.Timer;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    EditText name_215, age_215;
    AutoCompleteTextView gender_215;
    Spinner course_215;
    Button btn_215;
    TextView result_215;
    String genderOptions_215[] = {"Male", "Female", "Transgender"};
    String courseOptions_215[] = {"CSE", "CCE", "ISE", "IST", "CIV", "ECE", "EEE", "MEC", "PET", "BCA", "BCOM", "BBA", "MBA", "LLB", "LLM"};
    public String selectedCourse_215;

    public void show(){
        result_215.setVisibility(View.VISIBLE);
    }

    public void hide(){
        result_215.setVisibility(View.INVISIBLE);
    }

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        name_215 = findViewById(R.id.name_215);
        age_215 = findViewById(R.id.age_215);
        course_215 = findViewById(R.id.course_215);
        gender_215 = findViewById(R.id.gender_215);
        btn_215 = findViewById(R.id.button_215);
        result_215 = findViewById(R.id.result_215);

        name_215.setFocusable(true);

        ArrayAdapter genderAdapter_215 = new ArrayAdapter(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, genderOptions_215);
        gender_215.setThreshold(1);
        gender_215.setAdapter(genderAdapter_215);

        course_215.setOnItemSelectedListener(this);
        ArrayAdapter courseAdapter_215 = new ArrayAdapter(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, courseOptions_215);
        courseAdapter_215.setDropDownViewResource(androidx.appcompat.R.layout.support_simple_spinner_dropdown_item);
        course_215.setAdapter(courseAdapter_215);

        btn_215.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                result_215.setText("Successfully Enrolled " + name_215.getText().toString().toUpperCase() + " into " + selectedCourse_215);
                show();
            }
        });
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        selectedCourse_215 = (String) course_215.getItemAtPosition(i);
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}