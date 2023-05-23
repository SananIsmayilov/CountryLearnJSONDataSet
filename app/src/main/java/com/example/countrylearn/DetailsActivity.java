package com.example.countrylearn;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class DetailsActivity extends AppCompatActivity {
TextView textView;
CountryConteyner conteyner;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        textView = findViewById(R.id.textViewdetails);
        conteyner = (CountryConteyner) getIntent().getSerializableExtra("obyekt");
        textView.setText(conteyner.getName());
    }
}