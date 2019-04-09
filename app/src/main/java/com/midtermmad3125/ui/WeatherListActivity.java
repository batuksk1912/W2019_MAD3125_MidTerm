package com.midtermmad3125.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.midtermmad3125.R;
import com.midtermmad3125.adapters.CityAdapter;
import com.midtermmad3125.models.CityDetails;

import java.util.ArrayList;

public class WeatherListActivity extends AppCompatActivity
{

    RecyclerView recyclerView;
    RecyclerView.Adapter adapter;
    ArrayList<CityDetails> cityDetailsArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather_list);

        recyclerView = findViewById(R.id.recyclerView);

        //processJSON();

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        adapter = new CityAdapter();
        recyclerView.setAdapter(adapter);
    }
}
