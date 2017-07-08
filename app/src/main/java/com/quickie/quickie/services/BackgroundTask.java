package com.quickie.quickie.services;

import android.app.ProgressDialog;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.os.AsyncTask;

import com.quickie.quickie.mDatabase.QuickieDBHelper;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by user on 6/4/2017.
 */

public class BackgroundTask extends AsyncTask <Void,Void,Void> {

    ProgressDialog progressDialog;
    String json_url = "http://10.0.2.2:8000/item/?format=json";
    Context context;

  public  BackgroundTask(Context context){
        this.context = context;
    }

    @Override
    protected void onPreExecute() {
       progressDialog = new ProgressDialog(context);
        progressDialog.setIndeterminate(true);
        progressDialog.setTitle("Please Wait...");
        progressDialog.setMessage("Download in progress.. ");
        progressDialog.setCancelable(false);
        progressDialog.show();
    }

    @Override
    protected Void doInBackground(Void... params) {

        try {
            URL url = new URL(json_url);
            HttpURLConnection httpURLConnection = (HttpURLConnection)url.openConnection();
            InputStream inputStream = httpURLConnection.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            StringBuilder stringBuilder = new StringBuilder();
            String line;

            while( (line = bufferedReader.readLine()) != null){

                stringBuilder.append(line +"\n");
                Thread.sleep(500);

            }

            httpURLConnection.disconnect();
            String json_data = stringBuilder.toString().trim();
            JSONObject jsonObject = new JSONObject(json_data);
            JSONArray jsonArray = jsonObject.getJSONArray("results");
            QuickieDBHelper quickieDBHelper = new QuickieDBHelper(context);
            SQLiteDatabase db = quickieDBHelper.getWritableDatabase();

            int count = 0;
            while (count < jsonArray.length())
            {
                JSONObject jsonObject1 = jsonArray.getJSONObject(count);
                count++;
                quickieDBHelper.putInformation(
                        jsonObject1.getString("name"),
                        jsonObject1.getString("category"),
                        jsonObject1.getInt("sale_price"),
                        jsonObject1.getInt("quantity"),
                        db
                );

            }

            quickieDBHelper.close();

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        return null;
    }

    @Override
    protected void onProgressUpdate(Void... values) {
        super.onProgressUpdate(values);
    }

    @Override
    protected void onPostExecute(Void aVoid) {
      progressDialog.dismiss();
    }


}
