package com.weshare.sirius.weshare;

import android.Manifest;
import android.content.pm.PackageManager;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.location.LocationListener;

import android.location.Location;
import android.widget.Toast;
import android.content.Intent;

import java.util.ArrayList;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback, LocationListener, GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener, GoogleMap.OnMarkerClickListener {

    private GoogleMap mMap;
    LocationRequest request;
    GoogleApiClient client;
    private ArrayList<Marker> reqs;



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

        client = new GoogleApiClient.Builder(this)
                .addApi(LocationServices.API).addConnectionCallbacks(this)
                .addOnConnectionFailedListener(this)
                .build();

        client.connect();

//        // Add a marker in Sydney and move the camera
//        LatLng sydney = new LatLng(-34, 151);
//        mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));
//        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
//
//
//
//        try {
//            mMap.setMyLocationEnabled(true);
//        }
//        catch (SecurityException e) {
//            System.out.print("Location fetching failed");
//
//        }

    }

    @Override
    public void onLocationChanged(Location location) {
        if (location == null) {
            Toast.makeText(getApplicationContext(), "Location not found", Toast.LENGTH_SHORT).show();

        }
        else {
            LatLng latLngCurrent = new LatLng(location.getLatitude(), location.getLongitude());

            mMap.addMarker(new MarkerOptions().position(latLngCurrent).title("current location"));

            CameraUpdate update = CameraUpdateFactory.newLatLngZoom(latLngCurrent, 15);
            mMap.animateCamera(update);

            //current location is = 37.872536, -122.260868 (moffitt)
            //another current location is = 37.869843, -122.258810 (sproul)

            // lat 37.873465, long -122.257780 (evans)
            Request.initializeAllRequest();
            reqs = new ArrayList<>();
//            LatLng moffitt = new LatLng(37.872536, -122.260868);
//            mMap.addMarker(new MarkerOptions().position(moffitt).title("moffitt"));
//            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(moffitt, 15));

            mMap.setOnMarkerClickListener(this);

            for (Request r : Request.allRequests) {
                double lat = r.location.getLatitude();
                double lon = r.location.getLongitude();
                //if (Math.pow(Math.pow(lat,2) + Math.pow(lon, 2),0.5) < 0.004) {
                LatLng near = new LatLng(lat, lon);
                Marker m = mMap.addMarker(new MarkerOptions().position(near).title("Item name: " + r.itemName + ", tags: " + r.tags)
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE)));
                reqs.add(m);
                m.setTag(reqs.indexOf(m));
                mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(near, 15));
                mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(near, 15));
                //}
            }




        }

    }

    @Override
    public boolean onMarkerClick(Marker marker) {
        int index = (int) marker.getTag();

        Intent startIntent = new Intent(getApplicationContext(), DetailRequest.class);
        startIntent.putExtra("com.weshare.request.tagnumber", index);
        startActivity(startIntent);


        return false;
    }


    @Override
    public void onConnected(@Nullable Bundle bundle) {
        request = new LocationRequest().create();
        request.setInterval(1000);
        request.setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY);

        boolean mLocationPermissionGranted = true;


        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            System.out.print("not granted");

        }
        if (mLocationPermissionGranted) {
            LocationServices.FusedLocationApi.requestLocationUpdates(client,request,this);
        }
    }

    @Override
    public void onConnectionSuspended(int i) {

    }

    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {

    }



}
