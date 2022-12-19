package com.example.datanasebasics;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class UpdateActivity extends AppCompatActivity {

    DatabaseHelper_215 db_215;
    EditText update_un, update_pw, id;
    Button update;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);
        db_215 = new DatabaseHelper_215(this);
        update_un = findViewById(R.id.usernameUpdate_215);
        update_pw = findViewById(R.id.pwdUpdate_215);
        update = findViewById(R.id.sanctionUpdate);
        id = findViewById(R.id.idd);

        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateData_215();
            }
        });
    }

    public void updateData_215(){
        boolean isUpdated, res;
        if(update_un != null && update_pw != null){
            res = db_215.loginCheck_215(update_un.getText().toString(), update_pw.getText().toString());
            if(res == false){
                isUpdated = db_215.update_215(id.getText().toString(), update_un.getText().toString(), update_pw.getText().toString());
                if(isUpdated == true){
                    Toast.makeText(this, "DATA UPDATED SUCCESSFULLY", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(UpdateActivity.this, AdminProfile.class);
                    clearUpdate();
                    startActivity(intent);
                }
                else{
                    Toast.makeText(this, "UNABLE TO UPDATE DATA", Toast.LENGTH_SHORT).show();
                    clearUpdate();
                }
            }
            else{
                Toast.makeText(this, "Identical credentials already exists", Toast.LENGTH_SHORT).show();
                clearUpdate();
            }
        }
        else{
            Toast.makeText(UpdateActivity.this, "Invalid/Inconsistent Entries. Please check and try again", Toast.LENGTH_SHORT).show();
            clearUpdate();
        }
    }

    private void clearUpdate() {
        update_un.setText("");
        update_pw.setText("");
        update_un.setFocusable(true);
    }
}