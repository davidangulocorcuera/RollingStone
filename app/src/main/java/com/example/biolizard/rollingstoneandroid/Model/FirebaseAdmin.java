package com.example.biolizard.rollingstoneandroid.Model;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.util.Log;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class FirebaseAdmin {
    private FirebaseAuth mAuth;
    public FirebaseUser user;
    public FirebaseAdminListener firebaseAdminListener;

     public FirebaseAdmin(){
         mAuth = FirebaseAuth.getInstance();
     }
     public void setFirebaseAdminListener(FirebaseAdminListener firebaseAdminListener){
         this.firebaseAdminListener = firebaseAdminListener;
     }

    public void setmAuth(FirebaseAuth mAuth) {
        this.mAuth = mAuth;
    }

    public void registerUserWithEmailAndPassword(String email,String password,Activity activity){
        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(activity, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        Log.d("FirebaseAdmin", "createUserWithEmail:onComplete:" + task.isSuccessful());
                        if (task.isSuccessful()) {
                            user = FirebaseAuth.getInstance().getCurrentUser();
                            firebaseAdminListener.firebaseAdmin_RegisterOK(true);
                        }
                        else{
                            firebaseAdminListener.firebaseAdmin_RegisterOK(false);
                        }

                    }
                });
    }

    public void loginUserWithEmailAndPassword(String email,String password,Activity activity){
        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(activity, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        Log.d("FirebaseAdmin", "createUserWithEmail:onComplete:" + task.isSuccessful());
                        if (task.isSuccessful()) {
                            user = FirebaseAuth.getInstance().getCurrentUser();
                            firebaseAdminListener.firebaseAdmin_LoginOK(true);
                        }
                        else{
                            firebaseAdminListener.firebaseAdmin_LoginOK(false);
                        }

                    }
                });
    }
}
