package com.site.siteproject;

/**
 * Created by v-62 on 20-Jan-17.
 */


        import android.content.Context;
        import android.content.Intent;
        import android.support.v4.view.PagerAdapter;
        import android.util.Log;
        import android.view.LayoutInflater;
        import android.view.View;
        import android.view.ViewGroup;
        import android.widget.ImageView;

        import com.site.siteproject.ailis.Splash;


public class HomePageradapter extends PagerAdapter {

    private Context mContext;

    int[] res = {
            R.drawable.ailis_logo,R.drawable.jaishree_logo,R.drawable.jothi_logo,R.drawable.ailis_logo,R.drawable.jaishree_logo,R.drawable.jothi_logo};




    public HomePageradapter(Context context) {
        mContext = context;




    }

    @Override
    public Object instantiateItem(ViewGroup collection, final int position) {

        LayoutInflater inflater = LayoutInflater.from(mContext);
        ViewGroup layout = (ViewGroup) inflater.inflate(R.layout.home_slider, collection, false);

        final ImageView imageView=(ImageView)layout.findViewById(R.id.image);
        imageView.setImageResource(res[position]);



        layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(position==0)
                {
                       Intent mainIntent = new Intent(
                            mContext,
                            Splash.class);

                    mContext.startActivity(mainIntent);

                }else if(position==1)
                {
                    Intent mainIntent = new Intent(
                            mContext,
                            com.site.siteproject.jaishree.Splash.class);

                    mContext.startActivity(mainIntent);

                }else if(position==2)
                {
                    Intent mainIntent = new Intent(
                            mContext,
                            com.site.siteproject.mathura.Splash.class);

                    mContext.startActivity(mainIntent);

                }

            }
        });








        collection.addView(layout);
        return layout;
    }

    @Override
    public void destroyItem(ViewGroup collection, int position, Object view) {
        collection.removeView((View) view);
    }

    @Override
    public int getCount() {
        return res.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }
    public float getPageWidth(int position) {





        //return 0.334f;
         return 0.345f;
    }

    public int getItemPosition(Object object) {
        return POSITION_NONE;
    }
}
