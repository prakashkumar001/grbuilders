package com.site.siteproject;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.site.siteproject.ailis.adapter.about_us_adapter;

/**
 * Created by Creative IT Works on 15-Dec-17.
 */

public class MainSplash extends AppCompatActivity {
    final int SPLASH_DISPLAY_TIME = 2000;



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.nahar_splash);




        new Handler().postDelayed(new Runnable() {
            public void run() {

                Intent mainIntent = new Intent(
                       MainSplash.this,
                        AboutUs.class);

                MainSplash.this.startActivity(mainIntent);

            }
        }, SPLASH_DISPLAY_TIME);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        ActivityCompat.finishAffinity(MainSplash.this);
        System.exit(0);
    }
}