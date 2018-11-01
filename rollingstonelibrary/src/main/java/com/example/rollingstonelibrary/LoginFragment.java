package com.example.rollingstonelibrary;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;


public class LoginFragment extends Fragment {
    public LoginFragment() {
    }

    public EditText et_email;
    public EditText et_password;
    public Button btn_login;
    public Button btn_register;
    public LoginFragmentEvents events;
    public LoginFragmentListener loginFragmentListener;

    public void setListener(LoginFragmentListener loginFragmentListener){
        this.loginFragmentListener = loginFragmentListener;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.login_fragment_layout, container, false);
        findViewsFromlayout(view);
        events = new LoginFragmentEvents(this);
        setListenersForButtons(btn_login,btn_register,events);
        return view;
    }

    public void findViewsFromlayout(View view) {
        et_email = view.findViewById(R.id.editText_email);
        et_password = view.findViewById(R.id.editText_password);
        btn_login = (Button) view.findViewById(R.id.button_login);
        btn_register =(Button) view.findViewById(R.id.button_register);
    }
    public void setListenersForButtons(Button btn_login,Button btn_register,LoginFragmentEvents events){
        btn_login.setOnClickListener(events);
        btn_register.setOnClickListener(events);
    }

}
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
