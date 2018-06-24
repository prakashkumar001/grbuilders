package com.site.siteproject;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.site.siteproject.vrgrand.adapter.about_us_adapter;
import com.site.siteproject.utils.GlobalClass;

/**
 * Created by Creative IT Works on 15-Dec-17.
 */

public class AboutUs extends AppCompatActivity {
    GlobalClass global;
    TextView phone,web;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.about);
        global=(GlobalClass)getApplicationContext();

        RecyclerView recyclerView=(RecyclerView)findViewById(R.id.list);
        Button button=(Button)findViewById(R.id.continues);
         phone=(TextView)findViewById(R.id.phone);
         web=(TextView)findViewById(R.id.web);

        global.setTypeface(phone);
        global.setTypeface(web);
        global.setTypeface(button);


        about_us_adapter about_us_adapters=new about_us_adapter(AboutUs.this);
        LinearLayoutManager ll = new LinearLayoutManager(this);
        ll.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(ll);
        recyclerView.setAdapter(about_us_adapters);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AboutUs.this.finish();
                overridePendingTransition(R.anim.fadeinact,
                        R.anim.fadeoutact);

                Intent mainIntent = new Intent(
                        AboutUs.this,
                        MainActivity.class);

                AboutUs.this.startActivity(mainIntent);

            }
        });

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();

        ActivityCompat.finishAffinity(AboutUs.this);
    }
}
