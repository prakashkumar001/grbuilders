package com.site.siteproject.jaishree;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.site.siteproject.R;
import com.site.siteproject.ailis.adapter.about_us_adapter;

/**
 * Created by Prakash on 11/8/2017.
 */

    public class Splash extends AppCompatActivity  {
        final int SPLASH_DISPLAY_TIME = 2000;
    RelativeLayout layout;
    ImageView splashimg;


        @Override
        protected void onCreate(@Nullable Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.splash);
            layout=(RelativeLayout)findViewById(R.id.linear);
            splashimg=(ImageView) findViewById(R.id.splash_logo);

            layout.setBackgroundResource(R.drawable.jaishree_splash_bg);
            splashimg.setVisibility(View.GONE);



          new Handler().postDelayed(new Runnable() {
                public void run() {

                    com.site.siteproject.jaishree.Splash.this.finish();
                    overridePendingTransition(R.anim.fadeinact,
                            R.anim.fadeoutact);

                    Intent mainIntent = new Intent(
                            com.site.siteproject.jaishree.Splash.this,
                            com.site.siteproject.jaishree.fragments.ContactUS.class);

                    com.site.siteproject.jaishree.Splash.this.startActivity(mainIntent);



                }
            }, SPLASH_DISPLAY_TIME);
        }


    }


