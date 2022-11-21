package com.example.lab2andriod;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {
    ListView listView1;
    //String listview1[] = {"Pants", "Shoes", "Hats"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        ArrayAdapter adapter = new ArrayAdapter<String>(this,R.layout.activity_main, listview1);
//        ListView listView = (ListView) findViewById(R.id.listview1);
//        listView.setAdapter(adapter);
    }
}