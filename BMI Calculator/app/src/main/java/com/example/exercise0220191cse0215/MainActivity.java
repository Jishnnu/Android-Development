package com.example.exercise0220191cse0215;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText h_215, w_215;
    Button btn_215;
    RadioButton rbh_215, rbw_215;
    RadioGroup rgh_215, rgw_215;

    public void calculate_215(Double weight_215, Double height_215){
        try {
            Double bmi_215 = ((weight_215 / height_215) / height_215) * 10000;
            if (bmi_215 <= 18.4) {
                Toast.makeText(MainActivity.this, "BMI : " + bmi_215 + "\nYou are in the UNDERWEIGHT Category", Toast.LENGTH_SHORT).show();
            } else if (bmi_215 >= 18.5 && bmi_215 <= 24.9) {
                Toast.makeText(MainActivity.this, "BMI : " + bmi_215 + "\nYou are in the NORMAL Category", Toast.LENGTH_SHORT).show();
            } else if (bmi_215 >= 25.0 && bmi_215 <= 39.9) {
                Toast.makeText(MainActivity.this, "BMI : " + bmi_215 + "\nYou are in the OVERWEIGHT Category", Toast.LENGTH_SHORT).show();
            } else if (bmi_215 >= 40.0) {
                Toast.makeText(MainActivity.this, "BMI : " + bmi_215 + "\nYou are in the OBESE Category", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(MainActivity.this, "BMI : " + bmi_215 + "You don't fall in any of the BMI Category", Toast.LENGTH_SHORT).show();
            }
        }
        catch (Exception e){
            Toast.makeText(MainActivity.this, "Invalid Input", Toast.LENGTH_SHORT).show();
        }
    }

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        h_215 = findViewById(R.id.height_215);
        w_215 = findViewById(R.id.weight_215);
        btn_215 = findViewById(R.id.button_215);
        rgh_215 = findViewById(R.id.heightGroup_215);
        rbh_215 = findViewById(rgh_215.getCheckedRadioButtonId());

        btn_215.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    rbh_215 = findViewById(rgh_215.getCheckedRadioButtonId());
                    Double height_215 = Double.parseDouble(h_215.getText().toString());
                    Double weight_215 = Double.parseDouble(w_215.getText().toString());
                    if(rbh_215.getText().toString().equals("m")){
                        calculate_215(weight_215, (height_215 * 100));
                    }
                    else if(rbh_215.getText().toString().equals("ft")){
                        calculate_215(weight_215, (height_215 * 30.48));
                    }
                    else if(rbh_215.getText().toString().equals("in")){
                        calculate_215(weight_215, (height_215  * 2.54));
                    }
                    else {
                        calculate_215(weight_215, height_215);
                    }
                }
                catch (Exception e){
                    Toast.makeText(MainActivity.this, "Invalid Input", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}