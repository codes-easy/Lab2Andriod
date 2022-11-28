package com.example.lab2andriod;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;
import android.content.Intent;

import java.util.ArrayList;


public class Historyactivity extends AppCompatActivity  implements HistoryRecycleAdapter.ItemListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);
        int historySize =((StoreHistoryData) getApplication()).getSize();
       // ArrayList<HistoryList> rr = new ArrayList<HistoryList>();
      //  rr=((StoreHistoryData) getApplication()).getData();
        RecyclerView recyclerView=findViewById(R.id.rv_historylist);
        HistoryRecycleAdapter adapter=new HistoryRecycleAdapter(((StoreHistoryData) getApplication()).getData(),this);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(llm);
        adapter.listener=this;
        recyclerView.setAdapter(adapter);






    }

    @Override
    public void onItemClicked(int P) {


    }
}