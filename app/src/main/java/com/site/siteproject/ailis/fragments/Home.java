package com.site.siteproject.ailis.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;


import com.site.siteproject.R;
import com.site.siteproject.utils.TouchImageView;

import java.util.ArrayList;

/**
 * Created by Prakash on 11/11/2017.
 */

public class Home extends Fragment {

    ArrayList<String> floor;
    ArrayList<String> views;
    RadioGroup radioGroup,radioGroup2;
    ViewPager viewPager;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.home_ailis, container, false);
        floor=new ArrayList<>();
        views=new ArrayList<>();
        floor.add("GROUND FLOOR");
        floor.add("FIRST FLOOR");
        floor.add("SECOND FLOOR");

        views.add("VIEW -01");
        views.add("VIEW -02");



        init(view);




        viewPager.setAdapter(new CustomPagerAdapter(getActivity()));


        return view;

    }


    void flatintialise() {

        RadioGroup.LayoutParams rprms;

        for (int i = 2; i < floor.size()+2; i++) {
            RadioButton  radioButton = new RadioButton(getActivity());
            radioButton.setText(floor.get(i-2));
            radioButton.setTextSize(16);
            radioButton.setPadding(10, 10, 10, 10);
            radioButton.setId(i);
            radioButton.setGravity(Gravity.CENTER);
            radioButton.setTextColor(getResources().getColorStateList(R.color.rbtn_textcolor_selector));
            radioButton.setButtonDrawable(null);
            radioButton.setBackgroundResource(R.drawable.ailis_radio_selector_circle);
            rprms = new RadioGroup.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT, 1.0f);
            radioGroup2.addView(radioButton, rprms);


        }

        for (int i = 0; i < views.size(); i++) {
            RadioButton radioButton = new RadioButton(getActivity());
            radioButton.setText(views.get(i));
            radioButton.setTextSize(16);
            radioButton.setPadding(10, 10, 10, 10);
            radioButton.setChecked(i == 0);
            radioButton.setId(i);
            radioButton.setGravity(Gravity.CENTER);
            radioButton.setTextColor(getResources().getColorStateList(R.color.rbtn_textcolor_selector));
            radioButton.setButtonDrawable(null);
            radioButton.setBackgroundResource(R.drawable.ailis_radio_selector_circle);
            rprms = new RadioGroup.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT, 1.0f);
            radioGroup.addView(radioButton, rprms);


        }


        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, @IdRes int i) {

                viewPager.setCurrentItem(i);
            }
        });

        radioGroup2.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, @IdRes int i) {
                viewPager.setCurrentItem(i);
            }
        });

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {



               /* if(position>3)
                {
                    radioGroup2.check(position);
                }else
                {
                    radioGroup.check(position);

                }*/


                if(position<=1)
                {
                    radioGroup.check(position);

                 /*   for(int i=2;i<floor.size()+2;i++)
                    {
                        RadioButton radioButton=(RadioButton)radioGroup2.findViewById(i);
                        radioButton.setChecked(false);
                    }

*/


                }else if(position>1)
                {
                    radioGroup2.check(position);

                   /* for(int i=0;i<views.size();i++)
                    {
                        RadioButton radioButton=(RadioButton)radioGroup.findViewById(i);
                        radioButton.setChecked(false);
                    }*/


                }








            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        viewPager.setCurrentItem(0);


    }


    public class CustomPagerAdapter extends PagerAdapter {


        private Context mContext;
        int drawables[] = new int[]{R.drawable.ailis_view1, R.drawable.ailis_view2, R.drawable.ailis_groundfloor, R.drawable.ailis_firstfloor,
                R.drawable.ailis_secondfloor
        };


        public CustomPagerAdapter(Context context) {
            mContext = context;
        }

        @Override
        public Object instantiateItem(ViewGroup collection, int position) {
            LayoutInflater inflater = LayoutInflater.from(mContext);
            ViewGroup layout = (ViewGroup) inflater.inflate(R.layout.viewpager_item, collection, false);

            TouchImageView imageView = (TouchImageView) layout.findViewById(R.id.flats);

            imageView.setImageResource(drawables[position]);




            collection.addView(layout);
            return layout;
        }

        @Override
        public void destroyItem(ViewGroup collection, int position, Object view) {
            collection.removeView((View) view);
        }

        @Override
        public int getCount() {
            return drawables.length;
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }

        /*@Override
        public CharSequence getPageTitle(int position) {

            radioGroup.check(position);

            return String.valueOf(position);
        }
*/

    }


    void init(View view)
    {
        radioGroup= (RadioGroup) view.findViewById(R.id.view);
        radioGroup2= (RadioGroup) view.findViewById(R.id.floor);
        viewPager = (ViewPager)view. findViewById(R.id.viewpager);

        flatintialise();

    }

}
