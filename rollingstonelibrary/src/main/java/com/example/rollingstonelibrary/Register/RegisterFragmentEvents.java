package com.example.rollingstonelibrary.Register;

import android.view.View;

class RegisterFragmentEvents implements View.OnClickListener{
    private RegisterFragment registerFragment;
    public RegisterFragmentEvents(RegisterFragment registerFragment){
        this.registerFragment = registerFragment;
    }
    @Override
    public void onClick(View v) {
        if(v.getId() == this.registerFragment.btn_next.getId()){
            this.registerFragment.registerFragmentListener.registerFragmentNextButtonClicked(this.registerFragment.et_email.getText().toString(),this.registerFragment.et_password.getText().toString());
        }
        else if(v.getId() == this.registerFragment.btn_back.getId()){
            this.registerFragment.registerFragmentListener.registerFragmentBackButtonClicked();
        }
    }
}
