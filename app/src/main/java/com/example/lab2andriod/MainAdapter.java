package com.example.lab2andriod;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainAdapter extends BaseAdapter {
    MainActivity mainActivity; ArrayList<Product> list;
    LayoutInflater layoutInflater;

    public MainAdapter(MainActivity mainActivity, ArrayList<Product> list) {
        this.mainActivity = mainActivity;
        this.list = list;
        layoutInflater = (LayoutInflater) mainActivity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

    }


    @Override
    public int getCount() {
        return list.size();
    }


    @Override
    public Object getItem(int i) {
        return list.get(i);
    }


    @Override
    public long getItemId(int i) {
        return i;
    }


    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

            View rowView = view;
            if (rowView==null) {
                rowView = layoutInflater.inflate(R.layout.raw_list, null, true);
            }

        TextView listname1 = rowView.findViewById(R.id.list_item1);
        listname1.setText(list.get(i).getName());
        TextView listname2 = rowView.findViewById(R.id.list_item2);
        listname2.setText(String.valueOf(list.get(i).getQty()));
        TextView listname3 = rowView.findViewById(R.id.list_item3);
        listname3.setText(String.valueOf(list.get(i).getPrice()));



            return rowView;
        }
    }

