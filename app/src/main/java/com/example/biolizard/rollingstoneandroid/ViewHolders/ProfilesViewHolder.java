package com.example.biolizard.rollingstoneandroid.ViewHolders;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.biolizard.rollingstoneandroid.Adapters.ProfilesListAdapterlistener;
import com.example.biolizard.rollingstoneandroid.Controller.ProfilesViewHolderEvents;
import com.example.biolizard.rollingstoneandroid.R;

public class ProfilesViewHolder extends  RecyclerView.ViewHolder{
    public TextView tv_name;
    public TextView tv_age;
    public ImageView iv_profilePicture;
    public ProfilesListAdapterlistener profilesListAdapterlistener;
    public void setProfilesListAdapterlistener(ProfilesListAdapterlistener profilesListAdapterlistener) {
        this.profilesListAdapterlistener = profilesListAdapterlistener;
    }



    public ProfilesViewHolder(@NonNull View itemView) {
        super(itemView);
        tv_name = itemView.findViewById(R.id.textView_name);
        tv_age = itemView.findViewById(R.id.textView_age);
        iv_profilePicture = itemView.findViewById(R.id.imageView_profile);

        ProfilesViewHolderEvents profileViewHolderEvents = new ProfilesViewHolderEvents(this);
        itemView.setOnClickListener(profileViewHolderEvents);
    }
}