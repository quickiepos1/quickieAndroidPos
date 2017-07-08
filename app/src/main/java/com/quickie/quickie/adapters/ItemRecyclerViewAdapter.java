package com.quickie.quickie.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.quickie.quickie.R;
import com.quickie.quickie.activities.DisplayItemActivity;
import com.quickie.quickie.pojo.Item;

import java.util.ArrayList;

/**
 * Created by user on 5/22/2017.
 */

public class ItemRecyclerViewAdapter extends RecyclerView.Adapter <ItemRecyclerViewAdapter.MyViewHolder>{



    private ArrayList<Item> mListItems = new ArrayList<>();
    private Context context;


    public ItemRecyclerViewAdapter (Context context, ArrayList<Item> mListItems){

        this.context = context;
        this.mListItems = mListItems;


    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View  view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list,parent,false);
        MyViewHolder myViewHolder = new MyViewHolder(view,context,mListItems);
        return  myViewHolder;
    }



    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        Item currentItem = mListItems.get(position);

         holder.item_name.setText(currentItem.getName());
        holder.item_category.setText(currentItem.getCategory());

    }


    @Override
    public int getItemCount() {

        return mListItems.size();
    }


    public static class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView item_name,
               item_category;
        ArrayList<Item> items= new ArrayList<Item>();
        Context context;

        public MyViewHolder(View itemView,Context context,ArrayList<Item> items) {
            super(itemView);
            this.items=items;
            itemView.setOnClickListener(this);
            this.context = context;

            item_name = (TextView) itemView.findViewById(R.id.item_name);
            item_category = (TextView) itemView.findViewById(R.id.category);

        }

        @Override

        public void onClick(View v) {
            int position = getAdapterPosition();
            Item item = this.items.get(position);
            Intent intent =new Intent(context, DisplayItemActivity.class);
            intent.putExtra("name",item.getName());
            intent.putExtra("category",item.getCategory());
            intent.putExtra("sale_price",Integer.toString(item.getSale_price()));
            intent.putExtra("quantity",Integer.toString(item.getQuantity()));
            this.context.startActivity(intent);

        }
    }


}
