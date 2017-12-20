package com.site.siteproject.ailis.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;

import com.site.siteproject.R;
import com.site.siteproject.ailis.adapter.LocationIconAdapter;
import com.site.siteproject.ailis.adapter.SpecificationAdapter;

/**
 * Created by Prakash on 12/16/2017.
 */

public class Location extends Fragment
{
    RecyclerView list;
    LocationIconAdapter adapter;
    String YouTubeVideoEmbedCode = "<html><body><iframe width=\"500\" height=\"250\" src=\"https://www.youtube.com/embed/-fEIzQ5JD84\" frameborder=\"0\" allowfullscreen></iframe></body></html>";

    private WebView myWebView;
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

            View view = inflater.inflate(R.layout.locations, container, false);

        myWebView = (WebView)view. findViewById(R.id.webview);

        myWebView.setWebViewClient(new WebViewClient() {

            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {

                return false;
            }
        });

        WebSettings webSettings = myWebView.getSettings();

        webSettings.setJavaScriptEnabled(true);

        myWebView.loadData(YouTubeVideoEmbedCode, "text/html", "utf-8");
        list=(RecyclerView)view.findViewById(R.id.list);

        adapter = new LocationIconAdapter(getActivity());
        GridLayoutManager ll = new GridLayoutManager(getActivity(),3);
        ll.setOrientation(LinearLayoutManager.VERTICAL);
        list.setLayoutManager(ll);

        list.setAdapter(adapter);
            return view;

        }





        }
