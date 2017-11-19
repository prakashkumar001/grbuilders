package com.site.siteproject.mathura.adapter;

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

/**
 * Created by Creative IT Works on 14-Nov-17.
 */

public class SpecificationAdapter extends RecyclerView.Adapter<SpecificationAdapter.MyViewHolder> {


    Activity context;
    int lastCheckPosition = -1;
    Dialog dialog;

    int[] res = {
            R.drawable.jaishree_spec1,R.drawable.jaishree_spec2,R.drawable.jaishree_spec3,R.drawable.jaishree_spec4,R.drawable.jaishree_spec5,R.drawable.jaishree_spec6};
    String[] contents={"Loren Lipsum hgfhasguhasgjhdfasgjhdfgasjhg","Loren Lipsum hgfhasguhasgjhdfasgjhdfgasjhg","Loren Lipsum hgfhasguhasgjhdfasgjhdfgasjhg","Loren Lipsum hgfhasguhasgjhdfasgjhdfgasjhg","Loren Lipsum hgfhasguhasgjhdfasgjhdfgasjhg","Loren Lipsum hgfhasguhasgjhdfasgjhdfgasjhg"};

    public SpecificationAdapter(Activity context) {

        this.context = context;



    }


    @Override
    public SpecificationAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.jaishree_specification_item, parent, false);

        return new SpecificationAdapter.MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(SpecificationAdapter.MyViewHolder holder, final int position) {
        holder.layout.setImageResource(res[position]);
        holder.content.setText(contents[position]);
        holder.tv_learnmore_quest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showInfoDialog(position);
            }
        });

    }

    @Override
    public int getItemCount() {
        return res.length;
    }


    public class MyViewHolder extends RecyclerView.ViewHolder {

        ImageView layout;
        TextView content,tv_learnmore_quest;

        public MyViewHolder(View view) {
            super(view);

            layout=(ImageView)itemView.findViewById(R.id.image);
            content=(TextView) itemView.findViewById(R.id.content);
            tv_learnmore_quest=(TextView) itemView.findViewById(R.id.tv_learnmore_quest);



        }
    }

    public void showInfoDialog(int position) {

        // custom dialog
        final Dialog dialog = new Dialog(context, R.style.DialogSlideAnim);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.jaishree_spec_full_info);
        dialog.getWindow().setGravity(Gravity.CENTER);
        //dialog.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));

        DisplayMetrics metrics = context.getResources().getDisplayMetrics();
        int width = metrics.widthPixels;
        int height = metrics.heightPixels;
        dialog.show();
        dialog.getWindow().setLayout((8 * width) / 10, (8 * height) / 10);

       ImageView imageView=(ImageView)dialog.findViewById(R.id.image);
        ImageView close=(ImageView)dialog.findViewById(R.id.close);
        TextView content=(TextView) dialog.findViewById(R.id.content);
        imageView.setImageResource(res[position]);
        content.setText(contents[position]);

        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });


        dialog.show();


    }
}
