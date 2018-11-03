package com.example.biolizard.rollingstoneandroid.Adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.biolizard.rollingstoneandroid.Model.Objects.Message;
import com.example.biolizard.rollingstoneandroid.R;
import com.example.biolizard.rollingstoneandroid.ViewHolders.MessageViewHolder;

import java.util.ArrayList;

public class MessagesListAdapter extends RecyclerView.Adapter<MessageViewHolder> {
    public ArrayList<Message> messages;
    public MessagesListAdapter(ArrayList<Message> messages){
        this.messages = messages;

    }

    @NonNull
    @Override
    public MessageViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.message_cell_layout,null);
        MessageViewHolder messageViewHolder = new MessageViewHolder(view);
        return messageViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MessageViewHolder messageViewHolder, int position) {
        messageViewHolder.tv_messageName.setText(messages.get(position).getOriginal());
    }

    @Override
    public int getItemCount() {
        return messages.size();
    }
}
