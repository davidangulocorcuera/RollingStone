package com.example.biolizard.rollingstoneandroid.Model.Firebase;

import com.google.firebase.database.DataSnapshot;

public interface FirebaseAdminListener {
    public void firebaseAdmin_RegisterOK(boolean bl_ok);
    public void firebaseAdmin_LoginOK(boolean bl_ok);
    public void firebaseAdmin_BranchDownloaded(String str_branch,DataSnapshot dataSnapshot);
}
