package com.quickie.quickie.activities;

import android.graphics.Paint;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import com.quickie.quickie.R;

public class DisplayItemActivity extends AppCompatActivity {

    private Toolbar toolbar;
    TextView item_name,item_category,cost_price,sale_Price,quantity,details,inventory;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_item);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
       // getSupportActionBar().setDisplayHomeAsUpEnabled(true);
       // getSupportActionBar().setHomeButtonEnabled(true);


        details = (TextView) findViewById(R.id.details);
        inventory = (TextView) findViewById(R.id.inventory);

        details.setPaintFlags(details.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);
        inventory.setPaintFlags(inventory.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);


        item_name = (TextView) findViewById(R.id.item_name);
        item_category = (TextView) findViewById(R.id.item_category);
        sale_Price = (TextView) findViewById(R.id.sale_price);
        cost_price = (TextView) findViewById(R.id.cost_price);
        quantity = (TextView) findViewById(R.id.quantity);

        item_name.setText("" + getIntent().getStringExtra("name"));
        item_category.setText("" + getIntent().getStringExtra("category"));
        sale_Price.setText("" + getIntent().
                getStringExtra("sale_price"));
        cost_price.setText("N/A");
        quantity.setText("" + getIntent().getStringExtra("quantity"));



    }
}
