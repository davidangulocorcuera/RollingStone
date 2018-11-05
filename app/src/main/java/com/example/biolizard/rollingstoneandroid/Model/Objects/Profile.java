package com.example.biolizard.rollingstoneandroid.Model.Objects;

import com.google.firebase.database.IgnoreExtraProperties;

@IgnoreExtraProperties
public class Profile {
    private double lat;
    private double lon;
    private String country;
    private int age;
    private String city;
    private String email;
    private String imgurl;
    private String name;
    private String secondUsername;
    private String username;
    public Profile(){

    }

    public Profile(String country, int age, String city, String email, String imgurl, String name, String secondUsername, String username, double lat, double lon) {
        this.country = country;
        this.age = age;
        this.city = city;
        this.email = email;
        this.imgurl = imgurl;
        this.name = name;
        this.secondUsername = secondUsername;
        this.username = username;
        this.lat = lat;
        this.lon = lon;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLon() {
        return lon;
    }

    public void setLon(double lon) {
        this.lon = lon;
    }


    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getImgurl() {
        return imgurl;
    }

    public void setImgurl(String imgurl) {
        this.imgurl = imgurl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSecondUsername() {
        return secondUsername;
    }

    public void setSecondUsername(String secondUsername) {
        this.secondUsername = secondUsername;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }










}
