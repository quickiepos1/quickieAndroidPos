package com.quickie.quickie.adapters;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.quickie.quickie.R;
import com.quickie.quickie.pojo.Item;

import java.util.ArrayList;

/**
 * Created by Aj Khalil on 2/1/2017.
 */

public class CustomAdapter extends ArrayAdapter<Item> {
    Context context;

    public CustomAdapter(Context context, int resourceId, ArrayList<Item> items) {
        super(context, resourceId, items);
        this.context = context;
    }

    /*private view holder class*/
    private class ViewHolder {

        TextView txtItemName;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        Item item = getItem(position);

        LayoutInflater mInflater = (LayoutInflater) context
                .getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
        if (convertView == null) {
            convertView = mInflater.inflate(R.layout.list_item, null);
            holder = new ViewHolder();
            holder.txtItemName = (TextView) convertView.findViewById(R.id.item_name_list);

            convertView.setTag(holder);
        } else
            holder = (ViewHolder) convertView.getTag();

        holder.txtItemName.setText(item.getName());

        return convertView;
    }
}