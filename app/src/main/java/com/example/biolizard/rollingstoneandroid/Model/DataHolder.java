package com.example.biolizard.rollingstoneandroid.Model;

import com.example.biolizard.rollingstoneandroid.Model.Firebase.FirebaseAdmin;
import com.example.biolizard.rollingstoneandroid.Model.Objects.Profile;

public class DataHolder {
    public static  DataHolder instance = new DataHolder();
    public FirebaseAdmin firebaseAdmin;
    public Profile profile;


    public DataHolder() {
        firebaseAdmin = new FirebaseAdmin();
        profile = new Profile();
    }


}
