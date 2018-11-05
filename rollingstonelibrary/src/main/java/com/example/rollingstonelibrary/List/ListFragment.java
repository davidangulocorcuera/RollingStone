package com.example.rollingstonelibrary.List;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.rollingstonelibrary.R;

public class ListFragment extends Fragment {
   public RecyclerView recyclerView;
   private static ListFragment instance;
    public static ListFragment getInstance() {
        if(instance == null) instance = new ListFragment();
        return instance;
    }


    public ListFragment(){

    }


    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.messages_list_fragment_layout, container, false);
        recyclerView = view.findViewById(R.id.recyclerView_messages);
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(),3));

        return  view;
    }
    /*public void setAdapter(RecyclerView.Adapter<RecyclerView.ViewHolder> adapter){
        recyclerView.setAdapter(adapter);
    }*/
}
