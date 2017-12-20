package com.site.siteproject.ailis.adapter;

import android.app.Activity;
import android.app.Dialog;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;

import com.site.siteproject.R;
import com.site.siteproject.utils.GlobalClass;

/**
 * Created by Creative IT Works on 15-Dec-17.
 */

public class about_us_adapter extends RecyclerView.Adapter<about_us_adapter.MyViewHolder> {


    Activity context;
    int lastCheckPosition = -1;
    Dialog dialog;
    GlobalClass globalClass;

      String[] contents={"Nahar Foundation’s Private Limited (NFPL) saw its beginning that reflected their penchant to provide quality realty solutions, and that aimed at creating homes and not just houses for their clients. Their keen eye for detail and expertise with the intricacies of construction has brought over 60 prestigious residential projects to the firm’s dossier.","Incorporated in the year 2003, Nahar Foundations has offered exceptional real estate developments over the years that adorn the city’s magnificent skyline.","Guided by integrity, innovation, quality and high service standards, Nahar Foundations has grown momentously to attain a distinguished position of leadership in the real estate industry by successfully crafting many landmark projects across the city. Each of the Nahar projects stands apart in their aesthetic design, impeccable quality and enticing features that lend exceptional value and privilege to those who own them."};

    public about_us_adapter(Activity context) {
        globalClass=(GlobalClass)context.getApplicationContext();
        this.context = context;



    }


    @Override
    public about_us_adapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.aboutus_item, parent, false);

        return new about_us_adapter.MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(about_us_adapter.MyViewHolder holder, final int position) {

        holder.content.setText(contents[position]);
        globalClass.setTypeface(holder.content);

    }

    @Override
    public int getItemCount() {
        return contents.length;
    }


    public class MyViewHolder extends RecyclerView.ViewHolder {

        ImageView layout;
        TextView content,tv_learnmore_quest,title;

        public MyViewHolder(View view) {
            super(view);

            content=(TextView) itemView.findViewById(R.id.content);




        }
    }


}