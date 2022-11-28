package com.example.lab2andriod;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class DetailHistoryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_history);

      TextView typetxv = (TextView) findViewById(R.id.detailType);
      TextView pricetxv = (TextView) findViewById(R.id.detailPrice);
      TextView datetxv = (TextView) findViewById(R.id.detailDate);
        int index = getIntent().getIntExtra("Index", 0);
        ArrayList<HistoryList> h2 = ((StoreHistoryData) getApplication()).getData();
        Toast.makeText(this, "index: "+index, Toast.LENGTH_SHORT).show();
        //typetxv.setText(String.format(%s%s, typetxv.getText().toString(), h2.getType)))







    }
}