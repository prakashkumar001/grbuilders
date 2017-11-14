package com.site.siteproject.jaishree.fragments;

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
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.site.siteproject.R;
import com.site.siteproject.jaishree.DashBoard;

import java.util.ArrayList;

/**
 * Created by Prakash on 11/11/2017.
 */

public class Home extends Fragment {

    ArrayList<String> flatnames;
    RadioGroup radioGroup;
    ViewPager viewPager;
    RadioButton radioButton;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.home_jaishree, container, false);
        flatnames=new ArrayList<>();
        flatnames.add("FLAT -1A");
        flatnames.add("FLAT -1B");
        flatnames.add("FLAT -1G");
        flatnames.add("FLAT -2A , 3A & 4A");
        flatnames.add("FLAT -2B , 3B & 4B");

        init(view);




        viewPager.setAdapter(new CustomPagerAdapter(getActivity()));


        return view;

    }

    void flatintialise() {

        RadioGroup.LayoutParams rprms;

        for (int i = 0; i < flatnames.size(); i++) {
            radioButton = new RadioButton(getActivity());
            radioButton.setText(flatnames.get(i));
            radioButton.setTextSize(16);
            radioButton.setPadding(10, 10, 10, 10);
            radioButton.setChecked(i == 0);
            radioButton.setId(i);
            radioButton.setGravity(Gravity.CENTER);
            radioButton.setTextColor(getResources().getColorStateList(R.color.rbtn_textcolor_selector));
            radioButton.setButtonDrawable(null);
            radioButton.setBackgroundResource(R.drawable.jaishree_radio);
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



                radioGroup.check(position);


            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        viewPager.setCurrentItem(0);


    }
    public class CustomPagerAdapter extends PagerAdapter {

        private Context mContext;
        int drawables[] = new int[]{R.drawable.flat1a_ailis, R.drawable.flat1a_ailis, R.drawable.flat1a_ailis, R.drawable.flat1a_ailis, R.drawable.flat1a_ailis};

        public CustomPagerAdapter(Context context) {
            mContext = context;
        }

        @Override
        public Object instantiateItem(ViewGroup collection, int position) {
            LayoutInflater inflater = LayoutInflater.from(mContext);
            ViewGroup layout = (ViewGroup) inflater.inflate(R.layout.viewpager_item, collection, false);

            ImageView imageView = (ImageView) layout.findViewById(R.id.flats);
            imageView.setBackgroundResource(drawables[position]);
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
        radioGroup= (RadioGroup) view.findViewById(R.id.rg_header);
        viewPager = (ViewPager)view. findViewById(R.id.viewpager);

        flatintialise();

    }

}
