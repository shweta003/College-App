package com.mcc.myapplication;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.NetworkResponse;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import utility.AppController;
import utility.SERVERURLS;

public class login extends AppCompatActivity {
    private static final String TAG=login.class.getSimpleName();
    EditText password, username1;
    Button sign_in;
   ProgressDialog pr;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        pr=new ProgressDialog(this);
        pr.setTitle("Loading");
        pr.setCancelable(false);
        pr.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        pr.setIndeterminate(true);

        username1 = (EditText)findViewById(R.id.username);
        password = (EditText)findViewById(R.id.password);
        sign_in = (Button)findViewById(R.id.email_sign_in_button);




        sign_in.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final String str_username = username1.getText().toString();
                final String str_pass = password.getText().toString();

                //Toast.makeText(getApplicationContext(), "Username and Password don't match.", Toast.LENGTH_SHORT).show();


                String url = SERVERURLS.login+"?name="+str_username+"&pass="+str_pass;

                // String url1 = Uri.parse(url1).toString();
                if (!str_username.isEmpty() && !str_pass.isEmpty()) {
                    jsoncall(str_username, str_pass, url);
                } else {
                    Toast.makeText(getApplicationContext(), "Please enter the credentials", Toast.LENGTH_LONG).show();
                }
            }
        });
    }



    private void jsoncall(final String str_username, final String str_pass, final String url) {

        pr.show();
        StringRequest strReq = new StringRequest(Request.Method.GET,
                url, new Response.Listener<String>() {

            @Override
            public void onResponse(String response) {
                //progress.dismiss();
                pr.dismiss();
                Log.e(TAG, "response: " + response);


                try {
                    JSONObject obj = new JSONObject(response);

                    // check for error flag
                    if (obj.getBoolean("error") == false) {
                        // user successfully logged in
                        //Toast.makeText(getApplicationContext(), "" + obj.getString("message"), Toast.LENGTH_LONG).show();
                        finish();
                        startActivity(new Intent(login.this,attendance.class));


                    } else if (obj.getBoolean("error") == true) {
                        // login error - simply toast the message
                        Toast.makeText(getApplicationContext(), "" + obj.getString("message"), Toast.LENGTH_LONG).show();
                    }

                } catch (JSONException e) {
                    Log.e(TAG, "json parsing error: " + e.getMessage());
                    Toast.makeText(getApplicationContext(), "Json parse error: " + e.getMessage(), Toast.LENGTH_SHORT).show();
                }
            }

        }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                pr.dismiss();
                NetworkResponse networkResponse = error.networkResponse;
                Log.e(TAG, "Volley error: " + error.getMessage() + ", code: " + networkResponse);
                Toast.makeText(getApplicationContext(), "Volley error: " + error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        }) {

            @Override
            protected Map<String, String> getParams() {
                Map<String, String> params = new HashMap<>();

                Log.e(TAG, "params: " + params.toString());
                return params;
            }
        };

        //Adding request to request queue
        AppController.getInstance().addToRequestQueue(strReq);
    }
}
