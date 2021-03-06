package com.sakib.saintmartinguide;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Eagle extends AppCompatActivity {
    Button call,revt4,bookt4;
    String hotelName= "Eagle";
    private static final int MAKE_CALL_PERMISSION_REQUEST_CODE = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eagle);
        call=(Button)findViewById(R.id.callt4);
        revt4=(Button)findViewById(R.id.rev4) ;

        revt4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Eagle.this, Review.class);
                i.putExtra("hotelName",hotelName);
                startActivity(i);

            }
        });

        call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String phoneNumber =  "01713145584";

                if (!TextUtils.isEmpty(phoneNumber)) {
                    if (checkPermission(Manifest.permission.CALL_PHONE)) {
                        String dial = "tel:" + phoneNumber;
                        startActivity(new Intent(Intent.ACTION_CALL, Uri.parse(dial)));
                    } else {
                        Toast.makeText(Eagle.this, "Permission Call Phone denied", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(Eagle.this, "Enter a phone number", Toast.LENGTH_SHORT).show();
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

