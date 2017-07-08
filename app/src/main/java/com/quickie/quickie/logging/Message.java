package com.quickie.quickie.logging;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by user on 4/11/2017.
 */

public class Message {

    public static void m(String message) {
        Log.d("AJ", "" + message);
    }

    public  static void  message (Context context,String massage){

        Toast.makeText(context,massage,Toast.LENGTH_LONG).show();

    }
}
