package com.midtermmad3125.models;

public class Weather {

    public static final String KEY_ID = "dt";

    private long dt;
    private String pressure;
    private String humidity;
    private String speed;
    private String deg;
    private String clouds;
    private String rain;
    private WeatherDetails weatherDetails;
    private Temp temp;

    public Weather() {
    }

    public Weather(long dt, String pressure, String humidity, String speed, String deg, String clouds, String rain, WeatherDetails weatherDetails, Temp temp) {
        this.dt = dt;
        this.pressure = pressure;
        this.humidity = humidity;
        this.speed = speed;
        this.deg = deg;
        this.clouds = clouds;
        this.rain = rain;
        this.weatherDetails = weatherDetails;
        this.temp = temp;
    }

    public long getDt() {
        return dt;
    }

    public void setDt(long dt) {
        this.dt = dt;
    }

    public String getPressure() {
        return pressure;
    }

    public void setPressure(String pressure) {
        this.pressure = pressure;
    }

    public String getHumidity() {
        return humidity;
    }

    public void setHumidity(String humidity) {
        this.humidity = humidity;
    }

    public String getSpeed() {
        return speed;
    }

    public void setSpeed(String speed) {
        this.speed = speed;
    }

    public String getDeg() {
        return deg;
    }

    public void setDeg(String deg) {
        this.deg = deg;
    }

    public String getClouds() {
        return clouds;
    }

    public void setClouds(String clouds) {
        this.clouds = clouds;
    }

    public String getRain() {
        return rain;
    }

    public void setRain(String rain) {
        this.rain = rain;
    }

    public WeatherDetails getWeatherDetails() {
        return weatherDetails;
    }

    public void setWeatherDetails(WeatherDetails weatherDetails) {
        this.weatherDetails = weatherDetails;
    }

    public Temp getTemp() {
        return temp;
    }

    public void setTemp(Temp temp) {
        this.temp = temp;
    }

    @Override
    public String toString() {
        return "Weather{" +
                "dt=" + dt +
                ", pressure='" + pressure + '\'' +
                ", humidity='" + humidity + '\'' +
                ", speed='" + speed + '\'' +
                ", deg='" + deg + '\'' +
                ", clouds='" + clouds + '\'' +
                ", rain='" + rain + '\'' +
                ", weatherDetails=" + weatherDetails +
                ", temp=" + temp +
                '}';
    }
}
