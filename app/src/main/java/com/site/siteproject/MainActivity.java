package com.site.siteproject;

import android.app.Dialog;
import android.content.Intent;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {


    ImageView tiruvidanthai,ailis,jothi,jaishree,mathura;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tiruvidanthai=(ImageView) findViewById(R.id.thiruvidanthai);
        ailis=(ImageView) findViewById(R.id.ailis);
        //jothi=(ImageView) findViewById(R.id.jothi);
        //jaishree=(ImageView) findViewById(R.id.jaishree);
       // mathura=(ImageView) findViewById(R.id.mathura);


        ailis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(MainActivity.this, com.site.siteproject.vrgrand.Splash.class);
                startActivity(i);
                finish();
            }
        });

        tiruvidanthai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showInfoDialog("Coming Soon");
            }
        });


    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent i=new Intent(MainActivity.this, MainSplash.class);
        startActivity(i);
        ActivityCompat.finishAffinity(MainActivity.this);
    }

    public void showInfoDialog(String message) {

        // custom dialog
        final Dialog dialog = new Dialog(MainActivity.this, R.style.DialogSlideAnim);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.jaishree_spec_full_info);
        dialog.getWindow().setGravity(Gravity.CENTER);
        //dialog.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));

        DisplayMetrics metrics = getResources().getDisplayMetrics();
        int width = metrics.widthPixels;
        int height = metrics.heightPixels;
        dialog.show();
        dialog.getWindow().setLayout((8 * width) / 10, (8 * height) / 10);

        ImageView close=(ImageView)dialog.findViewById(R.id.close);
        TextView content=(TextView) dialog.findViewById(R.id.content);

        content.setText(message);

        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });


        dialog.show();


    }
}
