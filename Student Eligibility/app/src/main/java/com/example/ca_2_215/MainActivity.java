package com.example.ca_2_215;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener{

    DatabaseHelper_215 db_215;
    EditText reg_id_215, name_215, phy_marks_215, chem_marks_215, maths_marks_215;
    Button submitBtn_215, displayBtn_215;
    Spinner stateSpinner_215;
    String states_215[] = {"Andhra Pradesh", "Arunachal Pradesh", "Assam", "Bihar", "Chhattisgarh", "Goa", "Gujarat", "Haryana",
            "Himachal Pradesh", "Jammu and Kashmir", "Jharkhand", "Karnataka", "Kerala", "Madhya Pradesh", "Maharashtra", "Manipur", "Meghalaya",
            "Mizoram", "Nagaland", "Odisha", "Punjab", "Rajasthan", "Sikkim", "Tamil Nadu", "Telangana", "Tripura", "Uttar Pradesh", "West Bengal"
    };
    String selectedState_215;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        db_215 = new DatabaseHelper_215(this);
        reg_id_215 = findViewById(R.id.reg_id_215);
        name_215 = findViewById(R.id.name_215);
        phy_marks_215 = findViewById(R.id.phy_215);
        chem_marks_215 = findViewById(R.id.chem_215);
        maths_marks_215 = findViewById(R.id.maths_215);
        stateSpinner_215 = findViewById(R.id.state_215);
        submitBtn_215 = findViewById(R.id.submitBtn_215);
        displayBtn_215 = findViewById(R.id.displayBtn_215);

        stateSpinner_215.setOnItemSelectedListener(this);
        ArrayAdapter stateAdapter_215 = new ArrayAdapter(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, states_215);
        stateAdapter_215.setDropDownViewResource(androidx.appcompat.R.layout.support_simple_spinner_dropdown_item);
        stateSpinner_215.setAdapter(stateAdapter_215);

        submitBtn_215.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                insertData_215();
            }
        });

        displayBtn_215.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                displayData_215();
            }
        });
    }

    public void clearInsert_215(){
        reg_id_215.setText("");
        name_215.setText("");
        phy_marks_215.setText("");
        chem_marks_215.setText("");
        maths_marks_215.setText("");
    }

    private void insertData_215() {
        boolean isUpdated;

        if(reg_id_215 != null && name_215 != null && phy_marks_215 != null && chem_marks_215 != null && maths_marks_215 != null){
            isUpdated = db_215.insert_215(reg_id_215.getText().toString(), name_215.getText().toString(),
                    Integer.parseInt(phy_marks_215.getText().toString()),Integer.parseInt(chem_marks_215.getText().toString()),
                    Integer.parseInt(maths_marks_215.getText().toString()), selectedState_215);

            if(isUpdated == true){
                Toast.makeText(this, "DATA INSERTED SUCCESSFULLY", Toast.LENGTH_SHORT).show();
                clearInsert_215();
            }
            else{
                Toast.makeText(this, "UNABLE TO INSERT DATA", Toast.LENGTH_SHORT).show();
                clearInsert_215();
            }
        }
        else{
            Toast.makeText(MainActivity.this, "Mandatory Fields empty. Please check and try again", Toast.LENGTH_SHORT).show();
            clearInsert_215();
        }
    }

    public void displayData_215(){
        Cursor res = db_215.getData_215();
        if(res.getCount() == 0){
            showData("ERROR", "NO RECORDS FOUND");
        }

        StringBuffer sb_215 = new StringBuffer();
        while(res.moveToNext()){
            int physics_215 = Integer.parseInt(res.getString(2));
            int chemistry_215 = Integer.parseInt(res.getString(3));
            int mathematics_215 = Integer.parseInt(res.getString(4));

            if(physics_215 > 60 && chemistry_215 > 60 && mathematics_215 >60) {
                sb_215.append("\n\nREGISTRATION ID : " + res.getString(0));
                sb_215.append("\nNAME : " + res.getString(1));
                sb_215.append("\nPHYSICS MARKS : " + res.getString(2));
                sb_215.append("\nCHEMISTRY MARKS : " + res.getString(3));
                sb_215.append("\nMATHEMATICS MARKS : " + res.getString(4));
                sb_215.append("\nSTATE : " + res.getString(5));
            }
        }
        showData("ELIGIBLE STUDENTS", sb_215.toString());
    }

    private void showData(String title, String msg) {
        AlertDialog.Builder builder_215 = new AlertDialog.Builder(this);
        builder_215.setCancelable(true);
        builder_215.setTitle(title);
        builder_215.setMessage(msg);
        builder_215.show();
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        selectedState_215 = (String) stateSpinner_215.getItemAtPosition(position);
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}