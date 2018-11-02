package com.example.rollingstonelibrary.ProfilesList;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.rollingstonelibrary.R;

class ProfileViewHolder extends  RecyclerView.ViewHolder{
    public TextView tv_profileName;
    public ProfileViewHolder(@NonNull View itemView) {
        super(itemView);
        tv_profileName = itemView.findViewById(R.id.textView_profileName);
    }
}
