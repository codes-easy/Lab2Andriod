package com.example.lab2andriod;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class RestockAdapter extends BaseAdapter {
    ArrayList<Product> list;
    Context context;

    public RestockAdapter(ArrayList<Product> list, Context context) {
        this.list = list;
        this.context = context;
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
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {


        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);


        View v = inflater.inflate(R.layout.raw_list,viewGroup,false);

        TextView productType = v.findViewById(R.id.list_item1);
        TextView productPrice = v.findViewById(R.id.list_item2);
        TextView productQty = v.findViewById(R.id.list_item3);

        productType.setText(list.get(i).getName());
        productPrice.setText(String.valueOf(list.get(i).getPrice()));
        productQty.setText(String.valueOf(list.get(i).getQty()));

        return v;
    }

}
