package com.example.lab2andriod;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.service.autofill.OnClickAction;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

public class MainActivity extends AppCompatActivity
    implements View.OnClickListener, AdapterView.OnItemClickListener {
    Button one, two, three, four, five, six, seven, eight, nine, zero, buy, clear, managerBtn;
    TextView Producttype, total, qtytype;

    String MERGE = "";
    ArrayList<Product> list;
    ArrayList<HistoryList> histoty_list = new ArrayList<>();
    String regex = "[0-9]+";
    ListView listView1;
    int Itemindex = 0;

    MainAdapter adapter;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        list = new ArrayList<>();
        listView1 = findViewById(R.id.listview_products);


        //  Product p1=new Product("Pants",20.44, 10);
        //  Product p2= new Product("Shoes",10.44, 100);
        //  Product p3=new Product("Hats",5.9, 30);

        // list.add(p1);
        // list.add(p2);
        // list.add(p3);
        list = ((StoreHistoryData) getApplication()).setProductListData();

        // mainAdapter1 = new MainAdapter(MainActivity.this,list);
        //listView1.setAdapter((ListAdapter) mainAdapter1);
        ImplementAdeptor();
      //  setListData();
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
        managerBtn = findViewById(R.id.managerbutton);


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
        //Producttype.setOnClickListener(this);
        //qtytype.setOnClickListener(this);
        buy.setOnClickListener(this);
        //total.setOnClickListener(this);
        listView1.setOnItemClickListener(this);
        managerBtn.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        Button button = (Button) view;
        String qtytopurchase = button.getText().toString();
        HistoryList h1;
        if (qtytopurchase.equals(clear.getText())) {
            qtytype.setText("");
            MERGE = "";
            total.setText("");
            Producttype.setText("");

        } else if (qtytopurchase.matches(regex)) {
            MERGE = MERGE + qtytopurchase;

            qtytype.setText(MERGE);

        }
        if (button.equals(buy)) {
            double TotalPrice = Double.parseDouble(qtytype.getText().toString()) * list.get(Itemindex).getPrice();


            int newQty = (list.get(Itemindex).qty - Integer.parseInt(qtytype.getText().toString()));
            //Toast.makeText(this, ((String) ("New qty " + newQty)), Toast.LENGTH_LONG).show();


            //new Product("Pants",20.44, 10)
            list.set(Itemindex,
                    new Product(list.get(Itemindex).getName(), list.get(Itemindex).getPrice(), newQty > 0 ? newQty : 0));


            if (newQty < 0) {
                Toast.makeText(this, "Wrong qty.", Toast.LENGTH_LONG).show();
            } else {
                showAlert(TotalPrice, qtytype.getText().toString());
                ImplementAdeptor();

                total.setText("" + TotalPrice);

                h1 = new HistoryList(list.get(Itemindex).getName(),
                        TotalPrice, Integer.parseInt(qtytype.getText().toString()), new Date().toString());

                histoty_list.add(h1);

            }
        }
        if (button.equals(managerBtn)) {

            ((StoreHistoryData) getApplication()).setData(histoty_list);
            ((StoreHistoryData) getApplication()).setSize(histoty_list.size());

            Intent firstIntent = new Intent(MainActivity.this, ManagerActivity.class);
            startActivity(firstIntent);
            //firstIntent.putExtra("HISTORYDATA", histoty_list);
        }

    }

    private void setListData() {
        ((StoreHistoryData) getApplication()).setProductListData();

        list = ((StoreHistoryData) getApplication()).getProductList();

        adapter = new MainAdapter( MainActivity.this, list);
        listView1.setAdapter(adapter);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Producttype.setText(list.get(position).getName());
        Itemindex = position;

    }

    private void showAlert(double TotalPrice, String Qty) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Your purchase is " + Qty + " " + list.get(Itemindex).getName() +
                        " for $" + String.format("%.2f", TotalPrice))
                .setTitle("Thank You for your purchase");
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                Button btnClickMe = (Button) findViewById(R.id.clearbut);
                btnClickMe.performClick();

            }
        });
        builder.show();
    }

    private void ImplementAdeptor() {
        adapter = new MainAdapter(MainActivity.this, list);
        listView1.setAdapter((ListAdapter) adapter);
    }

    protected void onResume() {
        super.onResume();
        adapter.notifyDataSetChanged();

    }
}