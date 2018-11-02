package com.example.rollingstonelibrary.ProfilesList;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.rollingstonelibrary.Model.Profile;
import com.example.rollingstonelibrary.R;

import java.util.HashMap;

public class ProfileListAdapter extends RecyclerView.Adapter<ProfileViewHolder> {
    private HashMap<Integer,Profile> hm_profiles;
    public ProfileListAdapter(HashMap<Integer,Profile> hm_profiles){
        this.hm_profiles = hm_profiles;

    }

    @NonNull
    @Override
    public ProfileViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.profile_cell_layout,null);
        ProfileViewHolder profileViewHolder = new ProfileViewHolder(view);
        return profileViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ProfileViewHolder profileViewHolder, int position) {
        profileViewHolder.tv_profileName.setText(hm_profiles.get(position).getStr_email());
    }

    @Override
    public int getItemCount() {
        return hm_profiles.size();
    }
}
