package com.example.cakeshopapp;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity implements DatePickerDialog.OnDateSetListener{
    CheckBox marble_215, chocolate_215, velvet_215, cookie_215, ice_215, cheese_215;
    EditText name_215;
    TextView order_215, confirmation_text_215;
    DatePicker date_215;
    Button btn_215, reset_215;
    ListView list_215;
    ArrayList arr_list_215;
    ArrayAdapter list_adapter_215;
    String day;
    int i = 1;

    public static final String capitalize(String str)
    {
        if (str == null || str.length() == 0) return str;
        return str.substring(0, 1).toUpperCase() + str.substring(1);
    }

    public void show() {
        order_215.setVisibility(View.VISIBLE);
        confirmation_text_215.setVisibility(View.VISIBLE);
    }
    public void hide(){
        order_215.setVisibility(View.INVISIBLE);
        confirmation_text_215.setVisibility(View.INVISIBLE);
        marble_215.setChecked(false);
        chocolate_215.setChecked(false);
        velvet_215.setChecked(false);
        cookie_215.setChecked(false);
        ice_215.setChecked(false);
        cheese_215.setChecked(false);
        name_215.setText("");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        order_215 = findViewById(R.id.order_215);
        marble_215 = findViewById(R.id.marble_215);
        chocolate_215 = findViewById(R.id.chocolate_215);
        velvet_215 = findViewById(R.id.velvet_215);
        cookie_215 = findViewById(R.id.cookie_215);
        ice_215 = findViewById(R.id.ice_215);
        cheese_215 = findViewById(R.id.cheese_215);
        btn_215 = findViewById(R.id.btn_215);
        name_215 = findViewById(R.id.name_215);
        reset_215 = findViewById(R.id.reset_215);
        confirmation_text_215 = findViewById(R.id.confirmation_textview_215);
        date_215 = findViewById(R.id.date_215);

        date_215.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatePickerDialog dpd_215 = new DatePickerDialog(MainActivity.this, MainActivity.this, Calendar.getInstance().get(Calendar.YEAR),
                        Calendar.getInstance().get(Calendar.MONTH), Calendar.getInstance().get(Calendar.DAY_OF_MONTH));

                dpd_215.getDatePicker().setMinDate(System.currentTimeMillis());
                dpd_215.show();
            }
        });

        btn_215.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try{
                    int total = 0;
                    confirmation_text_215.setText("Booking Confirmation [Order ID : " + (i++) + "]");
                    StringBuilder s_215 = new StringBuilder();
                    s_215.append("NAME : " + capitalize(name_215.getText().toString()) + "\nORDER : \n");
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
                    s_215.append("PRICE : RS. " + total + "\nDATE OF DELIVERY  : " + day);

                    order_215.setText(s_215);
                    order_215.setMovementMethod(new ScrollingMovementMethod());
                    show();
                }
                catch(Exception ex){
                    Toast.makeText(MainActivity.this, "Invalid Order Placed", Toast.LENGTH_SHORT).show();
                }

            }
        });

        reset_215.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                hide();
            }
        });
    }

    @Override
    public void onDateSet(DatePicker datePicker, int year, int month, int date) {
        day = (month + 1) + "/" + date + "/" + year;
    }
}