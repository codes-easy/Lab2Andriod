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

    String MERGE = ""; //This will merge two numbers on the screen.
    ArrayList<Product> list; // this is very first product list which will be displayed on create.
    ArrayList<HistoryList> histoty_list = new ArrayList<>();// History list which will be passed upon pressing Buy Button
    String regex = "[0-9]+";// defining 0-9 numbers
    ListView listView1; // this is intital listview shown in xml file
    int Itemindex = 0;

    MainAdapter adapter;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        list = new ArrayList<>(); //new object as list of array list
        listView1 = findViewById(R.id.listview_products);



        list = ((StoreHistoryData) getApplication()).setProductListData(); // setting product list from another data class

        ImplementAdeptor();

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
        buy.setOnClickListener(this);
        listView1.setOnItemClickListener(this);
        managerBtn.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        Button button = (Button) view; // button class
        String qtytopurchase = button.getText().toString(); // defining qtytopurchase
        HistoryList h1; // created new class for historylist
        if (qtytopurchase.equals(clear.getText())) { //functionality of clear button
            qtytype.setText(""); // 4 conditions - no qtytyp mentioned
            MERGE = "";  // no number typed
            total.setText("");
            Producttype.setText("");

        } else if (qtytopurchase.matches(regex)) {
            MERGE = MERGE + qtytopurchase; // adding number to qty to purchase for double digit

            qtytype.setText(MERGE); //taking qty as merge number

        }
        if (button.equals(buy)) { // Buy button functionality

            double TotalPrice = Double.parseDouble(qtytype.getText().toString()) * list.get(Itemindex).getPrice();//determining price
            int newQty = (list.get(Itemindex).qty - Integer.parseInt(qtytype.getText().toString())); // updating qty
            list.set(Itemindex,
                    new Product(list.get(Itemindex).getName(), list.get(Itemindex).getPrice(), newQty > 0 ? newQty : 0)); // condition for not gettin more than avialable qty

            if (newQty < 0) {
                Toast.makeText(this, "Wrong qty.", Toast.LENGTH_LONG).show(); // condition for non negative qty and qty higher than available
            } else {
                showAlert(TotalPrice, qtytype.getText().toString()); // showing alert msg for purchase made
                ImplementAdeptor();

                total.setText("" + TotalPrice);

                h1 = new HistoryList(list.get(Itemindex).getName(), // adding purchase in history list
                        TotalPrice, Integer.parseInt(qtytype.getText().toString()), new Date().toString());

                histoty_list.add(h1);

            }
        }
        if (button.equals(managerBtn)) { // Managerbutton functionality

            ((StoreHistoryData) getApplication()).setData(histoty_list); //whole array will fetch
            ((StoreHistoryData) getApplication()).setSize(histoty_list.size());//array size will fetch

            Intent firstIntent = new Intent(MainActivity.this, ManagerActivity.class);
            startActivity(firstIntent); // transition to second page in screen
            //firstIntent.putExtra("HISTORYDATA", histoty_list);
        }

    }

    private void setListData() { // setting of updated data to main screen
        ((StoreHistoryData) getApplication()).setProductListData();

        list = ((StoreHistoryData) getApplication()).getProductList(); //taking data from storehistorydata class

        adapter = new MainAdapter( MainActivity.this, list); // adapter class from Main adapter to update first listview
        listView1.setAdapter(adapter);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Producttype.setText(list.get(position).getName());
        Itemindex = position;

    }

    private void showAlert(double TotalPrice, String Qty) { // Alert dialog builder
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

    private void ImplementAdeptor() {//using this adapter to update listview
        adapter = new MainAdapter(MainActivity.this, list);
        listView1.setAdapter((ListAdapter) adapter);
    }

    protected void onResume() {//updating list view and history view when resuming
        super.onResume();
        adapter.notifyDataSetChanged();

    }
}