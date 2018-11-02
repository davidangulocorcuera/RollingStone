package com.example.biolizard.rollingstoneandroid.Model;

public class DataHolder {
    public static  DataHolder instance = new DataHolder();
    public FirebaseAdmin firebaseAdmin;
    public  Profile profile;


    public DataHolder() {
        firebaseAdmin = new FirebaseAdmin();
        profile = new Profile();
    }

    public void setProfileData(Profile profile){
        profile.setStr_email(firebaseAdmin.user.getEmail().toString());
    }
}
