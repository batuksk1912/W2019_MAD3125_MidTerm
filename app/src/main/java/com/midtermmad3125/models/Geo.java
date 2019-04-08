package com.midtermmad3125.models;

public class Geo {

    public static final String KEY_LAT = "lat";
    public static final String KEY_LNG = "lon";

    private String lat;
    private String lon;

    public Geo() {
    }

    public Geo(String lat, String lon) {
        this.lat = lat;
        this.lon = lon;
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public String getLon() {
        return lon;
    }

    public void setLon(String lon) {
        this.lon = lon;
    }

    @Override
    public String toString() {
        return "Geo{" +
                "lat='" + lat + '\'' +
                ", lon='" + lon + '\'' +
                '}';
    }
}
