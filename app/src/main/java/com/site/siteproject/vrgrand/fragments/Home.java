package com.site.siteproject.vrgrand.fragments;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;


import com.site.siteproject.FullScreenViewPager;
import com.site.siteproject.R;
import com.site.siteproject.utils.ExtendedViewPager;
import com.site.siteproject.utils.GlobalClass;

import java.util.ArrayList;

/**
 * Created by Prakash on 11/11/2017.
 */

public class Home extends Fragment {

    ArrayList<String> views;
    RadioGroup radioGroup;
    ExtendedViewPager viewPager;
    TextView elevation;
    GlobalClass global;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.home_ailis, container, false);
        global=(GlobalClass)getActivity().getApplicationContext();
        views=new ArrayList<>();

        views.add("VIEW -01");
        views.add("VIEW -02");
        views.add("VIEW -03");



        init(view);




        viewPager.setAdapter(new CustomPagerAdapter(getActivity()));



        return view;

    }


    void flatintialise() {

        RadioGroup.LayoutParams rprms;


        for (int i = 0; i < views.size(); i++) {
            RadioButton radioButton = new RadioButton(getActivity());
            radioButton.setText(views.get(i));
            radioButton.setTextSize(22);
            radioButton.setPadding(10, 10, 10, 10);
            radioButton.setChecked(i == 0);
            radioButton.setId(i);
            radioButton.setGravity(Gravity.CENTER);
            radioButton.setTextColor(getResources().getColorStateList(R.color.rbtn_textcolor_selector));
            radioButton.setButtonDrawable(null);
            radioButton.setBackgroundResource(R.drawable.ailis_radio_selector_circle);
            global.setTypeface(radioButton);
            rprms = new RadioGroup.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT, 1.0f);
            radioGroup.addView(radioButton, rprms);


        }


        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
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



                    radioGroup.check(position);










            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });



    }


    public class CustomPagerAdapter extends PagerAdapter {


        private Context mContext;

        ArrayList<Integer> drawables = new ArrayList<Integer>();

        public CustomPagerAdapter(Context context) {
            mContext = context;
            drawables.add(R.drawable.view_first);
            drawables.add(R.drawable.view_second);
            drawables.add(R.drawable.view_carparking);


        }

        @Override
        public Object instantiateItem(ViewGroup collection, final int position) {
            LayoutInflater inflater = LayoutInflater.from(mContext);
            ViewGroup layout = (ViewGroup) inflater.inflate(R.layout.viewpager_item, collection, false);

            ImageView imageView = (ImageView) layout.findViewById(R.id.flats);

            imageView.setImageResource(drawables.get(position));

            imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent i=new Intent(getActivity(), FullScreenViewPager.class);
                    i.putIntegerArrayListExtra("drawables",drawables);
                    i.putExtra("id", position);
                    startActivity(i);
                }
            });



            collection.addView(layout, LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);
            return layout;
        }

        @Override
        public void destroyItem(ViewGroup collection, int position, Object view) {
            collection.removeView((View) view);
        }

        @Override
        public int getCount() {
            return drawables.size();
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
        elevation= (TextView) view.findViewById(R.id.elevation);
        elevation.setVisibility(View.VISIBLE);
        radioGroup.setVisibility(View.VISIBLE);
        viewPager = (ExtendedViewPager)view. findViewById(R.id.viewpager);

        flatintialise();

    }

}
