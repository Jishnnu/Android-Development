package com.example.exercise0220191cse0215;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText h_215, w_215;
    Button btn_215;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        h_215 = findViewById(R.id.height_215);
        w_215 = findViewById(R.id.weight_215);
        btn_215 = findViewById(R.id.button_215);

        btn_215.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Double height_215 = Double.parseDouble(h_215.getText().toString());
                    Double weight_215 = Double.parseDouble(w_215.getText().toString());
                    Double bmi_215 = ((weight_215 / height_215) / height_215) * 10000;
                    if(bmi_215 <= 18.4){
                        Toast.makeText(MainActivity.this, "BMI : " + bmi_215 + "\nYou are in the UNDERWEIGHT Category", Toast.LENGTH_SHORT).show();
                    }
                    else if(bmi_215 >= 18.5 && bmi_215 <= 24.9){
                        Toast.makeText(MainActivity.this, "BMI : " + bmi_215 + "\nYou are in the NORMAL Category", Toast.LENGTH_SHORT).show();
                    }
                    else if(bmi_215 >= 25.0 && bmi_215 <= 39.9){
                        Toast.makeText(MainActivity.this, "BMI : " + bmi_215 + "\nYou are in the OVERWEIGHT Category", Toast.LENGTH_SHORT).show();
                    }
                    else if(bmi_215 >= 40.0){
                        Toast.makeText(MainActivity.this, "BMI : " + bmi_215 + "\nYou are in the OBESE Category", Toast.LENGTH_SHORT).show();
                    }
                    else{
                        Toast.makeText(MainActivity.this, "BMI : " + bmi_215 + "You don't fall in any of the BMI Category", Toast.LENGTH_SHORT).show();
                    }
                }
                catch (Exception e){
                    Toast.makeText(MainActivity.this, "Invalid Input", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}