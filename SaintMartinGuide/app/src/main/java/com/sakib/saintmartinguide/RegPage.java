package com.sakib.saintmartinguide;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class RegPage extends AppCompatActivity {

    CalendarView myCalendarView;
    TextView tv,tv2,tv3,tv4,tv5,tv6;
    Button sbmt;
    Spinner sp1,sp2,sp3;
    ArrayAdapter<CharSequence> adapter,adapter2,adapter3;
    String NoOfDay="";
    int nod =1;
   // String destination="";
    String cabin="";
    int Couple=2000;
    int Doubble2=2500;
    int Single=1500;
    int noOfpassenger=0;
    int totalCost=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reg_page);
        Toast.makeText(RegPage.this,"balalalala",Toast.LENGTH_LONG).show();
       // final String planename=getIntent().getExtras().getString("planename");

        tv= (TextView) findViewById(R.id.textView2);
        tv2= (TextView) findViewById(R.id.textView3);
        tv3= (TextView) findViewById(R.id.textView4);
        tv4= (TextView) findViewById(R.id.textView6);
        tv5= (TextView) findViewById(R.id.roomwanted);
        tv6= (TextView) findViewById(R.id.totalcost);
        sp1=(Spinner)findViewById(R.id.spinner2);
        adapter=ArrayAdapter.createFromResource(this, R.array.Day,android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sp1.setAdapter(adapter);

        sp1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                // Toast.makeText(getBaseContext(), parent.getItemAtPosition(position) + "is selected", Toast.LENGTH_LONG).show();
                NoOfDay=parent.getItemAtPosition(position).toString();
                nod=Integer.parseInt(NoOfDay);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        sp2=(Spinner)findViewById(R.id.spinner3);


        adapter2=ArrayAdapter.createFromResource(this, R.array.RoomType,android.R.layout.simple_spinner_item);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sp2.setAdapter(adapter2);
        sp2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                //Toast.makeText(getBaseContext(), parent.getItemAtPosition(position) + "is selected", Toast.LENGTH_LONG).show();
                cabin=parent.getItemAtPosition(position).toString();
                if(cabin.equals("Couple")){
                    tv4.setText("Cost per Ticket : "+Couple);
                }else if(cabin.equals("2 Double Bed")){
                    tv4.setText("Cost per Ticket : "+Doubble2);
                }else {
                    tv4.setText("Cost per Ticket   : "+Single);
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        sp3=(Spinner)findViewById(R.id.spinner4);
        adapter3=ArrayAdapter.createFromResource(this, R.array.Ticket,android.R.layout.simple_spinner_item);
        adapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sp3.setAdapter(adapter3);
        sp3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                //  Toast.makeText(getBaseContext(), parent.getItemAtPosition(position) + "is selected", Toast.LENGTH_LONG).show();
                String string=parent.getItemAtPosition(position).toString();
                noOfpassenger=Integer.parseInt(string);
                if(cabin.equals("Couple")){
                    totalCost=Couple*noOfpassenger*nod;
                    tv6.setText("Total cost : "+totalCost);
                }else if(cabin.equals("2 Double Bed")){
                    totalCost=Doubble2*noOfpassenger*nod;
                    tv6.setText("Total cost : "+totalCost);

                }else {
                    totalCost=Single*noOfpassenger*nod;
                    tv6.setText("Total cost : "+totalCost);

                }


            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        myCalendarView = (CalendarView)findViewById(R.id.calendar);
        final int[] myDate = new int[4];




        sbmt=(Button)findViewById(R.id.subReg);

        sbmt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String totalCost=tv6.getText().toString();
                myCalendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {

                    @Override
                    public void onSelectedDayChange(CalendarView view, int year,
                                                    int month, int dayOfMonth) {
                        Toast.makeText(getApplicationContext(),
                                "Year: " + year + "\n" +
                                        "Month: " + month + "\n" +
                                        "Day of Month: " + dayOfMonth,
                                Toast.LENGTH_LONG).show();
                        int y=year;
                        int m=month;
                        int d=dayOfMonth;

                        myDate[0] =year;
                        myDate[1]=month;
                        myDate[2]=dayOfMonth;
                    }
                });

                String journeyDate=myDate[2]+" / "+myDate[1]+" / "+myDate[0];
                Toast.makeText(RegPage.this,journeyDate,Toast.LENGTH_LONG).show();
                String method="booking";
                //Toast.makeText(Review.this,method,Toast.LENGTH_LONG).show();

                BackgroundWork backgroundWork=new BackgroundWork(RegPage.this);
                backgroundWork.execute(method, journeyDate,totalCost);
                Intent i = new Intent(RegPage.this, result.class);
                startActivity(i);

            }
        });



    }
}
