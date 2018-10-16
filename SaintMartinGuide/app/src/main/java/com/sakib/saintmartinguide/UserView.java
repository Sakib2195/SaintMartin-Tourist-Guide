package com.sakib.saintmartinguide;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class UserView extends AppCompatActivity {
    Button dashboard,reg;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_view);
        final String planename=getIntent().getExtras().getString("planename");
        Toast.makeText(UserView.this, planename, Toast.LENGTH_LONG).show();
        dashboard=(Button)findViewById(R.id.dashboard);
        reg=(Button)findViewById(R.id.regForm);

        reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(UserView.this, RegPage.class);

               i.putExtra("planename","tada");
                startActivity(i);
            }
        });
        dashboard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(UserView.this, Dashboard.class);


                startActivity(i);
            }
        });


    }
}
