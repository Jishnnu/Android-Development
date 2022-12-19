package com.example.datanasebasics;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class DeleteActivity extends AppCompatActivity {

    DatabaseHelper_215 db_215;
    EditText delete_un;
    Button del;
    String id;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete);
        db_215 = new DatabaseHelper_215(this);
        delete_un = findViewById(R.id.idDelete_215);
        del = findViewById(R.id.sanctionDelete);
        del.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                deleteData_215();
            }
        });

    }

    public void deleteData_215(){
        Integer count;
        if(delete_un != null){
            count = db_215.delete_215(delete_un.getText().toString());
            if(count > 0){
                Toast.makeText(this, "DATA DELETION SUCCESSFUL", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(DeleteActivity.this, MainActivity.class);
                startActivity(intent);
            }
            else{
                Toast.makeText(this, "DATA DELETION UNSUCCESSFUL", Toast.LENGTH_SHORT).show();
            }
        }
        else{
            Toast.makeText(DeleteActivity.this, "Invalid/Inconsistent Entries. Please check and try again", Toast.LENGTH_SHORT).show();
            clearDelete();
            delete_un.setFocusable(true);
        }
    }

    private void clearDelete() {
        delete_un.setText("");
        delete_un.setFocusable(true);
    }
}