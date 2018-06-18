package com.mcc.myapplication;

import android.Manifest;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import helper.ResultListAdapter;
import helper.Result_model;
import utility.AppController;

public class results extends AppCompatActivity {
    private static final  String TAG="exam";

    private String urlJsonObj = "http://192.168.56.1:8080/mcc/fetch_exam_result.php";

    private List<Result_model> examList = new ArrayList<Result_model>();
    private ResultListAdapter adapter;
    ListView listView;
    ProgressDialog progress ;

    private static final int REQUEST_EXTERNAL_STORAGE = 1;
    private static String[] PERMISSIONS_STORAGE = {
            Manifest.permission.READ_EXTERNAL_STORAGE,
            Manifest.permission.WRITE_EXTERNAL_STORAGE
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        progress = new ProgressDialog(this);
        progress.setMessage("Loading...");
        progress.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        listView= (ListView) findViewById(R.id.time_table);





        adapter = new ResultListAdapter(this, examList);

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Result_model ex=examList.get(position);

                String name=ex.getName();
                String id1=ex.getId();
                String path=ex.getPath();






                Intent objectId=new Intent(results.this,ResultDetials.class);
                objectId.putExtra("id", id1);
                objectId.putExtra("name", name);
                objectId.putExtra("path", path);

               startActivity(objectId);

            }
        });

        //filling listview
        makeJsonObjectRequest();
    }


    private void makeJsonObjectRequest() {

        progress.show();

        JsonObjectRequest jsonObjReq = new JsonObjectRequest(Request.Method.GET,
                urlJsonObj, new Response.Listener<JSONObject>() {

            @Override
            public void onResponse(JSONObject response) {
                Log.d(TAG, response.toString());

                try {
                    JSONArray arr=response.getJSONArray("data");

                    // Parsing json
                    for (int i = 0; i < arr.length(); i++) {
                        try {

                            JSONObject obj = arr.getJSONObject(i);
                            Result_model em = new Result_model();
                            em.setId(obj.getString("id"));
                            em.setName(obj.getString("name"));
                            em.setPath(obj.getString("path"));


                            // adding movie to movies array
                            examList.add(em);


                        } catch (JSONException e) {
                            e.printStackTrace();
                            progress.dismiss();
                        }

                    }

                    // notifying list adapter about data changes
                    // so that it renders the list view with updated data
                    adapter.notifyDataSetChanged();
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                progress.dismiss();
            }
        }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                VolleyLog.d(TAG, "Error: " + error.getMessage());
                Toast.makeText(getApplicationContext(),
                        error.getMessage(), Toast.LENGTH_SHORT).show();
                // hide the progress dialog

            }
        });

        // Adding request to request queue
        AppController.getInstance().addToRequestQueue(jsonObjReq);
    }




}
