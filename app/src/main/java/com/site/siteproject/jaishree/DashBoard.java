package com.site.siteproject.jaishree;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.site.siteproject.R;
import com.site.siteproject.jaishree.fragments.Home;
import com.site.siteproject.jaishree.fragments.Specification;

import java.util.ArrayList;

/**
 * Created by Prakash on 11/11/2017.
 */

public class DashBoard extends AppCompatActivity{
    ArrayList<String> flatnames;
    RadioGroup radioGroup;
    ViewPager viewPager;
    RadioButton radioButton;
    LinearLayout specification,viewPlans;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.jaishree_dashboard);
        specification=(LinearLayout) findViewById(R.id.specification);
        viewPlans=(LinearLayout) findViewById(R.id.viewPlans);
       intialFragment();

        specification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Specification specification=new Specification();
                loadFragment(specification);
            }
        });

        viewPlans.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intialFragment();
            }
        });


    }


    public void loadFragment(Fragment fragments) {


        FragmentTransaction ft=getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.container, fragments, fragments.getClass().getSimpleName()).commit();

    }
    public void intialFragment()
    {
        Home home=new Home();
        FragmentTransaction ft=getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.container, home, home.getClass().getSimpleName()).commit();
    }



    }

