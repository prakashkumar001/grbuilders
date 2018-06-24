package com.site.siteproject.vrgrand.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;

import com.site.siteproject.Amenities;
import com.site.siteproject.R;
import com.site.siteproject.utils.GlobalClass;

/**
 * Created by Prakash on 12/16/2017.
 */

public class Location extends Fragment
{

    Button next;
    //<iframe width="700" height="400" src="https://www.youtube.com/embed/DxFarjyPiiY" frameborder="0" allow="autoplay; encrypted-media" allowfullscreen></iframe>
    String YouTubeVideoEmbedCode = "<html><body><iframe width=\"700\" height=\"400\" src=\"https://www.youtube.com/embed/DxFarjyPiiY\" frameborder=\"0\" allow=\"autoplay; encrypted-media\" allowfullscreen></iframe>\n</body></html>";
    GlobalClass global;
    private WebView myWebView;
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

            View view = inflater.inflate(R.layout.locations, container, false);

        next=(Button) view.findViewById(R.id.next);
        next.setBackgroundResource(R.drawable.ailis_interestbg);
        global=(GlobalClass) getActivity().getApplicationContext();
        global.setTypeface(next);
        myWebView = (WebView)view. findViewById(R.id.webview);

        myWebView.setWebViewClient(new WebViewClient() {

            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {

                return false;
            }
        });

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Amenities amenities=new Amenities();
                loadFragment(amenities);
            }
        });

        WebSettings webSettings = myWebView.getSettings();

        webSettings.setJavaScriptEnabled(true);

        myWebView.loadData(YouTubeVideoEmbedCode, "text/html", "utf-8");

            return view;

        }

    public void loadFragment(Fragment fragments) {


        FragmentTransaction ft = getActivity().getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.container, fragments, fragments.getClass().getSimpleName()).commit();

    }




        }
