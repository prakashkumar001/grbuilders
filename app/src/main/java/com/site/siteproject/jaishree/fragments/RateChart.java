package com.site.siteproject.jaishree.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.site.siteproject.R;
import com.site.siteproject.utils.TouchImageView;

public class RateChart extends Fragment {
    TouchImageView rate_img;
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.rate_chart, container, false);
        rate_img=(TouchImageView)view.findViewById(R.id.rate_img);
        rate_img.setImageResource(R.drawable.jaishree_rate);
        
        
        return view;

    }
}
