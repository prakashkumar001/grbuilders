package com.site.siteproject.mathura.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.site.siteproject.R;

/**
 * Created by Creative IT Works on 15-Nov-17.
 */

public class ContactUS extends Fragment {
    EditText name,email,phone_number;
    Button submit;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.jaishree_contactus, container, false);

        name=(EditText)view.findViewById(R.id.name);
        email=(EditText)view.findViewById(R.id.email);
        phone_number=(EditText)view.findViewById(R.id.phone);
        submit=(Button)view.findViewById(R.id.submit);

        submit.setBackgroundResource(R.drawable.mathur_interestbg);

        return view;

    }

    }
