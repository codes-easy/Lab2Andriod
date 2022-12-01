package com.example.lab2andriod;

import android.app.Application;

import java.util.ArrayList;

public class StoreHistoryData  extends Application {

    private int histroyListSize=0;
    private  ArrayList<HistoryList> histroyListData  =new ArrayList<>();
    private ArrayList<Product> productList=new ArrayList<>(0);


    public int getSize(){
        return  histroyListSize;
    }

    public void setSize(int size){
        this.histroyListSize=size;
    }

    public void setData(ArrayList<HistoryList> data){
        this.histroyListData = data;
    }

    public ArrayList<HistoryList>  getData(){
        return this.histroyListData;
    }

    public HistoryList  getData(int index){
        return this.histroyListData.get(index);
    }

    public ArrayList<Product>   getProductList(){
        return this.productList;
    }

    public ArrayList<Product> setProductListData(){
        if(productList.isEmpty()){


            Product p1=new Product("Pants",20.44, 10);
            Product p2= new Product("Shoes",10.44, 100);
            Product p3=new Product("Hats",5.9, 30);

            productList.add(p1);
            productList.add(p2);
            productList.add(p3);
        }
        return this.productList;
    }



}
