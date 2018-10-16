package com.sakib.saintmartinguide;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Review extends AppCompatActivity {
EditText usname,rev;
Button submit,showRev;
    String hotel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_review);
        hotel=getIntent().getExtras().getString("hotelName");
        usname=(EditText)findViewById(R.id.editText);
        rev=(EditText)findViewById(R.id.editText2);
        submit=(Button)findViewById(R.id.sbmtbutton);
        showRev=(Button)findViewById(R.id.showRev);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name=usname.getText().toString();
                String review=rev.getText().toString();
                String hotelName=hotel;
                String method="submit";

                BackgroundWork backgroundWork=new BackgroundWork(Review.this);
                backgroundWork.execute(method,name,review,hotelName);
                usname.setText("");
                rev.setText("");
            }
        });

        showRev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String method="showReview";
                Toast.makeText(Review.this, hotel, Toast.LENGTH_LONG).show();
                String hotelName=hotel;
                BackgroundWork backgroundWork=new BackgroundWork(Review.this);
                backgroundWork.execute(method,hotelName);

            }
        });
    }
}
