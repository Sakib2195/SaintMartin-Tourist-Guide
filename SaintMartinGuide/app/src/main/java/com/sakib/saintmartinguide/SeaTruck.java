package com.sakib.saintmartinguide;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class SeaTruck extends AppCompatActivity {
    ListView truck;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sea_truck);

        truck = (ListView) findViewById(R.id.truckList);
        String[] values = new String[]{"keari Sinbad",
                "LCT Kutubdia",
                "Bay Cruise",
                "Eagle "





        };

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, android.R.id.text1, values);


        // Assign adapter to ListView
        truck.setAdapter(adapter);



    }
}
