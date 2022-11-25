package com.example.lab2andriod;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Button one,two,three,four,five,six,seven,eight,nine,zero,buy,clear,buybtn, managerBtn;
    TextView Producttype, total, qtytype;

    ArrayList<Product> list;
    ListView listView1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        list = new ArrayList<>();
        listView1 = findViewById(R.id.listview_products);


         Product p1=new Product("Pants",20.44, 10);
        Product p2= new Product("Shoes",10.44, 10);
        Product p3=new Product("Hats",5.9, 10);

        list.add(p1);
        list.add(p2);
        list.add(p3);
        MainAdapter mainAdapter1 = new MainAdapter(MainActivity.this,list);
        listView1.setAdapter((ListAdapter) mainAdapter1);





    }
}