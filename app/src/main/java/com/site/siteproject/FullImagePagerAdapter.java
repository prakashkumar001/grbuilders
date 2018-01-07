package com.site.siteproject;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.site.siteproject.utils.*;
import com.site.siteproject.utils.TouchImageView;

import java.util.ArrayList;

public class FullImagePagerAdapter extends PagerAdapter {


        private Context mContext;
       ArrayList<Integer> drawables=new ArrayList<>();
       

        public FullImagePagerAdapter(Context context,ArrayList<Integer> drawables) {
            mContext = context;
            this.drawables=drawables;
        }

        @Override
        public Object instantiateItem(ViewGroup collection, int position) {
            LayoutInflater inflater = LayoutInflater.from(mContext);
            ViewGroup layout = (ViewGroup) inflater.inflate(R.layout.full_screen, collection, false);

            com.site.siteproject.utils.TouchImageView imageView = (com.site.siteproject.utils.TouchImageView) layout.findViewById(R.id.fullscreen);

            imageView.setImageResource(drawables.get(position));


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



    }