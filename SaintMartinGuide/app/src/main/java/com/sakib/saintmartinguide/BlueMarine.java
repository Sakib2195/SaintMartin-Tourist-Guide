package com.sakib.saintmartinguide;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class BlueMarine extends AppCompatActivity {

    Button call,revh1,bookh1;
    String hotelName= "Blue Marine";
    private static final int MAKE_CALL_PERMISSION_REQUEST_CODE = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_blue_marine);
        call=(Button)findViewById(R.id.callh1);
        revh1=(Button)findViewById(R.id.revh1) ;
        bookh1=(Button)findViewById(R.id.bookh1) ;
        revh1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(BlueMarine.this, Review.class);
                i.putExtra("hotelName",hotelName);
                startActivity(i);

            }
        });

        bookh1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(BlueMarine.this, login.class);
                i.putExtra("hotelName",hotelName);
                startActivity(i);

            }
        });


        call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String phoneNumber =  "01819063418";

                if (!TextUtils.isEmpty(phoneNumber)) {
                    if (checkPermission(Manifest.permission.CALL_PHONE)) {
                        String dial = "tel:" + phoneNumber;
                        startActivity(new Intent(Intent.ACTION_CALL, Uri.parse(dial)));
                    } else {
                        Toast.makeText(BlueMarine.this, "Permission Call Phone denied", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(BlueMarine.this, "Enter a phone number", Toast.LENGTH_SHORT).show();
                }
            }
        });
        if (checkPermission(Manifest.permission.CALL_PHONE)) {
            call.setEnabled(true);
        } else {
            call.setEnabled(false);
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CALL_PHONE}, MAKE_CALL_PERMISSION_REQUEST_CODE);
        }



    }

    private boolean checkPermission(String permission) {
        return ContextCompat.checkSelfPermission(this, permission) == PackageManager.PERMISSION_GRANTED;
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch(requestCode) {
            case MAKE_CALL_PERMISSION_REQUEST_CODE :
                if (grantResults.length > 0 && (grantResults[0] == PackageManager.PERMISSION_GRANTED)) {
                    call.setEnabled(true);
                    Toast.makeText(this, "You can call the number by clicking on the button", Toast.LENGTH_SHORT).show();
                }
                return;
        }
    }
}
