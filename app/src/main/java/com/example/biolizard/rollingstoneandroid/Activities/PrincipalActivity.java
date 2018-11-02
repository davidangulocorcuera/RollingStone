package com.example.biolizard.rollingstoneandroid.Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.biolizard.rollingstoneandroid.Adapters.ProfileListAdapter;
import com.example.biolizard.rollingstoneandroid.Controller.PrincipalActivityEvents;
import com.example.biolizard.rollingstoneandroid.Model.DataHolder;
import com.example.biolizard.rollingstoneandroid.Model.Profile;
import com.example.biolizard.rollingstoneandroid.R;
import com.example.rollingstonelibrary.ProfilesList.ProfilesListFragment;

import java.util.HashMap;

public class PrincipalActivity extends AppCompatActivity {
    ProfilesListFragment profilesListFragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
        PrincipalActivityEvents principalActivityEvents = new PrincipalActivityEvents(this);
        DataHolder.instance.firebaseAdmin.setFirebaseAdminListener(principalActivityEvents);
        profilesListFragment = (ProfilesListFragment) getSupportFragmentManager().findFragmentById(R.id.fragment_profilesList);
        DataHolder.instance.firebaseAdmin.downloadAndObserveBranch("Users");

        ProfileListAdapter profileListAdapter = new ProfileListAdapter();
        profilesListFragment.recyclerView.setAdapter(profileListAdapter);

    }
}
