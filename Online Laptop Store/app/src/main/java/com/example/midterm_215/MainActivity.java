package com.example.midterm_215;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView lenovo_price_215, dell_price_215, mac_price_215, acer_price_215, ms_price_215;
    CheckBox lenovo_215, dell_215, mac_215, acer_215, ms_15;
    Button btn_215;

    // TO HIDE THE SPECIFIED ELEMENTS
    public void clearAll_215(){
        lenovo_215.setChecked(false);
        dell_215.setChecked(false);
        mac_215.setChecked(false);
        acer_215.setChecked(false);
        ms_15.setChecked(false);
    }

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // ID CASCADING
        btn_215 = findViewById(R.id.btn_215);
        mac_215 = findViewById(R.id.mac_215);
        ms_15 = findViewById(R.id.ms_215);
        dell_215 = findViewById(R.id.dell_215);
        acer_215 = findViewById(R.id.acer_215);
        lenovo_215 = findViewById(R.id.lenovo_215);
        mac_price_215 = findViewById(R.id.mac_price_215);
        lenovo_price_215 = findViewById(R.id.lenovo_price_215);
        acer_price_215 = findViewById(R.id.acer_price_215);
        dell_price_215 = findViewById(R.id.dell_price_215);
        ms_price_215 = findViewById(R.id.ms_price_215);

        btn_215.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                float total_215 = 0;
                StringBuilder s_215 = new StringBuilder(); // TO HOLD THE DATA TO BE TRANSFERRED TO ANOTHER ACTIVITY
                s_215.append("ORDER SUMMARY :\n");
                if(lenovo_215.isChecked()){
                    s_215.append("Lenovo IdeaPad Flex 5 \n"); total_215 += 628;
                }
                if(mac_215.isChecked()){
                    s_215.append("MacBook Pro M1 Max \n"); total_215 += 2399;
                }
                if(dell_215.isChecked()){
                    s_215.append("Dell XPS 13 Plus \n"); total_215 += 1399;
                }
                if(ms_15.isChecked()){
                    s_215.append("Microsoft Surface Go 2 \n"); total_215 += 600;
                }
                if(acer_215.isChecked()){
                    s_215.append("Acer Swift 3X \n"); total_215 += 965;
                }
                s_215.append("\nBASE PRICE : $" + total_215);
                s_215.append("\nTAX : 15%");
                total_215 += (total_215 * 0.15);
                s_215.append("\nTOTAL PRICE : $" + total_215);

                if(!lenovo_215.isChecked() && !ms_15.isChecked() && !mac_215.isChecked() && !dell_215.isChecked() && !acer_215.isChecked()){
                    Toast.makeText(MainActivity.this, "Missing fields or incorrect input. Please fill in all the slots correctly", Toast.LENGTH_SHORT).show();
                }
                else{
                    // TO TRANSFER CONTROL TO ANOTHER ACTIVITY
                    Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                    intent.putExtra("order_summary_215", s_215.toString());
                    startActivity(intent);
                    clearAll_215();
                }
            }
        });
    }
}