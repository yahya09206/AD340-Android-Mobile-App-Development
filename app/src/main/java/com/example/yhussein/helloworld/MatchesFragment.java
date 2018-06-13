package com.example.yhussein.helloworld;

import android.Manifest;
import android.annotation.SuppressLint;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.arch.persistence.room.Room;
import android.content.pm.PackageManager;
import android.location.Location;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.yhussein.helloworld.database.Database;
import com.example.yhussein.helloworld.models.Match;
import com.example.yhussein.helloworld.models.SettingsData;
import com.example.yhussein.helloworld.viewModels.SettingsViewModel;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.model.LatLng;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class MatchesFragment extends Fragment implements GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener {


    private ArrayList<Match> matches = new ArrayList<>();
    private ListView matchList;
    private GoogleApiClient googleApiClient;
    private LocationRequest locationRequest;
    private Double currentLatitude = 0.0;
    private Double currentLongitude = 0.0;
    private SettingsData savedSettingsData;
    private int MAX_DISTANCE = 10;

    private SettingsViewModel settingsViewModel;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_matches, container, false);

        matchList = view.findViewById(R.id.matchList);

        //Connect to Google to enable LocationServices API
        connectToGoogle();

        //MVVM Implementation
        settingsViewModel = ViewModelProviders.of(this).get(SettingsViewModel.class);
        settingsViewModel.getSavedSettingsData().observe(this, new Observer<SettingsData>() {
            @Override
            public void onChanged(@Nullable SettingsData settingsData) {
                if (settingsData != null){
                    //Set the distance to the saved setting
                    MAX_DISTANCE = Integer.parseInt(settingsData.getSearchDistance());
                }
            }
        });

        return view;
    }

    private void connectToGoogle() {
        googleApiClient = new GoogleApiClient.Builder(getActivity())
                .addConnectionCallbacks(this)
                .addOnConnectionFailedListener(this)
                .addApi(LocationServices.API)
                .build();
        googleApiClient.connect();
    }

    private void showMatches() {
        MatchesAdapter adapter = new MatchesAdapter(getActivity(), matches);
        matchList.setAdapter(adapter);
    }

    @Override
    public void onConnected(@Nullable Bundle bundle) {
        //Get current location coords of the device
        getCurrentLocation();
    }

    @SuppressLint("RestrictedApi")
    private void getCurrentLocation() {
        locationRequest = new LocationRequest();
        locationRequest.setSmallestDisplacement(1);
        locationRequest.setPriority(LocationRequest.PRIORITY_BALANCED_POWER_ACCURACY);  //To balance accuracy and battery consumption

        //Check for location permission
        if(ContextCompat.checkSelfPermission(getActivity(), Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED ||
                ContextCompat.checkSelfPermission(getActivity(), Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED){
            //Request for permission
            ActivityCompat.requestPermissions(getActivity(), new String[]{Manifest.permission.ACCESS_COARSE_LOCATION, Manifest.permission.ACCESS_FINE_LOCATION}, 10);
        }else{
            LocationServices.FusedLocationApi.requestLocationUpdates(googleApiClient, locationRequest, new LocationListener() {
                @Override
                public void onLocationChanged(Location location) {
                    currentLatitude = location.getLatitude();
                    currentLongitude = location.getLongitude();

                    FirebaseDatabase.getInstance().getReference().child("matches").addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot dataSnapshot) {
                            if (dataSnapshot.exists()){

                                matches.clear();

                                for(DataSnapshot snapshot : dataSnapshot.getChildren()){
                                    Match mMatch = snapshot.getValue(Match.class);

                                    /* THIS WAS TO TEST MY LOCATION
                                    currentLatitude = 47.466838;
                                    currentLongitude = -122.340530;
                                    */

                                    float[] results = new float[1];
                                    Location.distanceBetween(currentLatitude, currentLongitude, Double.parseDouble(mMatch.getLat()), Double.parseDouble(mMatch.getLongitude()), results);

                                    float distanceInMeters = results[0];
                                    double distanceInMiles = metersToMiles(distanceInMeters);

                                    //Check if match is within the search radius
                                    if (distanceInMiles <= MAX_DISTANCE){
                                        matches.add(mMatch);
                                    }

                                }

                                //Show the matches that are within the search radius
                                showMatches();

                            }
                        }

                        @Override
                        public void onCancelled(DatabaseError databaseError) {
                            LocationServices.FusedLocationApi.removeLocationUpdates(googleApiClient, new LocationListener() {
                                @Override
                                public void onLocationChanged(Location location) {

                                }
                            });
                        }
                    });

                }
            });
        }
    }

    @Override
    public void onConnectionSuspended(int i) {

    }

    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {

    }

    public double metersToMiles(float distanceInMeters){
        return distanceInMeters * 0.000621371;
    }
}
