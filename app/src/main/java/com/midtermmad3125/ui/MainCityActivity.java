package com.midtermmad3125.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.midtermmad3125.R;
import com.midtermmad3125.utils.ReadJSONUtils;

public class MainCityActivity extends AppCompatActivity
{
    Button buttonAdd;
    TextView textCityName;
    TextView textLat;
    TextView textLng;
    TextView textCountryCode;
    TextView textPopulation;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textCityName = findViewById(R.id.textCityName);
        textLat = findViewById(R.id.textLatitude);
        textLng = findViewById(R.id.textLongitude);
        textCountryCode = findViewById(R.id.textCountryCode);
        textPopulation = findViewById(R.id.textPopulation);
        buttonAdd = findViewById(R.id.buttonAdd);

        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainCityActivity.this, WeatherListActivity.class);
                startActivity(intent);
            }
        });
    }
}
