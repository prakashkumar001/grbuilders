package com.site.siteproject.padapai_nahar;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.site.siteproject.R;

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

            layout.setBackgroundResource(R.drawable.ailis_splash_bg);
            splashimg.setImageResource(R.drawable.ailis_splashimg);



          new Handler().postDelayed(new Runnable() {
                public void run() {

                    Splash.this.finish();
                    overridePendingTransition(R.anim.fadeinact,
                            R.anim.fadeoutact);

                   /* Intent mainIntent = new Intent(
                            Splash.this,
                            Login.class);

                    Splash.this.startActivity(mainIntent);
*/



                }
            }, SPLASH_DISPLAY_TIME);
        }


    }


