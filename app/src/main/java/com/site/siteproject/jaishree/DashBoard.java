package com.site.siteproject.jaishree;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.site.siteproject.MainActivity;
import com.site.siteproject.R;
import com.site.siteproject.jaishree.fragments.ContactUS;
import com.site.siteproject.jaishree.fragments.Home;
import com.site.siteproject.jaishree.fragments.Specification;

import java.util.ArrayList;

/**
 * Created by Prakash on 11/11/2017.
 */

public class DashBoard extends AppCompatActivity{

    LinearLayout specification,viewPlans,jaishree_contactus,location;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.jaishree_dashboard);
        specification=(LinearLayout) findViewById(R.id.specification);
        viewPlans=(LinearLayout) findViewById(R.id.viewPlans);
        jaishree_contactus=(LinearLayout) findViewById(R.id.jaishree_contactus);
        location= (LinearLayout) findViewById(R.id.location);
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

        jaishree_contactus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               /* ContactUS contactUS=new ContactUS();
                loadFragment(contactUS);*/
            }
        });

        location.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showInfoDialog();
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


    public void showInfoDialog() {

        // custom dialog
        final Dialog dialog = new Dialog(DashBoard.this, R.style.DialogSlideAnim);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.map);
        dialog.getWindow().setGravity(Gravity.CENTER);
        //dialog.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));

        DisplayMetrics metrics = getResources().getDisplayMetrics();
        int width = metrics.widthPixels;
        int height = metrics.heightPixels;
        dialog.show();
        dialog.getWindow().setLayout((8 * width) / 10, (8 * height) / 10);

        ImageView imageView=(ImageView)dialog.findViewById(R.id.image);
        ImageView close=(ImageView)dialog.findViewById(R.id.close);

        imageView.setImageResource(R.drawable.jaishree_map);


        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });


        dialog.show();


    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent i=new Intent(com.site.siteproject.jaishree.DashBoard.this, MainActivity.class);
        startActivity(i);
        ActivityCompat.finishAffinity(com.site.siteproject.jaishree.DashBoard.this);
    }

    }

