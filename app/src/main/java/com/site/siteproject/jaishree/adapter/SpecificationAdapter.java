package com.site.siteproject.jaishree.adapter;

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
import android.widget.LinearLayout;
import android.widget.TextView;

import com.site.siteproject.R;
import com.site.siteproject.utils.GlobalClass;

import org.w3c.dom.Text;

import java.util.List;

import static android.R.attr.data;

/**
 * Created by Creative IT Works on 14-Nov-17.
 */

public class SpecificationAdapter  extends RecyclerView.Adapter<SpecificationAdapter.MyViewHolder> {


    Activity context;
    int lastCheckPosition = -1;
    Dialog dialog;

    int[] res = {
            R.drawable.ailis_spec1,R.drawable.ailis_spec2,R.drawable.ailis_spec3,R.drawable.ailis_spec4,R.drawable.ailis_spec5,R.drawable.ailis_spec6,R.drawable.ailis_spec7,R.drawable.ailis_spec_10,R.drawable.ailis_spec8,R.drawable.ailis_spec9};
    String[] contents={"Framed structure with RCC column beams over masonry walls of 8 inches and 4 inches walls plastered and paint finished | Ceiling height will be 9-6” feet approximately except in the toilet where it will be 8’-6”."
            ,"Kitchen platform will be polished granite with a single bowl stainless steel sink and glazed tiles","Living, dining and bedroom area will be finished with good quality 2X2 vitrified tiles of builder’s choice with necessary skirting. | Ceramic flooring in the toilet will be provided as builder’s choice.","Concealed / open pluming line from the overhead tank will be provided | All closets and washbasins will be of white color as per builder’s choice | Provision in plumbing for connection one geyser in each toilet.","Concealed copper wiring suitable for three-phase supply, will be of ISI quality | Switches & sockets with adequate points for light, fan and power supply will be provided. | Separate meter for lighting in common areas and pumps.","Main doorframe be of teak and door shutter will be of good quality imported skin, finished with lacquer varnish. | Other doors will be with good quality wood frame and flush doors painted on both side.","Living , dining and bedrooms walls will be finished with emulsion paint. | Ceiling will be finished with cement paint | All wooden frames, shutters and M.S. Grill will be finished with enamel paint.","Two Common bore wells and one sump will be provided | Two pump for bore well and one pump for sump will be provided.",
         "Steel grills (painted) Will be provided in all windows and ventilators. | Windows will be of well seasoned country wood. | Ventilators will be good quality wood frame with glass louvers.","Anti-termite treatment | Aqua guard point in kitchen | Automatic water level controller for pumps will be provided | One individual letterbox will be provided at the entrance to the building."};

    GlobalClass global;


    String[] titles={"Type of Construction","Kitchen","Flooring","Painting","Plumbing and Sanitary","Electrical","Doors","Water Supply","Windows and Ventilators","General"};

    public SpecificationAdapter(Activity context) {

        this.context = context;


        global=(GlobalClass)context.getApplicationContext();

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
