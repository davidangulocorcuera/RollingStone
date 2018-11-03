package com.example.biolizard.rollingstoneandroid.Controller;

import android.util.Log;

import com.example.biolizard.rollingstoneandroid.Activities.PrincipalActivity;
import com.example.biolizard.rollingstoneandroid.Adapters.MessagesListAdapter;
import com.example.biolizard.rollingstoneandroid.Adapters.ProfilesListAdapter;
import com.example.biolizard.rollingstoneandroid.Model.Firebase.FirebaseAdminListener;
import com.example.biolizard.rollingstoneandroid.Model.Objects.Message;
import com.example.biolizard.rollingstoneandroid.Model.Objects.Profile;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.GenericTypeIndicator;

import java.util.ArrayList;
import java.util.HashMap;

public class PrincipalActivityEvents implements FirebaseAdminListener {
    PrincipalActivity principalActivity;
    HashMap<Integer, com.example.rollingstonelibrary.Model.Profile> hm_profiles;
    public PrincipalActivityEvents(PrincipalActivity principalActivity){
        this.principalActivity = principalActivity;
    }

    @Override
    public void firebaseAdmin_BranchDownloaded(String str_branch, DataSnapshot dataSnapshot) {
        Log.v("secondactivity", str_branch + " " + dataSnapshot);
        if(str_branch.equals("messages")){

         GenericTypeIndicator <HashMap<String,Message>> indicator;

       indicator =  new GenericTypeIndicator<HashMap<String, Message>>() {};
         HashMap <String,Message> hm_messages = dataSnapshot.getValue(indicator);
        Log.v("mensaje", String.valueOf(hm_messages.values()));

        MessagesListAdapter messagesListAdapter = new MessagesListAdapter(new ArrayList<Message>(hm_messages.values()));
        principalActivity.listFragmentMessages.recyclerView.setAdapter(messagesListAdapter);

        }
        else if(str_branch.equals("Profiles")) {
           GenericTypeIndicator <ArrayList<Profile>> indicator;

            indicator =  new GenericTypeIndicator<ArrayList<Profile>>() {};
            ArrayList <Profile> profiles = dataSnapshot.getValue(indicator);
            //Log.v("mensaje", String.valueOf());

            ProfilesListAdapter profilesListAdapter = new ProfilesListAdapter(profiles,principalActivity);
            principalActivity.listFragmentProfiles.recyclerView.setAdapter(profilesListAdapter);

        }
        }






    @Override
    public void firebaseAdmin_RegisterOK(boolean bl_ok) {

    }

    @Override
    public void firebaseAdmin_LoginOK(boolean bl_ok) {

    }

}
