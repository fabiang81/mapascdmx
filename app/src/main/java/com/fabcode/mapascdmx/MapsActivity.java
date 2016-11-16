package com.fabcode.mapascdmx;

import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private double latitude;
    private double longitude;
    private String placeName;
    int markerIcon;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        Bundle parameters = getIntent().getExtras();
        latitude = parameters.getDouble("latitude");
        longitude = parameters.getDouble("longitude");
        placeName = parameters.getString("placeName");

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
        LatLng mexico = new LatLng(latitude, longitude);

        if(placeName.equals("Coyoacán")){
            mMap.addMarker(new MarkerOptions().icon(BitmapDescriptorFactory.fromResource(R.drawable.marker_30)).position(mexico).title("Marker in Coyoacán"));
        }
        if(placeName.equals("Colonia Roma")){
            mMap.addMarker(new MarkerOptions().icon(BitmapDescriptorFactory.fromResource(R.drawable.marker_40)).position(mexico).title("Marker in Colonia Roma"));
        }
        if(placeName.equals("Zócalo")){
            mMap.addMarker(new MarkerOptions().icon(BitmapDescriptorFactory.fromResource(R.drawable.marker_48)).position(mexico).title("Marker in Zócalo"));
        }
        if(placeName.equals("Reforma")){
            mMap.addMarker(new MarkerOptions().icon(BitmapDescriptorFactory.fromResource(R.drawable.marker_50)).position(mexico).title("Marker in Reforma"));
        }

        //mMap.moveCamera(CameraUpdateFactory.newLatLng(mexico));
        mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(mexico , 16));
    }
}
