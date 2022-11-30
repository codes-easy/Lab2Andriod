package com.example.lab2andriod;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class Restockactivity extends AppCompatActivity implements AdapterView.OnItemClickListener, View.OnClickListener{

    EditText modifiedqty;
    Button restockokbut, restockcancelbut;
    ListView restockListView;
    RestockAdapter adapter;
    int selectedIndex = -1;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restock);
        initializeAllViews();
        setListData();
        restockokbut.setOnClickListener(this);
        restockcancelbut.setOnClickListener(this);
        restockListView.setOnItemClickListener(this);


        //test
    }

    private void setListData() {

        adapter = new RestockAdapter(((StoreHistoryData) getApplication()).getProductListData(), this);
        restockListView.setAdapter(adapter);
       // restockListView.set
    }
    private void initializeAllViews(){
        modifiedqty= findViewById(R.id.modifiedqty);
        restockokbut = findViewById(R.id.restockokbut);
        restockcancelbut = findViewById(R.id.restockcancelbut);
        restockListView = findViewById(R.id.restockListView);

    }



    /**
     * Called when a view has been clicked.
     *
     * @param view The view that was clicked.
     */
    @Override
    public void onClick(View view) {

        if (view.getId() == R.id.restockokbut) {
            if (modifiedqty.getText().toString().equals("") || selectedIndex == -1) {
                Toast.makeText(this, "All fields are Required.", Toast.LENGTH_SHORT).show();

            } else {

                Product p1=((StoreHistoryData)getApplication()).getProductListData().get(selectedIndex);
                p1.setQty(p1.getQty()+Integer.parseInt(modifiedqty.getText().toString()));
                ((StoreHistoryData)getApplication()).getProductListData().set(selectedIndex,p1);
                adapter.notifyDataSetChanged();
            }
        }

        else {

            finish();
        }

    }

    /**
     * Callback method to be invoked when an item in this AdapterView has
     * been clicked.
     * <p>
     * Implementers can call getItemAtPosition(position) if they need
     * to access the data associated with the selected item.
     *
     * @param parent   The AdapterView where the click happened.
     * @param view     The view within the AdapterView that was clicked (this
     *                 will be a view provided by the adapter)
     * @param position The position of the view in the adapter.
     * @param id       The row id of the item that was clicked.
     */
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        selectedIndex=position;
        Toast.makeText(this, ((StoreHistoryData) getApplication()).getProductListData().get(position).getName(), Toast.LENGTH_SHORT).show();
    }
}