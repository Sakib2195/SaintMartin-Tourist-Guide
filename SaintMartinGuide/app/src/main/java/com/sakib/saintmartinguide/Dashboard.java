package com.sakib.saintmartinguide;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;

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
import java.util.ArrayList;

public class Dashboard extends AppCompatActivity {


    String json_string,target_string,newString;
    ArrayList<String> arrayList;
    ArrayAdapter<String>arrayAdapter;
    JSONArray jsonArray;
    ListView lv;

    JSONObject jsonObject;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        //tvLog= (TextView) findViewById(R.id.tvLog);
        //showLogBtn= (Button) findViewById(R.id.btnLog);
        lv= (ListView) findViewById(R.id.listView10);
        arrayList=new ArrayList<String>();
        arrayAdapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,arrayList);
        lv.setAdapter(arrayAdapter);
        new backgroundTask().execute();




    }


    class backgroundTask extends AsyncTask<Void ,Void, String> {


        String json_url;

        @Override
        protected void onPreExecute() {
            json_url="http://chowdhurysakib.info/rahman/fetch.php";

        }

        @Override
        protected String doInBackground(Void... params) {

            try {
                URL url=new URL(json_url);
                HttpURLConnection httpURLConnection=(HttpURLConnection)url.openConnection();
                InputStream inputStreamReader=httpURLConnection.getInputStream();
                BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(inputStreamReader));
                StringBuilder stringBuilder=new StringBuilder();
                while ((json_string=bufferedReader.readLine())!=null){

                    stringBuilder.append(json_string + "\n");
                    bufferedReader.close();
                    inputStreamReader.close();
                    httpURLConnection.disconnect();

                    return stringBuilder.toString().trim();
                }
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

            return null;
        }

        @Override
        protected void onProgressUpdate(Void... values) {
            super.onProgressUpdate(values);
        }

        @Override
        protected void onPostExecute(String result) {
            newString=result;
            //Toast.makeText(MyDashboard.this,newString,Toast.LENGTH_LONG).show();
            try {
                // JSONArray new_array = new JSONArray(result);
                JSONObject jo=new JSONObject(result);
                jsonArray=jo.getJSONArray("server_response");
                //arrayList.add("tada2");
                // Toast.makeText(MyDashboard.this,"hi",Toast.LENGTH_LONG).show();
                int count=0;
                String From,To,Cabin,JDate,ticket,totalCost,ticketNo;
                while (count<jsonArray.length()){
                    JSONObject jsonObject=jsonArray.getJSONObject(count);

                    totalCost=jsonObject.getString("cost");
                    ticketNo=jsonObject.getString("ticket");


                    arrayList.add("Booking No :" + (ticketNo+100*5/2) + " \nTotal Cost : " + totalCost);
                    arrayAdapter.notifyDataSetChanged();
                    count++;

                }
//                arrayList.add(mystr);
//                arrayAdapter.notifyDataSetChanged();

            } catch (JSONException e) {
                e.printStackTrace();

            }
        }
    }
}