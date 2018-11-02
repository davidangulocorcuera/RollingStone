package com.example.rollingstonelibrary.ProfilesList;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.rollingstonelibrary.Model.Profile;
import com.example.rollingstonelibrary.R;

import java.util.HashMap;

public class ProfilesListFragment extends Fragment {
   public RecyclerView recyclerView;
    public  ProfilesListFragment(){

    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.profiles_list_fragment_layout, container, false);
        recyclerView = view.findViewById(R.id.recyclerView_profiles);
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(),3));

        return  view;
    }
    /*public void setAdapter(RecyclerView.Adapter<RecyclerView.ViewHolder> adapter){
        recyclerView.setAdapter(adapter);
    }*/
}
