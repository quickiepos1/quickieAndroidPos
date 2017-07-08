package com.quickie.quickie.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.quickie.quickie.R;
import com.quickie.quickie.pojo.Item;

import java.util.ArrayList;

/**
 * Created by user on 6/11/2017.
 */

    public class ItemGridViewAdapter extends RecyclerView.Adapter<ItemGridViewAdapter.GridViewHolder> {

    private static ArrayList<Item> mListItems = new ArrayList<>();
    private Context context;
    private View.OnClickListener mClickListener;

    public ItemGridViewAdapter (Context context,ArrayList<Item> mListItems){
        this.mListItems = mListItems;
        this.context = context;
    }

    @Override
    public GridViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View  view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_grid,parent,false);
        GridViewHolder myViewHolder = new GridViewHolder(view,context,mListItems);
        myViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mClickListener.onClick(view);
            }
        });
        return  myViewHolder;
    }

    @Override
    public void onBindViewHolder(GridViewHolder holder, int position) {

        Item currentItem = mListItems.get(position);

        holder.name.setText(currentItem.getName());
        holder.sale_price.setText(Integer.toString(currentItem.getSale_price()));



    }

    @Override
    public int getItemCount() {
        return mListItems.size();
    }

    public static class GridViewHolder extends RecyclerView.ViewHolder
    {

        TextView name,category,sale_price;
        ArrayList<Item> items= new ArrayList<Item>();
        Context context;

        GridViewHolder(View view, Context context,ArrayList<Item> items ) {
            super(view);
            this.items=items;

            this.context = context;


            name = (TextView) view.findViewById(R.id.item_grid_name);
            sale_price = (TextView) view.findViewById(R.id.item_grid_price);



        }

    }

    public void setClickListener(View.OnClickListener callback) {
        mClickListener = callback;
    }

}