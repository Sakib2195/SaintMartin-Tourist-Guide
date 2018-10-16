package com.sakib.saintmartinguide;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;



public class Register extends AppCompatActivity {

    EditText RetUsername, Retpass, nationalId, RetMail, RetContact, RetAddress;
    TextView register;
    Button regBtn;
    String name, pass, nId, contact, mail, address;
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        register=(TextView)findViewById(R.id.textView5);
//        Typeface tp=Typeface.createFromAsset(getAssets(),"sansationregular.ttf");
//        register.setTypeface(tp);
        RetUsername = (EditText) findViewById(R.id.RetUsername);
        Retpass = (EditText) findViewById(R.id.RetPass);
        nationalId = (EditText) findViewById(R.id.nationalID);
        RetMail = (EditText) findViewById(R.id.RetMail);
        RetContact = (EditText) findViewById(R.id.RetContact);
        RetAddress = (EditText) findViewById(R.id.RetAddress);
        regBtn = (Button) findViewById(R.id.Rbtn);


        regBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                name = RetUsername.getText().toString();
                pass = Retpass.getText().toString();
                nId = nationalId.getText().toString();
                contact = RetContact.getText().toString();
                mail = RetMail.getText().toString();
                address = RetAddress.getText().toString();

                String method = "register";
                BackgroundWork2 prc=new BackgroundWork2(Register.this);
                prc.execute(method,name,pass,nId,contact,mail,address);
                finish();




            }
        });



    }


}
