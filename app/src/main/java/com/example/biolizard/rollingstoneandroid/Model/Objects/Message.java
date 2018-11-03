package com.example.biolizard.rollingstoneandroid.Model.Objects;

import com.google.firebase.database.IgnoreExtraProperties;

@IgnoreExtraProperties
public class Message {
    public String getOriginal() {
        return original;
    }

    public void setOriginal(String original) {
        this.original = original;
    }

    private String original;
    public Message(){

    }
    public Message(String original){
        this.original = original;
    }
}
