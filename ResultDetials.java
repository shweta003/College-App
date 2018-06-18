package com.mcc.myapplication;

import android.app.ProgressDialog;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import org.json.JSONException;
import org.json.JSONObject;

import utility.AppController;

public class ResultDetials extends AppCompatActivity {
    private static final  String TAG="Result";

    String id,path,name;

    TextView header,output;
    EditText seatno;
    Button btn_enter;
    ProgressDialog progress ;

    private String urlJsonObj = "http://192.168.56.1:8080/mcc/getResult.php";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result_detials);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        progress = new ProgressDialog(this);
        progress.setMessage("Loading...");
        progress.setProgressStyle(ProgressDialog.STYLE_SPINNER);


        //
        id=this.getIntent().getStringExtra("id");
        name=this.getIntent().getStringExtra("name");
        path=this.getIntent().getStringExtra("path");


        header=(TextView)findViewById(R.id.header);
        output=(TextView)findViewById(R.id.output);
        output.setVisibility(View.GONE);
        seatno=(EditText)findViewById(R.id.seatno);
        btn_enter=(Button)findViewById(R.id.get_result);

        header.setText(name);

        btn_enter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                makeJsonObjectRequest(seatno.getText().toString(),path);
            }
        });


    }

    private void makeJsonObjectRequest(String seatno,String path) {

        String link=urlJsonObj+"?seatno="+seatno+"&path="+path.trim().replace(" ", "%20");




        progress.show();




        // Request a string response from the provided URL.
        StringRequest stringRequest = new StringRequest(Request.Method.GET, link,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        Log.d(TAG, response.toString());
                        output.setVisibility(View.VISIBLE);
                        try {
                            JSONObject obj=new JSONObject(response);
                            try {
                                if(obj.getBoolean("valid_seat_no")==true)
                                {
                                    if(obj.getString("result").equals("P")) {
                                        output.setTextColor(Color.BLUE);
                                        output.setText("Congratulations You Are Successful");
                                    }else
                                    {
                                        output.setTextColor(Color.RED);
                                        output.setText("Sorry You Are Unsuccessful");
                                    }
                                }
                                else
                                {
                                    output.setText("No Such A Seat Number !!");
                                    output.setTextColor(Color.RED);
                                }
                            } catch (JSONException e) {
                                e.printStackTrace();
                                progress.dismiss();
                            }



                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                        progress.dismiss();


                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getApplicationContext(),
                        "djdsbjbsdjbsdjsdb "+error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
       // Add the request to the RequestQueue.
        AppController.getInstance().addToRequestQueue(stringRequest);
    }

}
