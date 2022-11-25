package com.example.lab2andriod;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.service.autofill.OnClickAction;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity
    implements View.OnClickListener {
    Button one,two,three,four,five,six,seven,eight,nine,zero,buy,clear, managerBtn;
    TextView Producttype, total, qtytype;

    String MERGE ="";
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

        one = findViewById(R.id.onebut);
        two = findViewById(R.id.twobut);
        three = findViewById(R.id.threebut);
        four = findViewById(R.id.fourbut);
        five = findViewById(R.id.fivebut);
        six = findViewById(R.id.sixbut);
        seven = findViewById(R.id.sevenbut);
        eight = findViewById(R.id.eightbut);
        nine = findViewById(R.id.ninebut);
        zero = findViewById(R.id.zerobut);
        buy = findViewById(R.id.buybut);
        clear = findViewById(R.id.clearbut);
        qtytype = findViewById(R.id.QtyBut);
        Producttype = findViewById(R.id.product_id);
        total = findViewById(R.id.totalbut);



        one.setOnClickListener(this);
        two.setOnClickListener(this);
        three.setOnClickListener(this);
        four.setOnClickListener(this);
        five.setOnClickListener(this);
        six.setOnClickListener(this);
        seven.setOnClickListener(this);
        eight.setOnClickListener(this);
        nine.setOnClickListener(this);
        zero.setOnClickListener(this);
        clear.setOnClickListener(this);
        Producttype.setOnClickListener(this);
        qtytype.setOnClickListener(this);
        buy.setOnClickListener(this);
        total.setOnClickListener(this);


    }

    @Override
    public void onClick(View view) {
        Button button = (Button) view;
        String num1 = button.getText().toString();
        MERGE = MERGE+num1;

        qtytype.setText(MERGE);
       /* TextView numq = (TextView) view;

        String numq = qtytype.getText().toString();
        String num = num1+numq;
        qtytype.setText(numq);*/



    }
}