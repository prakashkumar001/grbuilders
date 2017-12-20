package com.site.siteproject.ailis.fragments;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.site.siteproject.MainActivity;
import com.site.siteproject.R;
import com.site.siteproject.thiruvidanthai.DashBoard;
import com.site.siteproject.utils.GlobalClass;
import com.site.siteproject.utils.WSUtils;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;

/**
 * Created by Creative IT Works on 15-Nov-17.
 */

public class ContactUS extends AppCompatActivity {
    EditText name, email, phone_number;

    Button submit;
    String names, emails, phone;
    TextView nametext,emailtext,phonetext;
    GlobalClass global;


        @Override
        protected void onCreate(@Nullable Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.jaishree_contactus);
            global=(GlobalClass)getApplicationContext();
            name = (EditText) findViewById(R.id.name);
            email = (EditText)findViewById(R.id.email);
            phone_number = (EditText) findViewById(R.id.phone);


            nametext = (TextView) findViewById(R.id.nametext);
            emailtext = (TextView)findViewById(R.id.emailtext);
            phonetext = (TextView) findViewById(R.id.phonetext);

            global.setTypeface(name);
            global.setTypeface(email);
            global.setTypeface(phone_number);
            global.setTypeface(nametext);
            global.setTypeface(emailtext);
            global.setTypeface(phonetext);
            global.setTypeface(submit);



            submit = (Button) findViewById(R.id.submit);

            submit.setBackgroundResource(R.drawable.ailis_interestbg);

            submit.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    names = name.getText().toString();
                    emails = email.getText().toString();
                    phone = phone_number.getText().toString();

                    if(name.getText().toString().length()>0 && email.getText().toString().length()>0 && phone_number.getText().toString().length()>0)
                    {
                        sendEmailtoCustomer();
                    }else
                    {
                        Toast.makeText(getApplicationContext(),"Please Fill all Fields",Toast.LENGTH_SHORT).show();
                    }

                }
            });

        }




    void sendEmailtoCustomer() {
        class SyncServer extends AsyncTask<String, Void, String> {

            ProgressDialog dialog;

            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                dialog = new ProgressDialog(ContactUS.this);
                dialog.setMessage("Loading...");
                dialog.setCancelable(false);
                dialog.show();
            }

            @Override
            protected String doInBackground(String[] params) {

                String response = "";
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

                if (s==null) {

                    successDialog("Mail Sending Failed");

                }else
                {
                    try {
                        JSONObject object=new JSONObject(s);
                        String status=object.getString("status");
                        if(status.equalsIgnoreCase("success"))
                        {
                            successDialog("Mail Sent successfully");

                        }else
                        {
                            successDialog("Mail Sending Failed");
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                }

            }
        }
        new SyncServer().execute();
    }

    void successDialog(String message) {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
                ContactUS.this);

        // set title
        alertDialogBuilder.setTitle("Alert");

        // set dialog message
        alertDialogBuilder
                .setMessage(message)
                .setCancelable(false)
                .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // if this button is clicked, close
                        // current activity

                        dialog.dismiss();

                        Intent i=new Intent(getApplicationContext(), com.site.siteproject.ailis.DashBoard.class);
                        startActivity(i);
                        finish();
                    }
                });

        // create alert dialog
        AlertDialog alertDialog = alertDialogBuilder.create();

        // show it
        alertDialog.show();

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent i=new Intent(com.site.siteproject.ailis.fragments.ContactUS.this, MainActivity.class);
        startActivity(i);
        ActivityCompat.finishAffinity(com.site.siteproject.ailis.fragments.ContactUS.this);
    }

    }
