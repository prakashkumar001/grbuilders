package com.site.siteproject.mathura.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
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
import com.site.siteproject.ailis.adapter.LocationIconAdapter;

/**
 * Created by Prakash on 12/16/2017.
 */

public class Location extends Fragment {
    Button next;
    String YouTubeVideoEmbedCode = "<html><body><iframe width=\"700\" height=\"400\" src=\"https://www.youtube.com/embed/8Zt0DStbKIc\" frameborder=\"0\" allowfullscreen></iframe></body></html>";

    private WebView myWebView;
    GlobalClass global;

    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.locations, container, false);
        next = (Button) view.findViewById(R.id.next);


        global=(GlobalClass) getActivity().getApplicationContext();
        global.setTypeface(next);

        myWebView = (WebView) view.findViewById(R.id.webview);


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

                Amenities amenities = new Amenities();
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
