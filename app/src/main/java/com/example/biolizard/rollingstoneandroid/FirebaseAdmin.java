package com.example.biolizard.rollingstoneandroid;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.util.Log;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class FirebaseAdmin {
    private FirebaseAuth mAuth;
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
                            firebaseAdminListener.firebaseAdmin_RegisterOK(true);
                        }
                        else{
                            firebaseAdminListener.firebaseAdmin_RegisterOK(false);
                        }

                    }
                });
    }
}
