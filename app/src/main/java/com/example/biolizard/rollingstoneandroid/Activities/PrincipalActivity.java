package com.example.biolizard.rollingstoneandroid.Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.biolizard.rollingstoneandroid.Controller.PrincipalActivityEvents;
import com.example.biolizard.rollingstoneandroid.Model.DataHolder;
import com.example.biolizard.rollingstoneandroid.R;
import com.example.rollingstonelibrary.List.ListFragment;

public class PrincipalActivity extends AppCompatActivity {
   public ListFragment listFragmentMessages;
   public ListFragment listFragmentProfiles;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
        PrincipalActivityEvents principalActivityEvents = new PrincipalActivityEvents(this);
        DataHolder.instance.firebaseAdmin.setFirebaseAdminListener(principalActivityEvents);

        listFragmentMessages = (ListFragment) getSupportFragmentManager().findFragmentById(R.id.fragment_messagesList);
        listFragmentProfiles = (ListFragment) getSupportFragmentManager().findFragmentById(R.id.fragment_profilesList);

        DataHolder.instance.firebaseAdmin.downloadAndObserveBranch("messages");
        DataHolder.instance.firebaseAdmin.downloadAndObserveBranch("Profiles");

       /* MessagesListAdapter messagesListAdapter = new MessagesListAdapter();
        listFragment.recyclerView.setAdapter(messagesListAdapter);*/

    }
}
