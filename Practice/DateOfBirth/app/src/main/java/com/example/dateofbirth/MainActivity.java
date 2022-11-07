package com.example.dateofbirth;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ListView;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity implements DatePickerDialog.OnDateSetListener{
    private int mDate, mMonth, mYear;
    DatePicker dob_215, reg_215;
    Button submit_215;
    TextView curr_date_215;
    ListView list_215;
    SimpleDateFormat sdf_215;
    Calendar cal_215;
    ArrayList reg_list_215;
    ArrayAdapter date_adapter_215;
    String dob;
    int i = 1;

    public void show() {
        list_215.setVisibility(View.VISIBLE);
    }

    public void hide(){
        list_215.setVisibility(View.INVISIBLE);
    }

    public String getDate(){
        sdf_215 = new SimpleDateFormat("MM/dd/yyyy");
        cal_215 = Calendar.getInstance();
        return sdf_215.format(cal_215.getTime()).toString();
    }

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        curr_date_215 = (TextView) findViewById(R.id.curr_date_215);
        curr_date_215.setText("Today's Date : " + getDate());
        submit_215 = findViewById(R.id.submit_215);
        dob_215 = findViewById(R.id.dob_215);
        list_215 = findViewById(R.id.list_215);

        final Calendar c = Calendar.getInstance();
        mDate = c.get(Calendar.DATE);
        mMonth= c.get(Calendar.MONTH);
        mYear= c.get(Calendar.YEAR);

        dob_215.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatePickerDialog dpd_215 = new DatePickerDialog(MainActivity.this, MainActivity.this, Calendar.getInstance().get(Calendar.YEAR),
                        Calendar.getInstance().get(Calendar.MONTH), Calendar.getInstance().get(Calendar.DAY_OF_MONTH));

                dpd_215.getDatePicker().setMaxDate(System.currentTimeMillis() - 1000);
                dpd_215.show();
            }
        });

        reg_list_215 = new ArrayList();
        date_adapter_215 = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1, reg_list_215);
        submit_215.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                show();
                reg_list_215.add("DOB OF PERSON " + (i++) + " : " + dob);
                list_215.setAdapter(date_adapter_215);
                date_adapter_215.notifyDataSetChanged();
            }
        });
    }

    @Override
    public void onDateSet(DatePicker datePicker, int year, int month, int date) {
        dob = month + "/" + date + "/" + year;

    }
}