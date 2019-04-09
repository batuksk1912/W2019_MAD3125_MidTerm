package com.midtermmad3125.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.midtermmad3125.R;
import com.midtermmad3125.adapters.WeatherAdapter;
import com.midtermmad3125.models.Temp;
import com.midtermmad3125.models.Weather;
import com.midtermmad3125.models.WeatherDetails;
import com.midtermmad3125.utils.ReadJSONUtils;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class WeatherListActivity extends AppCompatActivity
{

    RecyclerView recyclerView;
    RecyclerView.Adapter adapter;
    ArrayList<Weather> weatherArrayList;
    ReadJSONUtils jsonUtils;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather_list);

        recyclerView = findViewById(R.id.recyclerView);

        processJSON();

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        //adapter = new WeatherAdapter(this,weatherArrayList);
        recyclerView.setAdapter(adapter);
    }

    private void processJSON() {
        weatherArrayList = new ArrayList<>();
        String jsonString = jsonUtils.loadJSONFromAsset(this, "moscow_weather.json");
        if (jsonString != null) {
            try {
                JSONArray mJSONArray = new JSONArray(jsonString);

                for (int i = 0; i < mJSONArray.length(); i++) {
                    Weather mWeather = this.getUserObjectFromJSON(mJSONArray.getJSONObject(i));
                    weatherArrayList.add(mWeather);
                    Log.d("-- JSON -- ", mWeather.toString());

                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    private Weather getUserObjectFromJSON(JSONObject userJsonObject) throws JSONException {
        JSONObject list = new JSONObject(userJsonObject.getJSONObject("list").toString());
        long dt = list.getLong(Weather.KEY_ID);

        JSONObject temp = new JSONObject(list.getJSONObject("temp").toString());
        String maxt = temp.getString("max");
        String mint = temp.getString("min");

        JSONObject weather = new JSONObject(list.getJSONObject("weather").toString());
        String mainWeather = weather.getString("main");

        Temp temperature = new Temp();
        temperature.setMax(maxt);
        temperature.setMin(mint);

        WeatherDetails weatherDetails = new WeatherDetails();
        weatherDetails.setMain(mainWeather);

        Weather mWeather = new Weather();
        mWeather.setDt(dt);
        mWeather.setTemp(temperature);
        mWeather.setWeatherDetails(weatherDetails);

        return mWeather;
    }
}
