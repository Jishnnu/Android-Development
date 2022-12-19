package com.example.datanasebasics;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class AdminProfile extends AppCompatActivity {

    DatabaseHelper_215 db_215;
    Button update_215, delete_215;
    TextView id_215, un_215, pw_215;
    EditText delete_un;
    ImageView img;

    public void clearDelete(){
        delete_un.setText("");
    }


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_profile);
        db_215 = new DatabaseHelper_215(this);
        update_215 = findViewById(R.id.update_215);
        delete_215 = findViewById(R.id.delete_215);
        id_215 = findViewById(R.id.id_215);
        un_215 = findViewById(R.id.un_215);
        pw_215 = findViewById(R.id.pw_215);
        delete_un = findViewById(R.id.idDelete_215);
        img = findViewById(R.id.imageView);

        display();

        update_215.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AdminProfile.this, UpdateActivity.class);
                startActivity(intent);
            }
        });

        delete_215.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AdminProfile.this, DeleteActivity.class);
                startActivity(intent);
            }
        });
    }

    public void display(){
        Cursor res = db_215.getData_215();

        while(res.moveToNext()){
            id_215.setText("USER ID : " + res.getString(0));
            un_215.setText("USERNAME : " + res.getString(1));
            pw_215.setText("PASSWORD : " + res.getString(2));
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        display();
    }

    @Override
    protected void onStart() {
        super.onStart();
        display();
    }

    @Override
    protected void onPause() {
        super.onPause();
        display();
    }
}