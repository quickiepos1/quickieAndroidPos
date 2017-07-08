package com.quickie.quickie.fragments;


import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.quickie.quickie.R;
import com.quickie.quickie.adapters.CustomAdapter;
import com.quickie.quickie.pojo.Item;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class Fragment_cart extends Fragment {


    private ListView listView;
    CustomAdapter adapter;
    ArrayList<Item> orderedItems;

    public Fragment_cart() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_cart, container, false);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
//
//        orderedItems =  MainController.getInstance().getOrderedItems();
//
//
//        listView = (ListView) getActivity().findViewById(R.id.list_view_cart);
//        adapter = new CustomAdapter(getActivity(), R.id.list_view_cart, orderedItems);
//        listView.setAdapter(adapter);
        
    }

    public void changeData(Item item) {

//        orderedItems.add(item);
    }

    public void refreshList() {

//        this.adapter.notifyDataSetChanged();

    }
}

