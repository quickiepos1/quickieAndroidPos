package com.quickie.quickie.pojo;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;

/**
 * Created by user on 5/22/2017.
 */

public class Item implements Parcelable {

    String name;
    int sale_price;
    int cost_price;
    int quantity;
    String category;

    public Item(Parcel input) {

        name = input.readString();
        category = input.readString();
        sale_price= input.readInt();
        quantity = input.readInt();
    }

    public Item(String name,
                String category,
                int sale_price,
                int quantity) {

        this.setName(name);
        this.setCategory(category);
        this.setSale_price(sale_price);
        this.setQuantity(quantity);
    }
public Item () {


}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSale_price() {
        return sale_price;
    }

    public void setSale_price(int sale_price) {
        this.sale_price = sale_price;
    }

    public int getCost_price() {
        return cost_price;
    }

    public void setCost_price(int cost_price) {
        this.cost_price = cost_price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "NAME: " + name +
                "CATEGORY: "+ category
                +"SALE PRICE: " +sale_price
                 + "QUANTITY: "  + quantity;

    }

    @Override
    public int describeContents() {
        Log.d("AJ","describe item contents");
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        Log.d("AJ","WriteParcel Item");
        dest.writeString(name);
        dest.writeString(category);
        dest.writeInt(sale_price);
        dest.writeInt(quantity);
    }

    public static final Parcelable.Creator<Item> CREATOR
            = new Parcelable.Creator<Item>() {
        public Item createFromParcel(Parcel in)
        {
            Log.d("AJ","create from parcel: Item ");
            return new Item(in);
        }

        public Item[] newArray(int size) {
            return new Item[size];
        }
    };
}
