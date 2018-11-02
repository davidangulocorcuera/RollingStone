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
    RecyclerView recyclerView;
    HashMap<Integer,Profile> hm_profiles;
    public  ProfilesListFragment(){

    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.profiles_list_fragment_layout, container, false);
        recyclerView = view.findViewById(R.id.recyclerView_profiles);
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(),3));
        HashMap<Integer,Profile> hm_profiles = new HashMap<Integer, Profile>();
        Profile profile = new Profile();
        profile.setStr_email("asas@gmail.com");
        hm_profiles.put(0,profile);
        ProfileListAdapter profileListAdapter = new ProfileListAdapter(hm_profiles);
        recyclerView.setAdapter(profileListAdapter);
        return  view;
    }
}
