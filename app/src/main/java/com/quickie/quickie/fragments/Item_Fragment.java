package com.quickie.quickie.fragments;


import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.quickie.quickie.R;
import com.quickie.quickie.adapters.ItemRecyclerViewAdapter;
import com.quickie.quickie.mDatabase.QuickieDBHelper;
import com.quickie.quickie.pojo.Item;
import com.quickie.quickie.services.BackgroundTask;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class Item_Fragment extends Fragment {


    private static final String STATE_ITEMS = "state_items";
    private RecyclerView recyclerView;
    private ItemRecyclerViewAdapter adapter;
    ArrayList<Item> itemArrayList = new ArrayList<>();
    private Button btn;
    RecyclerView.LayoutManager layoutManager;


    public Item_Fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        View view = inflater.inflate(R.layout.fragment_item_, container, false);

        btn = (Button) view.findViewById(R.id.addButton);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                BackgroundTask backgroundTask = new BackgroundTask(getActivity());
                backgroundTask.execute();

            }
        });



       recyclerView = (RecyclerView) view.findViewById(R.id.recycler_view_item_list);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        adapter = new ItemRecyclerViewAdapter(getActivity(), itemArrayList);
        recyclerView.setAdapter(adapter);


        layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);

        QuickieDBHelper quickieDBHelper = new QuickieDBHelper(getActivity());
        SQLiteDatabase sqLiteDatabase = quickieDBHelper.getReadableDatabase();

        Cursor cursor = quickieDBHelper.getInformation(sqLiteDatabase);

        cursor.moveToFirst();
        do {
            Item item =  new Item(
                    cursor.getString(0),
                    cursor.getString(1),
                    cursor.getInt(2),
                    cursor.getInt(3)
            );
            itemArrayList.add(item);
        }while(cursor.moveToNext());
        quickieDBHelper.close();

        adapter = new ItemRecyclerViewAdapter(getActivity(),itemArrayList);
        recyclerView.setAdapter(adapter);


    return view;

 }
}
