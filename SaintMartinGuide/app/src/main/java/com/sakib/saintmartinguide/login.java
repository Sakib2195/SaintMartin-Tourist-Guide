package com.sakib.saintmartinguide;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
public class login extends AppCompatActivity {

    TextView regTv,brandName;
    EditText lgnUsername,lgnPass;
    Button lgnBtn;
    String login_name,login_pass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        final String hotelName=getIntent().getExtras().getString("planename");

        brandName=(TextView)findViewById(R.id.textView);


        regTv=(TextView)findViewById(R.id.regTv);
        lgnUsername=(EditText)findViewById(R.id.lgnUsername);
        lgnPass=(EditText)findViewById(R.id.lgnPass);
        lgnBtn=(Button)findViewById(R.id.loginBtn);

        //lgnBtn.setTypeface(typeface1);

        lgnBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                login_name=lgnUsername.getText().toString();
                login_pass=lgnPass.getText().toString();
                String method="login";
                BackgroundWork2 prc=new BackgroundWork2(login.this);
                prc.execute(method,login_name,login_pass,hotelName);
                lgnUsername.setText("");
                lgnPass.setText("");
                finish();
            }
        });




        regTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(login.this,Register.class);
                startActivity(i);
            }
        });
    }


}
