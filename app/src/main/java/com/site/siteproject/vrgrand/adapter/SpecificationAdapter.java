package com.site.siteproject.vrgrand.adapter;

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
 * Created by Creative IT Works on 14-Nov-17.
 */

public class SpecificationAdapter extends RecyclerView.Adapter<SpecificationAdapter.MyViewHolder> {


    Activity context;
    int lastCheckPosition = -1;
    Dialog dialog;

    int[] res = {
            R.drawable.ailis_spec1,R.drawable.ailis_spec2,R.drawable.ailis_spec3,R.drawable.ailis_spec4,R.drawable.ailis_spec5,R.drawable.ailis_spec6,R.drawable.ailis_spec7,R.drawable.ailis_spec8,R.drawable.ailis_spec9};
    String[] contents={"Framed structure with RCC column beams over masonry walls - plastered and paint finished. / Anti-termite treatment. / Rain Water Harvesting.","Kitchen platform will be granite with a single bowl with drain board stainless steel sink and glazed tiles dado of 4’0” feet above the kitchen platform, 5’0” feet dado in utility area (if provided). Aqua guard point in kitchen","Living, dining and bedroom area will be finished with good quality vitrified tiles of builder’s choice with necessary skirting","Living, dining and bedrooms walls will be finished with putty and emulsion paint. False ceiling (Plaster of Paris) with adequate light fittings will be provided for living, dining and bedrooms as per builder’s choice. All wooden frames and shutters will be polished and finished.","Ceramic flooring in the toilets will be provided as per builder’s choice (Anti Skid tiles).Bathroom walls will be covered with ceramic tiles as per builder’s choice up to ceiling height.Concealed / open plumbing lines along with pressurized water supply from the overhead tank will be provided.All closets and washbasins will be white (Jaguar/equivalent) of builder’s choice Hot and cold wall mixer will be provided for shower area & wash basins inside the bathrooms. All C.P. fittings will be Jaguar Florentine Collection / equivalent fitting.Toilet closets will be EWC floor as per builder's choice.","Concealed copper wiring suitable for three-phase supply, will be of ISI quality. Switches & sockets with adequate points for light, fan and power supply will be provided. Three phases supply with auto phase changer with trip switch will be provided. One calling bell point will be provided. Copper wiring for VRV system for entire villa except kitchen.","Main doorframe will be of teak wood and door shutter will be of teak wood panel door, finished with melamine polish.Other doors will be with good quality wood frames and flush doors with laminate sheets on both sides. All door fittings will be of brass fittings.Main door will be provided with Godrej or equivalent lock, door eye, tower bolt & door stopper.Doors to the bedrooms will be provided with door handles (SS finish).Door and frame will not be provided for kitchen.","Individual bore well and sump will be provided. Separate pumps for bore well and sump will be provided. Automatic water level controller for pumps will be provided.","Steel grills (painted) will be provided in all windows and ventilators. Windows will be of well seasoned country wood. Ventilators will be of good quality wood frame.","Anti-termite treatment, Aqua guard point in kitchen"};
    String[] titles={"Type of Construction","Kitchen","Flooring","Painting","Plumbing and Sanitary","Electrical","Doors","Water Supply","Windows and Ventilators","General"};
GlobalClass global;
    public SpecificationAdapter(Activity context) {
        global=(GlobalClass)context.getApplicationContext();
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

        holder.content.setText(contents[position]);
        holder.title.setText(titles[position]);

        global.setTypeface( holder.content);
        global.setTypeface(holder.title);

    }

    @Override
    public int getItemCount() {
        return res.length;
    }


    public class MyViewHolder extends RecyclerView.ViewHolder {

        ImageView layout;
        TextView content,tv_learnmore_quest,title;

        public MyViewHolder(View view) {
            super(view);

            content=(TextView) itemView.findViewById(R.id.content);
            title=(TextView) itemView.findViewById(R.id.title);




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
