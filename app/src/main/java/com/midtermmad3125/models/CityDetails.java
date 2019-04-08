package com.midtermmad3125.models;

public class CityDetails {

    public static final String KEY_ID = "id";
    public static final String KEY_CITY_NAME = "name";
    public static final String KEY_COUNTRY_CODE = "country";
    public static final String KEY_POPULATION = "population";

    private long id;
    private String name;
    private String country;
    private String population;
    private Geo geo;
    private Weather weather;

    public CityDetails() {
    }

    public CityDetails(long id, String name, String country, String population, Geo geo, Weather weather) {
        this.id = id;
        this.name = name;
        this.country = country;
        this.population = population;
        this.geo = geo;
        this.weather = weather;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPopulation() {
        return population;
    }

    public void setPopulation(String population) {
        this.population = population;
    }

    public Geo getGeo() {
        return geo;
    }

    public void setGeo(Geo geo) {
        this.geo = geo;
    }

    public Weather getWeather() {
        return weather;
    }

    public void setWeather(Weather weather) {
        this.weather = weather;
    }

    @Override
    public String toString() {
        return "CityDetails{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", country='" + country + '\'' +
                ", population='" + population + '\'' +
                ", geo=" + geo +
                ", weather=" + weather +
                '}';
    }
}
