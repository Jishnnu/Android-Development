package com.example.services;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText number;
    Button call, sms;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        number = findViewById(R.id.editTextPhone);
        call = findViewById(R.id.call);
        sms = findViewById(R.id.sms);

        call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                makeCall();
            }
        });

        sms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendSMS();
            }
        });
    }

    public void makeCall() {
        Intent in = new Intent(Intent.ACTION_DIAL);
        String phone = number.getText().toString();
        in.setData(Uri.parse("tel:" + phone));
        startActivity(in);
    }

    public void sendSMS() {
        String phone, msg;
        phone = number.getText().toString();
        msg = number.getText().toString();

        // METHOD 01
        Intent in = new Intent(Intent.ACTION_VIEW);
        in.setData(Uri.parse("sms:" + phone));
        in.putExtra("sms_body", msg);
        startActivity(in);

        // METHOD 02
        //SmsManager sm = SmsManager.getDefault();
        //sm.sendTextMessage(phone, null, msg, null, null);
    }
}