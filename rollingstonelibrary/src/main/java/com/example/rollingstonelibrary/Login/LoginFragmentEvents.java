package com.example.rollingstonelibrary.Login;

import android.view.View;

class LoginFragmentEvents implements  View.OnClickListener {
   private LoginFragment loginFragment;
    public LoginFragmentEvents(LoginFragment loginFragment){
        this.loginFragment = loginFragment;
    }
    @Override
    public void onClick(View v) {

   if(v.getId() == this.loginFragment.btn_login.getId()){
       this.loginFragment.loginFragmentListener.loginFragmentLoginButtonClicked(this.loginFragment.et_email.getText().toString(),this.loginFragment.et_password.getText().toString());
       }
       else if(v.getId() == this.loginFragment.btn_register.getId()){
       this.loginFragment.loginFragmentListener.loginFragmentRegisterButtonClicked();
   }
    }
}
