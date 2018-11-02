package com.example.rollingstonelibrary.ProfilesList;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.rollingstonelibrary.R;

public class ProfileListAdapter extends RecyclerView.Adapter<ProfileViewHolder> {

    @NonNull
    @Override
    public ProfileViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.profile_cell_layout,null);
        ProfileViewHolder profileViewHolder = new ProfileViewHolder(view);
        return profileViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ProfileViewHolder profileViewHolder, int position) {
        profileViewHolder.tv_profileName.setText("posicion" + position);
    }

    @Override
    public int getItemCount() {
        return 5;
    }
}
