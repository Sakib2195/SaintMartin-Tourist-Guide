package com.sakib.saintmartinguide;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class HotelList extends AppCompatActivity {
 ListView hotelList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hotel_list);

        hotelList=(ListView)findViewById(R.id.hotelList) ;
        String[] values = new String[]{"Blue Marine ",
                "Neel Digante ",
                "Ratnodeep Resort",
                "Shimana Periye",
                "Prasad Paradise",
                "Prince Heaven",
                "Coral Blue Resort"


        };

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, android.R.id.text1, values);


        // Assign adapter to ListView
        hotelList.setAdapter(adapter);
        hotelList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position){
                    case 0:
                        Intent i=new Intent(HotelList.this,BlueMarine.class);
                        startActivity(i);
                        break;
                    case 1:
                        Intent b=new Intent(HotelList.this,NeelDigante.class);
                        startActivity(b);
                        break;


                    case 2:
                        Intent a=new Intent(HotelList.this,Ratnodeep.class);
                        startActivity(a);
                        break;



                    case 3:
                        Intent j=new Intent(HotelList.this,ShimanaPeriye.class);
                        startActivity(j);
                        break;

                    case 4:
                        Intent k=new Intent(HotelList.this,PrashadParadise.class);
                        startActivity(k);
                        break;
                    case 5:
                        Intent e=new Intent(HotelList.this,PrinceHeaven.class);
                        startActivity(e);
                        break;

                    case 6:
                        Intent l=new Intent(HotelList.this,CoralBlue.class);
                        startActivity(l);
                        break;

                }
            }
        });
    }
}
