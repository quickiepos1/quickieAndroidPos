package com.quickie.quickie.services;


import com.quickie.quickie.pojo.Item;

import java.util.ArrayList;

/**
 * Created by user on 6/15/2017.
 */

public class MainController {

    private static MainController instance;
    private ArrayList<Item> orderedItems;

    String name;
    String category;
    int sale_price;
    int quantity;


    private MainController() {
        this.orderedItems = new ArrayList<Item>();

    }

    public static MainController getInstance() {
        if (instance == null) {

            instance = new MainController();
        }
        return instance;
    }

    public void addOrderedItems(Item item) {


        Item orderedItem = new Item(name, category, sale_price, quantity);

        this.orderedItems.add(orderedItem);


    }

    public ArrayList<Item> getOrderedItems() {
        return this.orderedItems;
    }
}


