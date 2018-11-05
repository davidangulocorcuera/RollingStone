package com.example.biolizard.rollingstoneandroid.Activities;

import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.biolizard.rollingstoneandroid.Adapters.ProfilesListAdapter;
import com.example.biolizard.rollingstoneandroid.Controller.PrincipalActivityEvents;
import com.example.biolizard.rollingstoneandroid.Model.DataHolder;
import com.example.biolizard.rollingstoneandroid.Model.Objects.Profile;
import com.example.biolizard.rollingstoneandroid.R;
import com.example.rollingstonelibrary.List.ListFragment;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.firebase.database.Transaction;

import java.util.ArrayList;

public class PrincipalActivity extends AppCompatActivity {
   //public ListFragment listFragmentMessages;
   public ListFragment listFragmentProfiles;
    public ProfilesListAdapter profilesListAdapter;
    FragmentTransaction transaction;
    SupportMapFragment mapFragment;
    public ArrayList<Profile> profiles;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
        PrincipalActivityEvents principalActivityEvents = new PrincipalActivityEvents(this);
        DataHolder.instance.firebaseAdmin.setFirebaseAdminListener(principalActivityEvents);

        mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map_fragment);
        mapFragment.getMapAsync(principalActivityEvents);
        listFragmentProfiles = (ListFragment) getSupportFragmentManager().findFragmentById(R.id.fragment_profilesList);

        transaction = getSupportFragmentManager().beginTransaction();
        transaction.hide(listFragmentProfiles);
        transaction.show(mapFragment);
        transaction.commit();






    }
}
