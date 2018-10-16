package com.sakib.saintmartinguide;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class SeaTruckList extends AppCompatActivity {
    ListView truck;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sea_truck_list);

        truck = (ListView) findViewById(R.id.sealist);
        String[] values = new String[]{"keari Sinbad",
                "LCT Kutubdia",
                "Bay Cruise",
                "Eagle "





        };

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, android.R.id.text1, values);


        // Assign adapter to ListView
        truck.setAdapter(adapter);
        truck.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position){
                    case 0:
                        Intent i=new Intent(SeaTruckList.this,KeariSinbad.class);
                        startActivity(i);
                        break;
                    case 1:
                        Intent b=new Intent(SeaTruckList.this,LctKutub.class);
                        startActivity(b);
                        break;


                    case 2:
                        Intent a=new Intent(SeaTruckList.this,BayCruise.class);
                        startActivity(a);
                        break;



                    case 3:
                        Intent j=new Intent(SeaTruckList.this,Eagle.class);
                        startActivity(j);
                        break;
/*
                    case 4:
                        Intent k=new Intent(Hotels.this,PrashadParadise.class);
                        startActivity(k);
                        break;
                    case 5:
                        Intent e=new Intent(Hotels.this,PrinceHeaven.class);
                        startActivity(e);
                        break;

                    case 6:
                        Intent l=new Intent(Hotels.this,CoralBlue.class);
                        startActivity(l);
                        break;
                        */
                }
            }
        });



    }
}
