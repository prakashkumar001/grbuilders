package com.site.siteproject.ailis.adapter;

import android.app.Activity;
import android.app.Dialog;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.site.siteproject.R;

/**
 * Created by Creative IT Works on 20-Dec-17.
 */

public class LocationIconAdapter   extends RecyclerView.Adapter<LocationIconAdapter.MyViewHolder> {


        Activity context;

        int[] res = {
        R.drawable.i001,R.drawable.i002,R.drawable.i003,R.drawable.i004,R.drawable.i005,R.drawable.i006,R.drawable.i007,R.drawable.i008,R.drawable.i009};

        String[] titles={"Play Schools","Schools","Colleges","Hospitals","Place of Workships","Hotel,Restaurent & Cafes","Malls & Entertainment","Super markets","Places of importance"};
        String[] contents={"Framed structure with RCC column beams over masonry walls - plastered and paint finished. / Anti-termite treatment. / Rain Water Harvesting.","Kitchen platform will be granite with a single bowl with drain board stainless steel sink and glazed tiles dado of 4’0” feet above the kitchen platform, 5’0” feet dado in utility area (if provided). Aqua guard point in kitchen","Living, dining and bedroom area will be finished with good quality vitrified tiles of builder’s choice with necessary skirting","Living, dining and bedrooms walls will be finished with putty and emulsion paint. False ceiling (Plaster of Paris) with adequate light fittings will be provided for living, dining and bedrooms as per builder’s choice. All wooden frames and shutters will be polished and finished.","Ceramic flooring in the toilets will be provided as per builder’s choice (Anti Skid tiles).Bathroom walls will be covered with ceramic tiles as per builder’s choice up to ceiling height.Concealed / open plumbing lines along with pressurized water supply from the overhead tank will be provided.All closets and washbasins will be white (Jaguar/equivalent) of builder’s choice Hot and cold wall mixer will be provided for shower area & wash basins inside the bathrooms. All C.P. fittings will be Jaguar Florentine Collection / equivalent fitting.Toilet closets will be EWC floor as per builder's choice.","Concealed copper wiring suitable for three-phase supply, will be of ISI quality. Switches & sockets with adequate points for light, fan and power supply will be provided. Three phases supply with auto phase changer with trip switch will be provided. One calling bell point will be provided. Copper wiring for VRV system for entire villa except kitchen.","Main doorframe will be of teak wood and door shutter will be of teak wood panel door, finished with melamine polish.Other doors will be with good quality wood frames and flush doors with laminate sheets on both sides. All door fittings will be of brass fittings.Main door will be provided with Godrej or equivalent lock, door eye, tower bolt & door stopper.Doors to the bedrooms will be provided with door handles (SS finish).Door and frame will not be provided for kitchen.","Individual bore well and sump will be provided. Separate pumps for bore well and sump will be provided. Automatic water level controller for pumps will be provided.","Steel grills (painted) will be provided in all windows and ventilators. Windows will be of well seasoned country wood. Ventilators will be of good quality wood frame.","Anti-termite treatment, Aqua guard point in kitchen"};

public LocationIconAdapter(Activity context) {

        this.context = context;



        }


@Override
public LocationIconAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
        .inflate(R.layout.location_icon_items, parent, false);

        return new LocationIconAdapter.MyViewHolder(itemView);
        }

@Override
public void onBindViewHolder(LocationIconAdapter.MyViewHolder holder, final int position) {
        holder.title.setText(titles[position]);
    holder.icons.setImageResource(res[position]);


        }

@Override
public int getItemCount() {
        return res.length;
        }


public class MyViewHolder extends RecyclerView.ViewHolder {

    ImageView icons;
    TextView title;

    public MyViewHolder(View view) {
        super(view);

        title = (TextView) itemView.findViewById(R.id.title);
        icons = (ImageView) itemView.findViewById(R.id.icons);


    }
}
}
