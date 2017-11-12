package com.site.siteproject.ailis.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.site.siteproject.R;

import java.util.ArrayList;

/**
 * Created by Prakash on 11/11/2017.
 */

public class Home extends Fragment {

    ArrayList<String> flatnames;
    RadioGroup radioGroup;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.home_ailis, container, false);
        flatnames=new ArrayList<>();
        flatnames.add("FLAT -1A");
        flatnames.add("FLAT -1B");
        flatnames.add("FLAT -1G");
        flatnames.add("FLAT -2A , 3A & 4A");
        flatnames.add("FLAT -2B , 3B & 4B");



        init(view);






        return view;

    }

    void flatintialise()
    {

        RadioGroup.LayoutParams rprms;

        for(int i = 0; i< flatnames.size(); i++){
            RadioButton radioButton = new RadioButton(getActivity());
            radioButton.setText(flatnames.get(i));
            radioButton.setTextSize(16);
            radioButton.setPadding(10,10,10,10);
            radioButton.setChecked(i==0);
            radioButton.setId(i);
            radioButton.setGravity(Gravity.CENTER);
            radioButton.setTextColor(getResources().getColorStateList(R.color.rbtn_textcolor_selector));
            radioButton.setButtonDrawable(null);
            radioButton.setBackgroundResource(R.drawable.ailis_radio_selector_circle);
            rprms= new RadioGroup.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT,1.0f);
            radioGroup.addView(radioButton, rprms);



        }
    }


    void init(View view)
    {
        radioGroup= (RadioGroup) view.findViewById(R.id.rg_header);
        flatintialise();

    }

}
