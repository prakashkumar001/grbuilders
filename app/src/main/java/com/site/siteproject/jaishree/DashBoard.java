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
import android.widget.TextView;

import com.site.siteproject.MainActivity;
import com.site.siteproject.NaharContact;
import com.site.siteproject.R;
import com.site.siteproject.jaishree.fragments.RateChart;
import com.site.siteproject.jaishree.fragments.ContactUS;
import com.site.siteproject.jaishree.fragments.Home;
import com.site.siteproject.jaishree.fragments.Specification;
import com.site.siteproject.jaishree.fragments.Location;
import com.site.siteproject.utils.GlobalClass;

import java.util.ArrayList;

/**
 * Created by Prakash on 11/11/2017.
 */

public class DashBoard extends AppCompatActivity{

    LinearLayout specification,viewPlans,jaishree_contactus,location,ratechart;
    TextView elevation_text,location_text,specification_text,rate_text,contact_text,floor_text;
GlobalClass global;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.jaishree_dashboard);
        global=(GlobalClass)getApplicationContext();

        specification=(LinearLayout) findViewById(R.id.specification);
        viewPlans=(LinearLayout) findViewById(R.id.viewPlans);
        jaishree_contactus=(LinearLayout) findViewById(R.id.contactus);
        location= (LinearLayout) findViewById(R.id.location);
        ratechart= (LinearLayout) findViewById(R.id.ratechart);

        elevation_text= (TextView) findViewById(R.id.elevation_text);
        location_text= (TextView) findViewById(R.id.location_text);
        specification_text= (TextView) findViewById(R.id.specification_text);
        rate_text= (TextView) findViewById(R.id.rate_text);
        contact_text= (TextView) findViewById(R.id.contact_text);
        floor_text= (TextView) findViewById(R.id.floor_text);

        global.setTypeface(elevation_text);
        global.setTypeface(location_text);
        global.setTypeface(specification_text);
        global.setTypeface(rate_text);
        global.setTypeface(contact_text);
        global.setTypeface(floor_text);


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
                NaharContact contactUS = new NaharContact();
                loadFragment(contactUS);
            }
        });

        location.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Location contactUS = new Location();
                loadFragment(contactUS);
                //showInfoDialog();
            }
        });
        ratechart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                RateChart contactUS = new RateChart();
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

