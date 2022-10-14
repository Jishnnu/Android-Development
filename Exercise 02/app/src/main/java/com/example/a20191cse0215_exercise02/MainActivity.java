package com.example.a20191cse0215_exercise02;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button add_215, sub_215, mul_215, div_215, mod_215, clear_215;
    EditText num1_215, num2_215;
    TextView ans_215;
    public Double n1_215, n2_215, result_215;

    public void show(){
        ans_215.setVisibility(View.VISIBLE);
    }

    public void hide(){
        ans_215.setVisibility(View.INVISIBLE);
    }

    public void read(){
        n1_215 = Double.parseDouble(num1_215.getText().toString());
        n2_215 = Double.parseDouble(num2_215.getText().toString());
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        add_215 = findViewById(R.id.add_215);
        sub_215 = findViewById(R.id.sub_215);
        mul_215 = findViewById(R.id.mul_215);
        div_215 = findViewById(R.id.div_215);
        mod_215 = findViewById(R.id.mod_215);
        clear_215 = findViewById(R.id.clear_215);
        num1_215 = findViewById(R.id.num1_215);
        num2_215 = findViewById(R.id.num2_215);
        ans_215 = findViewById(R.id.ans_215);

        //ADDITION
        add_215.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try{
                    read();
                    result_215 = n1_215 + n2_215;
                    ans_215.setText("SUM : " + result_215);
                    show();
                }
                catch (Exception e){
                    hide();
                    Toast.makeText(MainActivity.this, "Invalid Input", Toast.LENGTH_SHORT).show();
                }
            }
        });

        //SUBTRACTION
        sub_215.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try{
                    read();
                    result_215 = n1_215 - n2_215;
                    ans_215.setText("DIIFERENCE : " + result_215);
                    show();
                }
                catch (Exception e){
                    hide();
                    Toast.makeText(MainActivity.this, "Invalid Input", Toast.LENGTH_SHORT).show();
                }
            }
        });

        //MULTIPLICATION
        mul_215.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try{
                    read();
                    result_215 = n1_215 * n2_215;
                    ans_215.setText("PRODUCT : " + result_215);
                    show();
                }
                catch (Exception e){
                    hide();
                    Toast.makeText(MainActivity.this, "Invalid Input", Toast.LENGTH_SHORT).show();
                }
            }
        });

        //DIVISION
        div_215.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try{
                    read();
                    result_215 = n1_215 / n2_215;
                    ans_215.setText("QUOTIENT : " + result_215);
                    show();
                }
                catch (Exception e){
                    hide();
                    Toast.makeText(MainActivity.this, "Invalid Input", Toast.LENGTH_SHORT).show();
                }
            }
        });

        //REMAINDER
        mod_215.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try{
                    read();
                    result_215 = n1_215 % n2_215;
                    ans_215.setText("REMAINDER : " + result_215);
                    show();
                }
                catch (Exception e){
                    hide();
                    Toast.makeText(MainActivity.this, "Invalid Input", Toast.LENGTH_SHORT).show();
                }
            }
        });

        //CLEAR
        clear_215.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                hide();
                num1_215.setText("");
                num2_215.setText("");
                num1_215.requestFocus();
            }
        });
    }
}