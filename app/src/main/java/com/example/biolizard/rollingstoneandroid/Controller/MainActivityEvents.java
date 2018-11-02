package com.example.biolizard.rollingstoneandroid.Controller;

import android.content.Intent;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;

import com.example.biolizard.rollingstoneandroid.Activities.CompleteProfileActivity;
import com.example.biolizard.rollingstoneandroid.Activities.MainActivity;
import com.example.biolizard.rollingstoneandroid.Activities.PrincipalActivity;
import com.example.biolizard.rollingstoneandroid.Model.DataHolder;
import com.example.biolizard.rollingstoneandroid.Model.FirebaseAdminListener;
import com.example.rollingstonelibrary.Login.LoginFragmentListener;
import com.example.rollingstonelibrary.Register.RegisterFragmentListener;
import com.google.firebase.database.DataSnapshot;

public class MainActivityEvents implements LoginFragmentListener,RegisterFragmentListener, FirebaseAdminListener {
  MainActivity mainActivity;
  public MainActivityEvents(MainActivity mainActivity){
      this.mainActivity = mainActivity;
  }


    @Override
    public void loginFragmentLoginButtonClicked(String str_user, String str_password) {
        DataHolder.instance.firebaseAdmin.loginUserWithEmailAndPassword(str_user,str_password,mainActivity);

    }

    @Override
    public void loginFragmentRegisterButtonClicked() {

       FragmentTransaction transaction = mainActivity.getSupportFragmentManager().beginTransaction();
        transaction.show(mainActivity.registerFragment);
        transaction.hide(mainActivity.loginFragment);
        transaction.commit();
    }


    @Override
    public void registerFragmentNextButtonClicked(String str_user, String str_password) {
        DataHolder.instance.firebaseAdmin.registerUserWithEmailAndPassword(str_user,str_password,mainActivity);

    }

    @Override
    public void registerFragmentBackButtonClicked() {
        FragmentTransaction transaction = mainActivity.getSupportFragmentManager().beginTransaction();
        transaction.show(mainActivity.loginFragment);
        transaction.hide(mainActivity.registerFragment);
        transaction.commit();

    }

    @Override
    public void firebaseAdmin_RegisterOK(boolean bl_ok) {

        Log.v("MAINACTIVITYEVENTS" , "resultado del registro" + bl_ok);
        if(bl_ok){
            DataHolder.instance.setProfileData(DataHolder.instance.profile);
            Intent intent = new Intent(mainActivity,CompleteProfileActivity.class);
            mainActivity.startActivity(intent);
            mainActivity.finish();

        }
        else{

        }
    }

    @Override
    public void firebaseAdmin_LoginOK(boolean bl_ok) {
        Log.v("MAINACTIVITYEVENTS" , "resultado del login" + bl_ok);
        if(bl_ok){
            DataHolder.instance.setProfileData(DataHolder.instance.profile);
            String email = DataHolder.instance.profile.getStr_email();
            Log.v("email " , email);
            Intent intent = new Intent(mainActivity,PrincipalActivity.class);
            mainActivity.startActivity(intent);
            mainActivity.finish();

        }
        else{

        }
    }

    @Override
    public void firebaseAdmin_BranchDownloaded(String str_branch, DataSnapshot dataSnapshot) {

    }
}
