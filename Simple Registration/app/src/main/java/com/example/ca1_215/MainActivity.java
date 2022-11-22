package com.example.ca1_215;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    EditText name_215, dept_215, email_215;
    TextView output_215;
    Button reg_215;
    Spinner spinner_215;
    String selectedUniversity_215;
    String universities_215[] = {"None", "Reva University", "CMR University", "Sai Vidya Institute of Technology", "Presidency College", "Brindavan College", "Bangalore University", "PES University"};

    // TO DISPLAY THE REGISTRANT'S DETAILS WHEN REGISTER BUTTON IS CLICKED
    public void show_215(){
        output_215.setVisibility(View.VISIBLE);
    }

    public void hide_215(){
        output_215.setVisibility(View.INVISIBLE);
    }

    public static final String capitalize_215(String str_215)
    {
        if (str_215 == null || str_215.length() == 0) return str_215;
        return str_215.substring(0, 1).toUpperCase() + str_215.substring(1);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // ID CASCADING
        name_215 = findViewById(R.id.name_215);
        dept_215 = findViewById(R.id.dept_215);
        email_215 = findViewById(R.id.email_215);
        reg_215 = findViewById(R.id.register_215);
        spinner_215 = findViewById(R.id.spinner_215);
        output_215 = findViewById(R.id.output_215);

        // TO BRING FOCUS ON NAME FIELD
        name_215.setFocusable(true);

        // SETTING UP THE SPINNER
        spinner_215.setOnItemSelectedListener(this);
        ArrayAdapter adapter_215 = new ArrayAdapter(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, universities_215);
        adapter_215.setDropDownViewResource(androidx.appcompat.R.layout.support_simple_spinner_dropdown_item);
        spinner_215.setAdapter(adapter_215);

        // COLLECTING THE OTHER DETAILS & ASSIGNING IT TO THE RESULTANT TEXTVIEW
        reg_215.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String temp_name_215 = name_215.getText().toString();
                String temp_dept_215 = dept_215.getText().toString();
                String temp_email_215 = email_215.getText().toString();
                temp_name_215 = capitalize_215(temp_name_215);
                temp_dept_215 = temp_dept_215.toUpperCase();

                if(!(temp_name_215 == null || temp_email_215 == null || (temp_email_215.equals("@") && (temp_email_215.equals(".com"))) || temp_dept_215 == null || selectedUniversity_215 == "")){
                    output_215.setText("REGISTRATION SUCCESSFUL " + temp_name_215 + "\nUNIVERSITY : " + selectedUniversity_215 + "\nDEPARTMENT : " + temp_dept_215 + "\nEMAIL ID : " + temp_email_215);
                    show_215();
                }
                else {
                    Toast.makeText(MainActivity.this, "Missing fields or invalid entries.\nPlease check your details and try again.", Toast.LENGTH_SHORT).show();
                    hide_215();
                    name_215.setFocusable(true);
                }
            }
        });
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        if (!adapterView.getItemAtPosition(i).equals("None")) {
            selectedUniversity_215 = (String) spinner_215.getItemAtPosition(i);
        }
    }
    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}