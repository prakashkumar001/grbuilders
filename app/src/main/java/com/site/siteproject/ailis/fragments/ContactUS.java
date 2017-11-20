package com.site.siteproject.ailis.fragments;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.site.siteproject.R;
import com.site.siteproject.utils.WSUtils;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;

/**
 * Created by Creative IT Works on 15-Nov-17.
 */

public class ContactUS extends Fragment {
    EditText name,email,phone_number;
    Button submit;
    String names,emails,
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.jaishree_contactus, container, false);
        name=(EditText)view.findViewById(R.id.name);
        email=(EditText)view.findViewById(R.id.email);
        phone_number=(EditText)view.findViewById(R.id.phone);
        submit=(Button)view.findViewById(R.id.submit);

        submit.setBackgroundResource(R.drawable.ailis_interestbg);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });


        return view;

    }

    void sendEmailtoCustomer(final String pinNumber) {
        class SyncServer extends AsyncTask<String, Void, String> {

            ProgressDialog dialog;

            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                dialog = new ProgressDialog(getActivity());
                dialog.setMessage("Loading...");
                dialog.show();
            }

            @Override
            protected String doInBackground(String[] params) {

                String response = null;
                HashMap<String,String> data=new HashMap<>();
                data.put("name",name.getText().toString());
                data.put("email",pinNumber);
                data.put("phone",pinNumber);
                data.put("phone","ailis");


                response = new WSUtils().getResultFromHttpRequest("http://www.passinovat.com/demo/tab.php", "POST", data);
                Log.i("JSON", "JSON" + response);


                return response;
            }

            @Override
            protected void onPostExecute(String s) {
                dialog.dismiss();
                super.onPostExecute(s);

                if(!s.equalsIgnoreCase("null") || s!=null)
                {

                }

            }
        } new SyncServer().execute();
    }

    }
