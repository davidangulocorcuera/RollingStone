package com.example.biolizard.rollingstoneandroid.Controller;

import android.util.Log;
import android.view.View;

import com.example.biolizard.rollingstoneandroid.ViewHolders.ProfilesViewHolder;

public class ProfilesViewHolderEvents implements View.OnClickListener {
    ProfilesViewHolder profilesViewHolder;
    public ProfilesViewHolderEvents(ProfilesViewHolder profilesViewHolder) {
        this.profilesViewHolder = profilesViewHolder;
    }



    @Override
    public void onClick(View v) {
        Log.v("coche","funciona");
        profilesViewHolder.profilesListAdapterlistener.profileListAdapterCellClicked(profilesViewHolder);
    }
}
