package com.example.biolizard.rollingstoneandroid.Activities;

import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.biolizard.rollingstoneandroid.Controller.MainActivityEvents;
import com.example.biolizard.rollingstoneandroid.Model.DataHolder;
import com.example.biolizard.rollingstoneandroid.R;
import com.example.rollingstonelibrary.Login.LoginFragment;
import com.example.rollingstonelibrary.Register.RegisterFragment;

public class MainActivity extends AppCompatActivity {
   public LoginFragment loginFragment;
  public RegisterFragment registerFragment;
    FragmentTransaction transaction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        loginFragment = (LoginFragment) getSupportFragmentManager().findFragmentById(R.id.fragment_login);
        registerFragment = (RegisterFragment) getSupportFragmentManager().findFragmentById(R.id.fragment_register);
        MainActivityEvents mainActivityEvents = new MainActivityEvents(this);


        DataHolder.instance.firebaseAdmin.setFirebaseAdminListener(mainActivityEvents);
        loginFragment.setListener(mainActivityEvents);
        registerFragment.setListener(mainActivityEvents);
        transaction = getSupportFragmentManager().beginTransaction();
        transaction.show(loginFragment);
        transaction.hide(registerFragment);
        transaction.commit();




    }
}
