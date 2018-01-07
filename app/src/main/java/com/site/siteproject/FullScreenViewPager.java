package com.site.siteproject;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.site.siteproject.utils.ExtendedViewPager;

import java.util.ArrayList;

/**
 * Created by Prakash on 1/7/2018.
 */

public class FullScreenViewPager extends AppCompatActivity{
    ExtendedViewPager viewPager;
    int position=0;
    ArrayList<Integer> drawables;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent p = getIntent();
        position = p.getExtras().getInt("id");
        drawables=p.getIntegerArrayListExtra("drawables");

        setContentView(R.layout.full_screen_viewpager);
        viewPager=(ExtendedViewPager)findViewById(R.id.viewpager);

        viewPager.setAdapter(new FullImagePagerAdapter(FullScreenViewPager.this,drawables));



        // Show images following the position
        viewPager.setCurrentItem(position);




    }


}
