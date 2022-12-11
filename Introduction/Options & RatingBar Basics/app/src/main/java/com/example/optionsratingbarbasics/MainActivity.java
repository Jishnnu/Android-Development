package com.example.optionsratingbarbasics;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    RatingBar rating_215;
    Button btn_215;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater mi_215 = getMenuInflater();
        mi_215.inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.item1_215:
                Toast.makeText(this, "Item 1", Toast.LENGTH_SHORT).show();
                return true;

            case R.id.item2_215:
                Toast.makeText(this, "Item 2", Toast.LENGTH_SHORT).show();
                return true;

            case R.id.subitem_215:
                Toast.makeText(this, "Sub Item", Toast.LENGTH_SHORT).show();
                return true;

            default: return super.onOptionsItemSelected(item);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rating_215 = findViewById(R.id.rating_215);
        btn_215 = findViewById(R.id.btn_215);

        btn_215.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String rating = String.valueOf(rating_215.getRating());
                Toast.makeText(MainActivity.this, "Your Rating : " + rating, Toast.LENGTH_SHORT).show();
            }
        });

    }
}