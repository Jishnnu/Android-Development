package com.example.datanasebasics;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity{

    DatabaseHelper_215 db_215;
    Button login_215;
    EditText un_215, pwd_215;
    TextView reg;

    public void clear(){
        un_215.setText("");
        pwd_215.setText("");
    }

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        db_215 = new DatabaseHelper_215(this);
        un_215 = findViewById(R.id.username_215);
        pwd_215 = findViewById(R.id.password_215);
        login_215 = findViewById(R.id.login_215);
        reg = findViewById(R.id.toRegister_215);

        login_215.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(un_215 != null && pwd_215 != null){
                    boolean res = db_215.loginCheck_215(un_215.getText().toString(), pwd_215.getText().toString());
                    if(res == true){
                        Toast.makeText(MainActivity.this, "LOGIN SUCCESSFUL", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(MainActivity.this, AdminProfile.class);
                        clear();
                        startActivity(intent);
                    }
                    else{
                        Toast.makeText(MainActivity.this, "Please Sign Up if you are new here", Toast.LENGTH_SHORT).show();
                        clear();
                    }
                }
                else{
                    Toast.makeText(MainActivity.this, "Necessary fields empty", Toast.LENGTH_SHORT).show();
                    clear();
                }
            }
        });

        reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, RegistrationActivity.class);
                startActivity(intent);
            }
        });
    }
}