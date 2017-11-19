package com.site.siteproject.mathura;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.LinearLayout;

import com.site.siteproject.R;
import com.site.siteproject.mathura.fragments.ContactUS;
import com.site.siteproject.mathura.fragments.Specification;


/**
 * Created by Prakash on 11/11/2017.
 */

public class DashBoard extends AppCompatActivity{
    LinearLayout specification,viewPlans,contactus;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mathura_dashboard);
        specification=(LinearLayout) findViewById(R.id.specification);
        viewPlans=(LinearLayout) findViewById(R.id.viewPlans);
        contactus=(LinearLayout) findViewById(R.id.contactus);
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

        contactus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ContactUS contactUS=new ContactUS();
                loadFragment(contactUS);
            }
        });
    }


    public void loadFragment(Fragment fragments) {


        FragmentTransaction ft=getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.container, fragments, fragments.getClass().getSimpleName()).commit();

    }
    public void intialFragment()
    {
        com.site.siteproject.mathura.fragments.Home home=new com.site.siteproject.mathura.fragments.Home();
        FragmentTransaction ft=getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.container, home, home.getClass().getSimpleName()).commit();
    }



}