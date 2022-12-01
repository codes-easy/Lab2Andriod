package com.example.lab2andriod;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class HistoryRecycleAdapter extends RecyclerView.Adapter<HistoryRecycleAdapter.myViewHolder> {

// class created to show history list view
    interface ItemListener {
        void onItemClicked(int P);

    }

    ArrayList<HistoryList>list;
    Context C;
    ItemListener listener;

    public HistoryRecycleAdapter(ArrayList<HistoryList> list, Context C){
        this.list = list;
        this.C = C;

    }

    @NonNull
    @Override
    public HistoryRecycleAdapter.myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {//setting history view by taking data from context and putting in recycler history templet xml file
       View view = LayoutInflater.from(C).inflate(R.layout.recycler_history_templet,parent, false);

        //return new myViewHolder(view);
    return new myViewHolder(view);
    }


    /**
     * Called by RecyclerView to display the data at the specified position. This method should
     * update the contents of the {@link RecyclerView.ViewHolder # itemView} to reflect the item at the given
     * position.
     * <p>
     * Note that unlike {@link ListView}, RecyclerView will not call this method
     * again if the position of the item changes in the data set unless the item itself is
     * invalidated or the new position cannot be determined. For this reason, you should only
     * use the <code>position</code> parameter while acquiring the related data item inside
     * this method and should not keep a copy of it. If you need the position of an item later
     * on (e.g. in a click listener), use {@link RecyclerView.ViewHolder # getAdapterPosition()} which will
     * have the updated adapter position.
     * <p>
     * Override {@link # onBindViewHolder(ViewHolder, int, List)} instead if Adapter can
     * handle efficient partial bind.
     *
     * @param holder   The ViewHolder which should be updated to represent the contents of the
     *                 item at the given position in the data set.
     * @param position The position of the item within the adapter's data set.
     */
    @Override
    public void onBindViewHolder(@NonNull HistoryRecycleAdapter.myViewHolder holder, int position) {
        //binding name, price and qty to recycleadapter


        holder.historytype.setText(list.get(position).getName());
        holder.historyprice.setText(String.valueOf(list.get(position).getPrice()));
        holder.historyqty.setText(String.valueOf(list.get(position).getQty()));
    }

    /**
     * Returns the total number of items in the data set held by the adapter.
     *
     * @return The total number of items in this adapter.
     */
    @Override
    public int getItemCount() {
        return list.size();
    }

    public class myViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView historytype;
        TextView historyqty;
        TextView historyprice;
        public myViewHolder(@NonNull View itemView) {
            super(itemView);

            historytype = itemView.findViewById(R.id.hrt_name);
            historyqty = itemView.findViewById(R.id.hrt_qty);
            historyprice = itemView.findViewById(R.id.hrt_price);
            itemView.setOnClickListener(this);
        }

        /**
         * Called when a view has been clicked.
         *
         * @param view The view that was clicked.
         */
        @Override
        public void onClick(View view) {listener.onItemClicked(getAdapterPosition());

        }
    }
}
