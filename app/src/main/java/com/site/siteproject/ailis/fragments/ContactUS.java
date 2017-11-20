package com.site.siteproject.ailis.fragments;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
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
    EditText name, email, phone_number;
    Button submit;
    String names, emails, phone;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.jaishree_contactus, container, false);
        name = (EditText) view.findViewById(R.id.name);
        email = (EditText) view.findViewById(R.id.email);
        phone_number = (EditText) view.findViewById(R.id.phone);
        submit = (Button) view.findViewById(R.id.submit);

        submit.setBackgroundResource(R.drawable.ailis_interestbg);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                names = name.getText().toString();
                emails = email.getText().toString();
                phone = phone_number.getText().toString();
                sendEmailtoCustomer();
            }
        });


        return view;

    }

    void sendEmailtoCustomer() {
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
                HashMap<String, String> data = new HashMap<>();
                data.put("name", names);
                data.put("email", emails);
                data.put("mobile", phone);
                data.put("project", "ailis");


                response = new WSUtils().getResultFromHttpRequest("http://www.passinovat.com/demo/tab.php", "POST", data);
                Log.i("JSON", "JSON" + response);


                return response;
            }

            @Override
            protected void onPostExecute(String s) {
                dialog.dismiss();
                super.onPostExecute(s);

                if (!s.equalsIgnoreCase("null") || s != null) {

                    successDialog();

                }

            }
        }
        new SyncServer().execute();
    }

    void successDialog() {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
                getActivity());

        // set title
        alertDialogBuilder.setTitle("Alert");

        // set dialog message
        alertDialogBuilder
                .setMessage("Successfully send to the mail")
                .setCancelable(false)
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // if this button is clicked, close
                        // current activity

                        dialog.dismiss();
                    }
                });

        // create alert dialog
        AlertDialog alertDialog = alertDialogBuilder.create();

        // show it
        alertDialog.show();

    }

    }
