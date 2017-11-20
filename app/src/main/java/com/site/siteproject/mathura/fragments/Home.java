package com.site.siteproject.mathura.fragments;

import android.content.Context;
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
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

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

        View view = inflater.inflate(R.layout.home_mathura, container, false);
        floor=new ArrayList<>();
        views=new ArrayList<>();
        views.add("VIEW -01");

        floor.add("FLAT -A");
        floor.add("FLAT -B");
        floor.add("FLAT -C");
        floor.add("FLAT -D");



        init(view);




        viewPager.setAdapter(new Home.CustomPagerAdapter(getActivity()));



        return view;

    }



    void flatintialise() {

        RadioGroup.LayoutParams rprms;

        for (int i = 1; i < floor.size()+1; i++) {
            RadioButton  radioButton = new RadioButton(getActivity());
            radioButton.setText(floor.get(i-1));
            radioButton.setTextSize(16);
            radioButton.setPadding(10, 10, 10, 10);
            radioButton.setId(i);
            radioButton.setGravity(Gravity.CENTER);
            radioButton.setTextColor(getResources().getColorStateList(R.color.rbtn_textcolor_selector));
            radioButton.setButtonDrawable(null);
            radioButton.setBackgroundResource(R.drawable.mahtura_radio);
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
            radioButton.setBackgroundResource(R.drawable.mahtura_radio);
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

                if(position<=0)
                {
                    radioGroup.check(position);

                 /*   for(int i=1;i<floor.size()+1;i++)
                    {
                        RadioButton radioButton=(RadioButton)radioGroup2.findViewById(i);
                        radioButton.setChecked(false);
                    }

*/


                }else if(position>0)
                {
                    radioGroup2.check(position);

                  /*  for(int i=0;i<views.size();i++)
                    {
                        RadioButton radioButton=(RadioButton)radioGroup.findViewById(i);
                        radioButton.setChecked(false);
                    }*/


                }


               /* if(position>3)
                {
                    radioGroup2.check(position);
                }else
                {
                    radioGroup.check(position);

                }*/

              /*  if(position==0)
                {
                    radioGroup.check(position);


                }else if(position==1)
                {
                    radioGroup2.check(position);


                }else if(position==2)
                {
                    radioGroup2.check(position);


                }else if(position==3)
                {
                    radioGroup2.check(position);


                }else if(position==4)
                {
                    radioGroup2.check(position);

                }
*/







            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        viewPager.setCurrentItem(0);


    }

    public class CustomPagerAdapter extends PagerAdapter {

        private Context mContext;
        int drawables[] = new int[]{R.drawable.mathura_floor1,R.drawable.mathura_floor1, R.drawable.mathura_floor2, R.drawable.mathura_floor3, R.drawable.mathura_floor4
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
        radioGroup= (RadioGroup) view.findViewById(R.id.views);
        radioGroup2= (RadioGroup) view.findViewById(R.id.floors);
        viewPager = (ViewPager)view. findViewById(R.id.viewpager);

        flatintialise();

    }

}
