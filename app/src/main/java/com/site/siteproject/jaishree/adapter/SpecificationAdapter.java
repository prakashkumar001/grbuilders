package com.site.siteproject.jaishree.adapter;

import android.app.Activity;
import android.app.Dialog;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.site.siteproject.R;

import java.util.List;

import static android.R.attr.data;

/**
 * Created by Creative IT Works on 14-Nov-17.
 */

public class SpecificationAdapter  extends RecyclerView.Adapter<SpecificationAdapter.MyViewHolder> {


    Activity context;
    int lastCheckPosition = -1;
    Dialog dialog;


    public SpecificationAdapter(Activity context) {

        this.context = context;
        this.dialog = dialog;


    }


    @Override
    public SpecificationAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.jaishree_specification_item, parent, false);

        return new SpecificationAdapter.MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(SpecificationAdapter.MyViewHolder holder, final int position) {

    }

    @Override
    public int getItemCount() {
        return 5;
    }


    public class MyViewHolder extends RecyclerView.ViewHolder {

        public MyViewHolder(View view) {
            super(view);


        }
    }
}
