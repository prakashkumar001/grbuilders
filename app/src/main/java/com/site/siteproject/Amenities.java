package com.site.siteproject;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.site.siteproject.ailis.adapter.LocationIconAdapter;

/**
 * Created by Prakash on 1/7/2018.
 */

public class Amenities extends Fragment {
    RecyclerView list;
    LocationIconAdapter adapter;

    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.amenities, container, false);

        list=(RecyclerView)view.findViewById(R.id.list);

        adapter = new LocationIconAdapter(getActivity());
        GridLayoutManager ll = new GridLayoutManager(getActivity(),3);
        ll.setOrientation(LinearLayoutManager.VERTICAL);
        list.setLayoutManager(ll);

        list.setAdapter(adapter);

        return view;
    }
}
