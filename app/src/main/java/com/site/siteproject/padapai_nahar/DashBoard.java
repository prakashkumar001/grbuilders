package com.site.siteproject.padapai_nahar;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import com.site.siteproject.R;
import com.site.siteproject.padapai_nahar.fragments.Home;

/**
 * Created by Prakash on 11/11/2017.
 */

public class DashBoard extends AppCompatActivity{
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.padapai_dashbaord);


        Home home=new Home();
        loadFragment(home);
    }


    public void loadFragment(Fragment fragments) {


        FragmentTransaction ft=getSupportFragmentManager().beginTransaction();
        ft.setCustomAnimations(R.anim.fadeinact,R.anim.fadeoutact);
        ft.replace(R.id.container, fragments, fragments.getClass().getSimpleName()).commit();

    }
}
