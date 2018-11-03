package com.example.biolizard.rollingstoneandroid.Adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.example.biolizard.rollingstoneandroid.Model.Objects.Profile;
import com.example.biolizard.rollingstoneandroid.R;
import com.example.biolizard.rollingstoneandroid.ViewHolders.ProfilesViewHolder;

import java.util.ArrayList;

public class ProfilesListAdapter extends RecyclerView.Adapter<ProfilesViewHolder> {
    private ArrayList<Profile> profiles;
    private Context mContext;


    public ProfilesListAdapter(ArrayList<Profile> profiles,Context mContext){
        this.profiles = profiles;
        this.mContext = mContext;

    }

    @NonNull
    @Override
    public ProfilesViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.profile_cell_layout,null);
        ProfilesViewHolder profilesViewHolder = new ProfilesViewHolder(view);
        return profilesViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ProfilesViewHolder profilesViewHolder, int position) {
        profilesViewHolder.tv_name.setText(profiles.get(position).getName());
        profilesViewHolder.tv_age.setText(profiles.get(position).getAge() + "");

        Glide.with(mContext).load(profiles.get(position).getImgurl())
                .into(profilesViewHolder.iv_profilePicture);
    }

    @Override
    public int getItemCount() {
        return profiles.size();
    }
}
