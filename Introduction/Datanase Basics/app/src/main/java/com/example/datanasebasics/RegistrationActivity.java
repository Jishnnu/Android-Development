package com.example.datanasebasics;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegistrationActivity extends AppCompatActivity {

    EditText un, pw, cpw;
    Button register;
    DatabaseHelper_215 db_215;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        db_215 = new DatabaseHelper_215(this);
        un = findViewById(R.id.r_un_215);
        pw = findViewById(R.id.rpw_215);
        cpw = findViewById(R.id.cnf_pw_215);
        register = findViewById(R.id.register_215);

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                insertData_215();
            }
        });
    }

    private void insertData_215() {
        boolean isUpdated, res;

        if(un != null && pw != null && cpw != null){
            res = db_215.loginCheck_215(un.getText().toString(), pw.getText().toString());
            if(res == false){
                if(pw.getText().toString().equals(cpw.getText().toString())){
                    isUpdated = db_215.insert_215(un.getText().toString(), cpw.getText().toString());
                    if(isUpdated == true){
                        Toast.makeText(this, "DATA INSERTED SUCCESSFULLY", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(RegistrationActivity.this, MainActivity.class);
                        clearInsert();
                        startActivity(intent);
                    }
                    else{
                        Toast.makeText(this, "UNABLE TO UPDATE DATA", Toast.LENGTH_SHORT).show();
                        clearInsert();
                    }
                }
                else{
                    Toast.makeText(this, "Password Mismatch", Toast.LENGTH_SHORT).show();
                    clearInsert();
                }
            }
            else{
                Toast.makeText(this, "User already exists", Toast.LENGTH_SHORT).show();
                clearInsert();
            }
        }
        else{
            Toast.makeText(RegistrationActivity.this, "Invalid/Inconsistent Entries. Please check and try again", Toast.LENGTH_SHORT).show();
            clearInsert();
        }
    }

    private void clearInsert() {
        un.setText("");
        pw.setText("");
        cpw.setText("");
        un.setFocusable(true);
    }
}