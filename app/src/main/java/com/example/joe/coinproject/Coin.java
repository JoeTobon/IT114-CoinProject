package com.example.joe.coinproject;

import java.util.*;

/**
 * Created by Joe on 3/13/2017.
 */

public class Coin
{
    private String country;
    private String serialNum;
    private String denom;
    private int year;
    private String material;
    private double price;
    private String imageUrl;

    //default constructor
    public Coin()
    {
        this.country = "";
        this.serialNum = "";
        this.denom = "";
        this.year = 0;
        this.material = "";
        this.price = 0.0;
        this.imageUrl = "";
    }

    //constructor
    public Coin(String country, String serialNum, String denom, int year, String material, double price, String imageUrl)
    {
        this.country = country;
        this.serialNum = serialNum;
        this.denom = denom;
        this.year = year;
        this.material = material;
        this.price = price;
        this.imageUrl = imageUrl;
    }

    public String getCountry()
    {
        return this.country;
    }

    public String getSerialNum()
    {
        return this.serialNum;
    }

    public String getDenom()
    {
        return this.denom;
    }

    public int getYear()
    {
        return this.year;
    }

    public String getMaterial()
    {
        return this.material;
    }

    public double getPrice()
    {
        return this.price;
    }

    public String getImageUrl()
    {
        return this.imageUrl;
    }

    public int getAge()
    {
        int curYear = Calendar.getInstance().get(Calendar.YEAR);
        int age = curYear - year;
        return age;
    }
}
