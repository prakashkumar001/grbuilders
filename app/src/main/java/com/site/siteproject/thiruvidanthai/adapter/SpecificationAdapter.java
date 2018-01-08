package com.site.siteproject.thiruvidanthai.adapter;

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
            R.drawable.ailis_spec1,R.drawable.ailis_spec2,R.drawable.ailis_spec3,R.drawable.ailis_spec4,R.drawable.ailis_spec5,R.drawable.ailis_spec6,R.drawable.ailis_spec7,R.drawable.ailis_spec_10,R.drawable.ailis_spec8,R.drawable.ailis_spec9};
    String[] contents={"Framed Structure with RCC column beams over brick masonry walls of 9 inches and 4.5 inches walls plastered and finished with cement paint internally and externally.","Kitchen platform will be polished granite with a single bowl stainless steel sink and glazed tiles dado of 2’0” feet above the kitchen platform, 3’0” feet dado in utility area (if provided).","Living, Dining and bed room area will be finished with good quality Vitrified Tiles of Builders choice with necessary skirting.","Living ,Dining and bed rooms walls will be finished with emulsion paint. ceiling will be finished with cement paint.","Walls will be covered with ceramic tiles as per Builder’s choice upto a height of 7 feet. Concealed / open plumbing lines from the overhead tank will be provided.","Three phases supply with manual phase changer will be provided for each flat. One calling bell point will be provided. Provision for UPS wiring will be provided.","Doors to the bedrooms will be provided with cylindrical locks. Door and frame will not be provided for kitchen.","One common bore wells and one sump will be provided. One pump for Bore well and one pump for sump will be provided.","Steel grills (painted) will be provided in all windows and Ventilators. Windows & Ventilators will be of good quality Aluminum.","One individual letterbox will be provided at the entrance to the building. Concealed PVC pipes for TV antenna will be provided in the living room and bedrooms."};
    String[] titles={"Type of Construction","Kitchen","Flooring","Painting","Plumbing and Sanitary","Electrical","Doors","Water Supply","Windows and Ventilators","General"};

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
        holder.itemView.setOnClickListener(new View.OnClickListener() {
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


            content=(TextView) itemView.findViewById(R.id.content);



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
