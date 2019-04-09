package com.midtermmad3125.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.midtermmad3125.R;
import com.midtermmad3125.models.CityDetails;
import com.midtermmad3125.models.Geo;
import com.midtermmad3125.utils.ReadJSONUtils;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

public class MainCityActivity extends AppCompatActivity
{
    Button buttonAdd;
    TextView textCityName;
    TextView textLat;
    TextView textLng;
    TextView textCountryCode;
    TextView textPopulation;
    ReadJSONUtils jsonUtils;
    ArrayList<CityDetails> cityDetailsArrayList;

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

        processJSON();

        int listSize = cityDetailsArrayList.size();
        for (int i = 0; i < listSize; i++) {
            Log.i("Member name: ", cityDetailsArrayList.get(i).getName());
        }

        textCityName.setText(cityDetailsArrayList.get(0).getName());
        textLat.setText(cityDetailsArrayList.get(0).getGeo().getLat());
        textLng.setText(cityDetailsArrayList.get(0).getGeo().getLon());
        textCountryCode.setText(cityDetailsArrayList.get(0).getCountry());
        textPopulation.setText(cityDetailsArrayList.get(0).getPopulation());

        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainCityActivity.this, WeatherListActivity.class);
                startActivity(intent);
            }
        });
    }

    private void processJSON() {
        cityDetailsArrayList = new ArrayList<>();
        String jsonString = jsonUtils.loadJSONFromAsset(this, "moscow_weather.json");
        if (jsonString != null) {
            try {
                JSONArray mJSONArray = new JSONArray(jsonString);

                for (int i = 0; i < mJSONArray.length(); i++) {
                    CityDetails mCity = this.getUserObjectFromJSON(mJSONArray.getJSONObject(i));
                    cityDetailsArrayList.add(mCity);
                    Log.d("-- JSON -- ", mCity.toString());

                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    private CityDetails getUserObjectFromJSON(JSONObject userJsonObject) throws JSONException {
        JSONObject city = new JSONObject(userJsonObject.getJSONObject("city").toString());
        long id = city.getLong(CityDetails.KEY_ID);
        String name = city.getString("name");
        String country = city.getString("country");
        String population = city.getString("population");

        JSONObject geo = new JSONObject(city.getJSONObject("coord").toString());
        String lon = geo.getString("lon");
        String lat = geo.getString("lat");

        CityDetails mCity = new CityDetails();
        mCity.setId(id);
        mCity.setName(name);
        mCity.setCountry(country);
        mCity.setPopulation(population);

        Geo mGeo = new Geo();
        mGeo.setLat(lat);
        mGeo.setLon(lon);
        mCity.setGeo(mGeo);

        return mCity;
    }

    private String loadJSONFromAsset() {
        String json;
        try {
            InputStream is = getAssets().open("moscow_weather.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            int count = is.read(buffer);
            is.close();
            Log.d("-- COUNT --", String.format("%d Bytes", count));
            json = new String(buffer, StandardCharsets.UTF_8);
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        return json;
    }
}
