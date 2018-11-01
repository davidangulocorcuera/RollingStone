package com.example.biolizard.rollingstoneandroid;

import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.transition.Transition;
import android.util.Log;
import android.widget.Toast;

import com.example.rollingstonelibrary.LoginFragment;
import com.example.rollingstonelibrary.LoginFragmentListener;
import com.example.rollingstonelibrary.RegisterFragment;
import com.example.rollingstonelibrary.RegisterFragmentListener;

public class MainActivity extends AppCompatActivity {
    LoginFragment loginFragment;
    RegisterFragment registerFragment;
    FragmentTransaction transaction;
    FirebaseAdmin firebaseAdmin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        loginFragment = (LoginFragment) getSupportFragmentManager().findFragmentById(R.id.fragment_login);
        registerFragment = (RegisterFragment) getSupportFragmentManager().findFragmentById(R.id.fragment_register);
        MainActivityEvents mainActivityEvents = new MainActivityEvents(this);
        firebaseAdmin = new FirebaseAdmin();

        firebaseAdmin.setFirebaseAdminListener(mainActivityEvents);
        loginFragment.setListener(mainActivityEvents);
        registerFragment.setListener(mainActivityEvents);

        transaction = getSupportFragmentManager().beginTransaction();
        transaction.show(loginFragment);
        transaction.hide(registerFragment);
        transaction.commit();




    }
}
  class MainActivityEvents implements LoginFragmentListener,RegisterFragmentListener, FirebaseAdminListener {
    MainActivity mainActivity;
    public MainActivityEvents(MainActivity mainActivity){
        this.mainActivity = mainActivity;
    }


      @Override
      public void loginFragmentLoginButtonClicked(String str_user, String str_password) {

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
         mainActivity.firebaseAdmin.registerUserWithEmailAndPassword(str_user,str_password,mainActivity);

      }

      @Override
      public void registerFragmentBackRegisterClicked() {
          FragmentTransaction transaction = mainActivity.getSupportFragmentManager().beginTransaction();
          transaction.show(mainActivity.loginFragment);
          transaction.hide(mainActivity.registerFragment);
          transaction.commit();

      }

      @Override
      public void firebaseAdmin_RegisterOK(boolean bl_ok) {
          Log.v("MAINACTIVITYEVENTS" , "resultado del registro" + bl_ok);
      }
  }
