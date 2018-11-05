package com.example.biolizard.rollingstoneandroid.Controller;

import android.transition.Transition;
import android.util.Log;

import com.example.biolizard.rollingstoneandroid.Activities.PrincipalActivity;
import com.example.biolizard.rollingstoneandroid.Adapters.MessagesListAdapter;
import com.example.biolizard.rollingstoneandroid.Adapters.ProfilesListAdapter;
import com.example.biolizard.rollingstoneandroid.Adapters.ProfilesListAdapterlistener;
import com.example.biolizard.rollingstoneandroid.Model.DataHolder;
import com.example.biolizard.rollingstoneandroid.Model.Firebase.FirebaseAdminListener;
import com.example.biolizard.rollingstoneandroid.Model.Objects.Message;
import com.example.biolizard.rollingstoneandroid.Model.Objects.Profile;
import com.example.biolizard.rollingstoneandroid.R;
import com.example.biolizard.rollingstoneandroid.ViewHolders.ProfilesViewHolder;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.GenericTypeIndicator;
import com.google.firebase.database.Transaction;

import java.util.ArrayList;
import java.util.HashMap;

public class PrincipalActivityEvents implements FirebaseAdminListener,ProfilesListAdapterlistener,OnMapReadyCallback,GoogleMap.OnMarkerClickListener {
    PrincipalActivity principalActivity;
    HashMap<Integer, com.example.rollingstonelibrary.Model.Profile> hm_profiles;
     ArrayList<Profile> profiles;

    GoogleMap mMap;
    public PrincipalActivityEvents(PrincipalActivity principalActivity){
        this.principalActivity = principalActivity;
    }

    @Override
    public void firebaseAdmin_BranchDownloaded(String str_branch, DataSnapshot dataSnapshot) {
        Log.v("secondactivity", str_branch + " " + dataSnapshot);
        if(str_branch.equals("messages")){
/*
         GenericTypeIndicator <HashMap<String,Message>> indicator;

       indicator =  new GenericTypeIndicator<HashMap<String, Message>>() {};
         HashMap <String,Message> hm_messages = dataSnapshot.getValue(indicator);
        Log.v("mensaje", String.valueOf(hm_messages.values()));

        MessagesListAdapter messagesListAdapter = new MessagesListAdapter(new ArrayList<Message>(hm_messages.values()));
        principalActivity.listFragmentMessages.recyclerView.setAdapter(messagesListAdapter);

*/

        }
        else if(str_branch.equals("Profiles")) {
           GenericTypeIndicator <ArrayList<Profile>> indicator;

            indicator =  new GenericTypeIndicator<ArrayList<Profile>>() {};
         profiles = dataSnapshot.getValue(indicator);


            principalActivity.profilesListAdapter = new ProfilesListAdapter(profiles,principalActivity);
            principalActivity.listFragmentProfiles.recyclerView.setAdapter( principalActivity.profilesListAdapter);
            principalActivity.profilesListAdapter.setProfilesListAdapterlistener(this);
            addProfilesOnMap();


           }
        }

       public void addProfilesOnMap(){
           for (Profile elto:profiles) {
               Profile profileTemp = elto;
               LatLng profile_pos = new LatLng(profileTemp.getLat(),profileTemp.getLon());
               MarkerOptions markerOptions = new MarkerOptions();
               markerOptions.position(profile_pos);
               markerOptions.title(profileTemp.getName());

              if (mMap != null) {
                  Marker marker = mMap.addMarker(markerOptions);
                  marker.setTag(profileTemp);
                  profileTemp.setMarker(marker);

                  mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(profile_pos, 5));
              }
           }
                }




    @Override
    public void firebaseAdmin_RegisterOK(boolean bl_ok) {

    }

    @Override
    public void firebaseAdmin_LoginOK(boolean bl_ok) {

    }

    @Override
    public void profileListAdapterCellClicked(ProfilesViewHolder profilesViewHolder) {
        DataHolder.instance.firebaseAdmin.downloadAndObserveBranch("Profiles");
        Log.v("coche","funciona" + profilesViewHolder.getAdapterPosition());
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        googleMap.setOnMarkerClickListener(this);
        // Add a marker in Sydney and move the camera
        /*LatLng sydney = new LatLng(-34, 151);
        mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));*/
        DataHolder.instance.firebaseAdmin.downloadAndObserveBranch("Profiles");
    }

    @Override
    public boolean onMarkerClick(Marker marker) {
        Profile profile = (Profile)marker.getTag();
        Log.v("marker","presionado pin "+ profile.getName());
        return false;
    }
}
