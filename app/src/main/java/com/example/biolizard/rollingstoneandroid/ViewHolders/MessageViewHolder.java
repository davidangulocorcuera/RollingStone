package com.example.biolizard.rollingstoneandroid.ViewHolders;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.biolizard.rollingstoneandroid.R;

public class MessageViewHolder extends  RecyclerView.ViewHolder{
    public TextView tv_messageName;
    public MessageViewHolder(@NonNull View itemView) {
        super(itemView);
        tv_messageName = itemView.findViewById(R.id.textView_messageName);
    }

}
