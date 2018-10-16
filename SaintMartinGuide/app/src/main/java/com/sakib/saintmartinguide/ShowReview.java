package com.sakib.saintmartinguide;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;


public class ShowReview extends AppCompatActivity {

    String jsonString,targetString;
    ArrayList<String> arrayList;
    ArrayAdapter<String>arrayAdapter;
    JSONArray jsonArray;
    ListView lv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_review);
        jsonString=getIntent().getExtras().getString("json_data");
//        if(jsonString!=null){
//            Toast.makeText(this,jsonString,Toast.LENGTH_LONG).show();
//        }else {
//            Toast.makeText(this,"moiraja",Toast.LENGTH_LONG).show();
//        }
        lv= (ListView) findViewById(R.id.sr1);
        arrayList=new ArrayList<String>();
        arrayAdapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,arrayList);
        lv.setAdapter(arrayAdapter);

        try {
            JSONObject jo=new JSONObject(jsonString);
            jsonArray=jo.getJSONArray("server_response");
            int count=0;
            String name,feedback;
            while (count<jsonArray.length()){
                JSONObject jsonObject=jsonArray.getJSONObject(count);
                name=jsonObject.getString("name");
                feedback=jsonObject.getString("feedback");

                arrayList.add("User Name:"+name+" \nFeedback: "+feedback);
                arrayAdapter.notifyDataSetChanged();
                count++;

            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }
}
