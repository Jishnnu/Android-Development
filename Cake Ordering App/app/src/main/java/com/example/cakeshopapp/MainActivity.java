package com.example.cakeshopapp;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity implements DatePickerDialog.OnDateSetListener{
    CheckBox marble_215, chocolate_215, velvet_215, cookie_215, ice_215, cheese_215;
    EditText name_215, contact_215, msg_215, time_215, date_215;
    AutoCompleteTextView cutlery_215;
    Button btn_215;
    String day, time;
    String list_215[] = {"Yes", "No"};
    int i = 100;

    public static final String capitalize(String str)
    {
        if (str == null || str.length() == 0) return str;
        return str.substring(0, 1).toUpperCase() + str.substring(1);
    }

    public void hide(){
        name_215.setText("");
        name_215.requestFocus();
        contact_215.setText("");
        marble_215.setChecked(false);
        chocolate_215.setChecked(false);
        velvet_215.setChecked(false);
        cookie_215.setChecked(false);
        ice_215.setChecked(false);
        cheese_215.setChecked(false);
        time_215.setText("");
        msg_215.setText("");
        cutlery_215.setText("");
        date_215.setText("");
    }

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        marble_215 = findViewById(R.id.marble_215);
        chocolate_215 = findViewById(R.id.chocolate_215);
        velvet_215 = findViewById(R.id.velvet_215);
        cookie_215 = findViewById(R.id.cookie_215);
        ice_215 = findViewById(R.id.ice_215);
        cheese_215 = findViewById(R.id.cheese_215);
        btn_215 = findViewById(R.id.btn_215);
        name_215 = findViewById(R.id.name_215);
        date_215 = findViewById(R.id.date_215);
        cutlery_215 = findViewById(R.id.cutlery_215);
        time_215 = findViewById(R.id.time_215);
        msg_215 = findViewById(R.id.msg_215);
        contact_215 = findViewById(R.id.contact_215);

        ArrayAdapter adapter_215 = new ArrayAdapter(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, list_215);
        cutlery_215.setThreshold(1);
        cutlery_215.setAdapter(adapter_215);

        date_215.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatePickerDialog dpd_215 = new DatePickerDialog(MainActivity.this, MainActivity.this, Calendar.getInstance().get(Calendar.YEAR),
                        Calendar.getInstance().get(Calendar.MONTH), Calendar.getInstance().get(Calendar.DAY_OF_MONTH));

                dpd_215.getDatePicker().setMinDate(System.currentTimeMillis());
                dpd_215.show();
            }
        });

        time_215.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TimePickerDialog tpd_215 = new TimePickerDialog(MainActivity.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int hour, int min) {
                        time = hour + ":" + min;
                        time_215.setText(time);
                    }
                }, Calendar.getInstance().get(Calendar.HOUR_OF_DAY), Calendar.getInstance().get(Calendar.MINUTE), false);
                tpd_215.show();
            }
        });

        btn_215.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try{
                    int total = 0;
                    StringBuilder s_215 = new StringBuilder();
                    s_215.append("BOOKING ID : " + (i++) + "\nNAME : " + capitalize(name_215.getText().toString()) + "\nCONTACT : "
                            + contact_215.getText().toString() + "\n\nORDER SUMMARY : \n");
                    if(marble_215.isChecked()) {
                        s_215.append("Marble Cake \n"); total += 300;
                    }
                    if(chocolate_215.isChecked()) {
                        s_215.append("Chocolate Cake\n"); total += 1100;
                    }
                    if(velvet_215.isChecked()) {
                        s_215.append("Red Velvet Cake\n"); total += 1375;
                    }
                    if(cookie_215.isChecked()) {
                        s_215.append("Cookie Cake\n"); total += 800;
                    }
                    if(ice_215.isChecked()) {
                        s_215.append("Ice Cream Cake\n"); total += 700;
                    }
                    if(cheese_215.isChecked()) {
                        s_215.append("Cheesecake\n"); total += 1000;
                    }
                    s_215.append("\nTOTAL PRICE : ₹. " + total + "\nSPECIAL MESSAGE : " + capitalize(msg_215.getText().toString()) + "\nCUTLERY : " + capitalize(cutlery_215.getText().toString())+ "\nDATE OF DELIVERY  : " + day + "\nTIME OF DELIVERY : " + time);

                    if(name_215.getText().toString() == null || cutlery_215.getText().toString() == null || msg_215.getText().toString() == null || time == null || total == 0 || day == null || contact_215.getText().toString()== null || contact_215.getText().toString().length() > 10  || contact_215.getText().toString().length() < 10 || (!marble_215.isChecked() &&
                            !chocolate_215.isChecked() && !velvet_215.isChecked() && !cookie_215.isChecked() && !ice_215.isChecked()
                            && !cheese_215.isChecked())){
                        Toast.makeText(MainActivity.this, "Missing fields or incorrect input. Please fill in all the slots correctly", Toast.LENGTH_SHORT).show();
                        name_215.requestFocus();
                    }
                    else{
                        Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                        intent.putExtra("booking_confirmation", s_215.toString());
                        startActivity(intent);
                        for(int i = 0; i < 500000; i++){
                            //Delay
                        }
                        hide();
                    }
                }
                catch(Exception ex){
                    Toast.makeText(MainActivity.this, "Invalid Order Placed", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }

    @Override
    public void onDateSet(DatePicker datePicker, int year, int month, int date) {
        day = (month + 1) + "/" + date + "/" + year;
        date_215.setText(day);
    }
}