package com.example.lab2andriod;


import java.util.ArrayList;

public class HistoryList extends Product  {
    String date;


    public HistoryList(String name, double price, int qty,String date) {
        super(name, price, qty);
        this.date = date;
    }



    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }





}
