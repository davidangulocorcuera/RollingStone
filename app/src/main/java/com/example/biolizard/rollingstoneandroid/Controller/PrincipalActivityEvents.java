package com.example.biolizard.rollingstoneandroid.Controller;

import android.util.Log;

import com.example.biolizard.rollingstoneandroid.Activities.PrincipalActivity;
import com.example.biolizard.rollingstoneandroid.Adapters.ProfileListAdapter;
import com.example.biolizard.rollingstoneandroid.Model.FirebaseAdminListener;
import com.example.biolizard.rollingstoneandroid.Model.Profile;
import com.google.firebase.database.DataSnapshot;

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
    }





    @Override
    public void firebaseAdmin_RegisterOK(boolean bl_ok) {

    }

    @Override
    public void firebaseAdmin_LoginOK(boolean bl_ok) {

    }

}
