package com.quickie.quickie.mDatabase;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import static com.quickie.quickie.mDatabase.QuickieContract.ItemEntry.QUANTITY;
import static com.quickie.quickie.mDatabase.QuickieContract.ItemEntry.SALE_PRICE;
import static com.quickie.quickie.mDatabase.QuickieContract.ItemEntry.TABLE_NAME;
import static com.quickie.quickie.mDatabase.QuickieContract.ItemEntry.NAME;
import static com.quickie.quickie.mDatabase.QuickieContract.ItemEntry.CATEGORY;


/**
 * Created by user on 6/4/2017.
 */

public class QuickieDBHelper extends SQLiteOpenHelper {

    public static final String DB_NAME = "item_db";
    public static final int DB_VERSION = 5;
    public static final String CREATE_QUERY = " CREATE TABLE " + TABLE_NAME +"("+
                                                    NAME +" text, "+
                                                   CATEGORY +" text, "+
                                                    SALE_PRICE +" INTEGER, " +
                                                   QUANTITY +" INTEGER);";

    private   static final String DROP_TABLE ="DROP TABLE IF EXISTS "+ TABLE_NAME;



    public QuickieDBHelper(Context context) {
        super(context,DB_NAME,null,DB_VERSION);
        Log.d("Database operations","Database is created");
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        try {
            db.execSQL(CREATE_QUERY);
            Log.d("Database operations","Database is created ");

        } catch (SQLiteException exception) {
            Log.d("Database operations","Database error ");
            exception.getMessage();

        }

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL(DROP_TABLE);
        onCreate(db);
        Log.d("Database operations","Database is upgraded ");

    }
    public void putInformation (String name,String category,int sale_price , int quantity, SQLiteDatabase db){

        ContentValues contentValues = new ContentValues();
        contentValues.put(NAME,name);
        contentValues.put(CATEGORY,category);
        contentValues.put(SALE_PRICE,sale_price);
        contentValues.put(QUANTITY,quantity);

        long l = db.insert(TABLE_NAME,null,contentValues);
        Log.d("Database operations","One row inserted");

    }

    public Cursor getInformation (SQLiteDatabase db){

        String [] projections = {NAME,CATEGORY,SALE_PRICE,QUANTITY};
        Cursor cursor = db.query(TABLE_NAME,projections,null,null,null,null,null);
        return cursor;

    }
}
