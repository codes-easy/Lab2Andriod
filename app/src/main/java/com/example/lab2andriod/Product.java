package com.example.lab2andriod;

public class Product {//definng products and getting and setting its name, price and qty
    
    String name;
    double price;
    int qty;

    public Product(String name, double price, int qty) {
        this.name = name;
        this.price = price;
        this.qty = qty;
    }

    public String getName() {
        return name;
    }

    public Double getPrice() {
        return price;
    }

    public int getQty() {
        return qty;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }
}
