package com.example.mylab;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;

public class HomeActivity extends AppCompatActivity {

    CardView Cddoct, Cdlabtest, Cdmedicine, Cdhealth, Cdorder, Cdlogout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Cddoct = findViewById(R.id.Cddoct);
        Cdlabtest = findViewById(R.id.Cdlabtest);
        Cdhealth = findViewById(R.id.Cdhealth);
        Cdmedicine = findViewById(R.id.Cdmedicine);
        Cdorder = findViewById(R.id.Cdorder);
        Cdlogout = findViewById(R.id.Cdlogout);

        Cddoct.setOnClickListener(view -> {
            Intent intent = new Intent(HomeActivity.this, DoctorActivity.class);
            startActivity(intent);
        });

        Cdlabtest.setOnClickListener(view -> {
            Intent intent = new Intent(HomeActivity.this, LabActivity.class);
            startActivity(intent);
        });

        Cdmedicine.setOnClickListener(view -> {
            Intent intent = new Intent(HomeActivity.this, BuymedicalActivity.class);
            startActivity(intent);
        });

        Cdhealth.setOnClickListener(view -> {
            Intent intent = new Intent(HomeActivity.this, HealthActivity.class);
            startActivity(intent);
        });

        Cdorder.setOnClickListener(view -> {
            Intent intent = new Intent(HomeActivity.this, OrderActivity.class);
            startActivity(intent);
        });

        Cdlogout.setOnClickListener(view -> {
            // Clear shared preferences
            SharedPreferences.Editor editor = getSharedPreferences(LoginActivity.FILE_NAME, MODE_PRIVATE).edit();
            editor.clear();
            editor.apply();

            // Navigate to LoginActivity
            Intent intent = new Intent(HomeActivity.this, LoginActivity.class);
            startActivity(intent);
            finish();  // Optional: Finish the current activity to prevent going back to HomeActivity
        });
    }
}
