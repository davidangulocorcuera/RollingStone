package com.example.biolizard.rollingstoneandroid.Activities;

import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.LinearLayout;

import com.example.biolizard.rollingstoneandroid.Adapters.ProfilesListAdapter;
import com.example.biolizard.rollingstoneandroid.Controller.PrincipalActivityEvents;
import com.example.biolizard.rollingstoneandroid.Model.DataHolder;
import com.example.biolizard.rollingstoneandroid.R;
import com.example.rollingstonelibrary.List.ListFragment;

public class PrincipalActivity extends AppCompatActivity {
   public ListFragment listFragmentMessages;
   public ListFragment listFragmentProfiles;
    public ProfilesListAdapter profilesListAdapter;
    FragmentTransaction transaction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
        PrincipalActivityEvents principalActivityEvents = new PrincipalActivityEvents(this);
        DataHolder.instance.firebaseAdmin.setFirebaseAdminListener(principalActivityEvents);

       // listFragmentMessages = (ListFragment) getSupportFragmentManager().findFragmentById(R.id.fragment_messagesList);
       // listFragmentProfiles = (ListFragment) getSupportFragmentManager().findFragmentById(R.id.fragment_profilesList);



        listFragmentProfiles = new ListFragment();
        listFragmentMessages = new ListFragment();

        transaction = getSupportFragmentManager().beginTransaction();
        transaction.add(R.id.linearlayout_container,listFragmentProfiles,"lf_profiles");
        transaction.add(R.id.linearlayout_container_second_fragment,listFragmentMessages,"lf_messages");
        transaction.commit();



        DataHolder.instance.firebaseAdmin.downloadAndObserveBranch("messages");
        DataHolder.instance.firebaseAdmin.downloadAndObserveBranch("Profiles");

       /* MessagesListAdapter messagesListAdapter = new MessagesListAdapter();
        listFragment.recyclerView.setAdapter(messagesListAdapter);*/

    }
}
