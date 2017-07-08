package com.quickie.quickie.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.quickie.quickie.R;
import com.quickie.quickie.interfacases.Communicator;
import com.quickie.quickie.logging.Message;
import com.quickie.quickie.pojo.Item;


/**
 * A simple {@link Fragment} subclass.
 */
public class ActiveSale_Fragment extends Fragment implements Communicator {


 Button b1;
    public ActiveSale_Fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_active__sale, container, false);
        return  view;
    }
    @Override
    public void respond(Item item) {

        FragmentManager manager = getFragmentManager();
        Fragment_cart fragment_cart = (Fragment_cart) manager.findFragmentById(R.id.fragment_b);
        fragment_cart.changeData(item);

        Message.m(""+ item.getName());

    }

    @Override
    public void refreshCartList() {

        FragmentManager manager = getFragmentManager();
        Fragment_cart fragment_cart = (Fragment_cart) manager.findFragmentById(R.id.fragment_b);
        fragment_cart.refreshList();
    }

}
