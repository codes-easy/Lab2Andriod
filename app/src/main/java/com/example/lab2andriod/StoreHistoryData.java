package com.example.lab2andriod;

import android.app.Application;

import java.util.ArrayList;

public class StoreHistoryData  extends Application {

    private int histroyListSize=0;
    private  ArrayList<HistoryList> histroyListData  =new ArrayList<>();


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
}
