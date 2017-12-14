package com.site.siteproject;

import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.site.siteproject.thiruvidanthai.Splash;

public class MainActivity extends AppCompatActivity {


    ImageView tiruvidanthai,ailis,jothi,jaishree,mathura;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tiruvidanthai=(ImageView) findViewById(R.id.thiruvidanthai);
        ailis=(ImageView) findViewById(R.id.ailis);
        jothi=(ImageView) findViewById(R.id.jothi);
        jaishree=(ImageView) findViewById(R.id.jaishree);
        mathura=(ImageView) findViewById(R.id.mathura);

        tiruvidanthai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i=new Intent(MainActivity.this, Splash.class);
                startActivity(i);
                finish();

            }
        });

        ailis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(MainActivity.this, com.site.siteproject.ailis.Splash.class);
                startActivity(i);
                finish();
            }
        });

        jothi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(MainActivity.this, com.site.siteproject.jaishree.Splash.class);
                startActivity(i);
                finish();
            }
        });

        jaishree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(MainActivity.this, com.site.siteproject.jaishree.Splash.class);
                startActivity(i);
                finish();
            }
        });


        mathura.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(MainActivity.this, com.site.siteproject.mathura.Splash.class);
                startActivity(i);
                finish();
            }
        });

    }
}
