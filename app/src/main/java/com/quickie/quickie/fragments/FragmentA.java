package com.quickie.quickie.fragments;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import com.quickie.quickie.Cart.Cart;
import com.quickie.quickie.R;
import com.quickie.quickie.adapters.ItemGridViewAdapter;
import com.quickie.quickie.interfacases.Communicator;
import com.quickie.quickie.logging.Message;
import com.quickie.quickie.mDatabase.QuickieDBHelper;
import com.quickie.quickie.pojo.Item;

import java.util.ArrayList;

public class FragmentA extends android.support.v4.app.Fragment
        // implements AdapterView.OnItemClickListener
{

    public static Cart m_cart;
    TextView m_response;


    private RecyclerView recyclerView;
    private ItemGridViewAdapter adapter;
    ArrayList<Item> arrayList = new ArrayList<>();
    RecyclerView.LayoutManager layoutManager;
    TextView receipt;
    Communicator communicator;

    ListView listView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_a, container, false);
        return view;
    }

    //
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);


        //ArrayAdapter adapter = ArrayAdapter.createFromResource(getActivity(), R.array.titles, android.R.layout.simple_list_item_1);

        receipt = (TextView) getActivity().findViewById(R.id.receipt);

//        receipt.setPaintFlags(receipt.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);

        recyclerView = (RecyclerView) getActivity().findViewById(R.id.grid_recyclerView);

        layoutManager = new GridLayoutManager(getActivity(),3);
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
            arrayList.add(item);
        }while(cursor.moveToNext());
        quickieDBHelper.close();

        adapter = new ItemGridViewAdapter(getActivity(),arrayList);
        adapter.setClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int pos = recyclerView.indexOfChild(v);
                Item item =  arrayList.get(pos);

                communicator.respond(item);
                communicator.refreshCartList();


            }
        });
        recyclerView.setAdapter(adapter);

        recyclerView.setAdapter(adapter);



    }
}


