package com.example.lab2andriod;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.example.lab2andriod.HistoryList;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import java.util.ArrayList;


public class ManagerActivity extends AppCompatActivity implements View.OnClickListener {

    Button History, Restock;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manager);

        History = findViewById(R.id.Historybutton);
        Restock = findViewById(R.id.Restockbutton);
        History.setOnClickListener(this);
        Restock.setOnClickListener(this);
            }

    /**
     * Called when a view has been clicked.
     *
     * @param view The view that was clicked.
     */
    @Override
    public void onClick(View view) {

        Button button = (Button) view;

        if(button.equals(History)) {
            Intent historyIntent = new Intent(ManagerActivity.this, Historyactivity.class);
            startActivity(historyIntent);
        }
        if(button.equals(Restock)) {
            Intent restockIntent = new Intent(ManagerActivity.this, Restockactivity.class);
            startActivity(restockIntent);
        }




//           if(getIntent().hasExtra("HISTORYDATA")){
//               //ArrayList<HistoryList> histoty_list = getIntent().getExtras().getString("HISTORYDATA");
//
//               ArrayList<HistoryList> mylist = (ArrayList<HistoryList>) getIntent().getSerializableExtra("HISTORYDATA");
//               RecyclerView recyclerView = (RecyclerView) findViewById(R.id.rv_historylist);
//               recyclerView.
//
//           }

        }

    }
