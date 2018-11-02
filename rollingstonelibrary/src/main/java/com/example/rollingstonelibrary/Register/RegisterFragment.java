package com.example.rollingstonelibrary.Register;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.rollingstonelibrary.R;

public class RegisterFragment extends Fragment {
    public EditText et_email;
    public EditText et_password;
    public Button btn_next;
    public Button btn_back;
    private RegisterFragmentEvents events;
    public RegisterFragmentListener registerFragmentListener;
    public RegisterFragment(){

    }
    public void setListener(RegisterFragmentListener registerFragmentListener){
        this.registerFragmentListener = registerFragmentListener;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.register_fragment_layout, container, false);
        findViewsFromlayout(view);
        events = new RegisterFragmentEvents(this);
        setListenersForButtons(btn_next,btn_back,events);
        return  view;
    }
    public void findViewsFromlayout(View view) {
        et_email = view.findViewById(R.id.editText_email);
        et_password = view.findViewById(R.id.editText_password);
        btn_next = view.findViewById(R.id.button_next);
        btn_back = view.findViewById(R.id.button_back);
    }
    public void setListenersForButtons(Button btn_next,Button btn_back,RegisterFragmentEvents events){
        btn_next.setOnClickListener(events);
        btn_back.setOnClickListener(events);
    }
}
