package com.sakib.saintmartinguide;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CircleOptions;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera
        LatLng sydney = new LatLng(20.628007, 92.323194);
        mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in SaintMartin"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));


        LatLng dg = new LatLng(20.635864, 92.328182);


     MarkerOptions map= new MarkerOptions();
      map.icon(BitmapDescriptorFactory.fromResource(R.drawable.danger));
        map.position(dg).title("Danger Zone");
        mMap.addMarker(map);
        mMap.moveCamera(CameraUpdateFactory.newLatLng(dg));


        LatLng dg2 = new LatLng(20.634405,  92.317500);
        MarkerOptions map2= new MarkerOptions();
        map2.icon(BitmapDescriptorFactory.fromResource(R.drawable.danger));
        map2.position(dg2).title("Danger Zone");
        mMap.addMarker(map2);
        mMap.moveCamera(CameraUpdateFactory.newLatLng(dg2));

        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(20.628007, 92.323194), 14.0f));



        CircleOptions circleOptions = new CircleOptions()
                .center(dg)   //set center
                .radius(100)   //set radius in meters
                .fillColor(Color.TRANSPARENT)
                .strokeColor(Color.RED)
                .strokeWidth(8);

        mMap.addCircle(circleOptions);

        CircleOptions circleOptions2 = new CircleOptions()
                .center(dg2)   //set center
                .radius(100)   //set radius in meters
                .fillColor(Color.TRANSPARENT)
                .strokeColor(Color.RED)
                .strokeWidth(8);

        mMap.addCircle(circleOptions2);
    }
}
