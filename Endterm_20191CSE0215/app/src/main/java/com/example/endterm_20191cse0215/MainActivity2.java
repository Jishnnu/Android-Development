package com.example.endterm_20191cse0215;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity2 extends AppCompatActivity {
    DatabaseHelper_215 db_215;
    Button np_215, maleStudents_215, lessThan25_215, studentList_215;

    public void displayCompleteData_215(){
        Cursor res_215 = db_215.getData_215();
        if(res_215.getCount() == 0){
            showData("ERROR", "NO RECORDS FOUND");
        }
        StringBuffer sb_215 = new StringBuffer();
        while(res_215.moveToNext()){
            sb_215.append("\n\nNAME : " + res_215.getString(0));
            sb_215.append("\nROLL NUMBER : " + res_215.getString(1));
            sb_215.append("\nATTENDANCE PERCENTAGE : " + res_215.getString(2));
            sb_215.append("\nGENDER : " + res_215.getString(3));
        }
        showData("STUDENT ATTENDANCE REGISTER", sb_215.toString());
    }

    public void displayNPAttendance_215(){
        Cursor res_215 = db_215.getData_215();
        if(res_215.getCount() == 0){
            showData("ERROR", "NO RECORDS FOUND");
        }

        StringBuffer sb_215 = new StringBuffer();
        int att_215 = Integer.parseInt(res_215.getString(2));

            while(res_215.moveToNext()){
                if(att_215 < 65){
                sb_215.append("\n\nNAME : " + res_215.getString(0));
                sb_215.append("\nROLL NUMBER : " + res_215.getString(1));
                sb_215.append("\nATTENDANCE PERCENTAGE : " + res_215.getString(2));
                sb_215.append("\nGENDER : " + res_215.getString(3));
            }
        }
        showData("STUDENTS FALLING UNDER NP", sb_215.toString());
    }

    public void display25Attendance_215(){
        Cursor res_215 = db_215.getData_215();
        int count = 0;
        if(res_215.getCount() == 0){
            showData("ERROR", "NO RECORDS FOUND");
        }

        StringBuffer sb_215 = new StringBuffer();
        int att_215 = Integer.parseInt(res_215.getString(2));

            while(res_215.moveToNext()){
                if(att_215 < 25){
                sb_215.append("\n\nNAME : " + res_215.getString(0));
                sb_215.append("\nROLL NUMBER : " + res_215.getString(1));
                sb_215.append("\nATTENDANCE PERCENTAGE : " + res_215.getString(2));
                sb_215.append("\nGENDER : " + res_215.getString(3));
                count++;
            }
        }
        sb_215.append("\n\nTOTAL STUDENTS : " + count);
        showData("STUDENTS WITH LESS THAN 25 % ATTENDANCE", sb_215.toString());
    }

    public void displayMaleStudents_215(){
        Cursor res_215 = db_215.getData_215();
        if(res_215.getCount() == 0){
            showData("ERROR", "NO RECORDS FOUND");
        }

        StringBuffer sb_215 = new StringBuffer();
        String gen_215 = res_215.getString(3);


            while(res_215.moveToNext()){
                if(gen_215.equalsIgnoreCase("Male")){
                sb_215.append("\n\nNAME : " + res_215.getString(0));
                sb_215.append("\nROLL NUMBER : " + res_215.getString(1));
                sb_215.append("\nATTENDANCE PERCENTAGE : " + res_215.getString(2));
            }
        }
        showData("MALE STUDENTS", sb_215.toString());
    }

    private void showData(String title, String msg) {
        AlertDialog.Builder builder_215 = new AlertDialog.Builder(this);
        builder_215.setCancelable(true);
        builder_215.setTitle(title);
        builder_215.setMessage(msg);
        builder_215.show();
    }

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        db_215 = new DatabaseHelper_215(this);
        np_215 = findViewById(R.id.np_215);
        maleStudents_215 = findViewById(R.id.maleStudents_215);
        lessThan25_215 = findViewById(R.id.lessThan25_215);
        studentList_215 = findViewById(R.id.studentList_215);

        np_215.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                displayNPAttendance_215();
            }
        });

        maleStudents_215.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                displayMaleStudents_215();
            }
        });

        lessThan25_215.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                display25Attendance_215();
            }
        });

        studentList_215.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                displayCompleteData_215();
            }
        });
    }
}