package com.mcc.myapplication;

import android.Manifest;
import android.app.ProgressDialog;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
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
import com.kosalgeek.genasync12.AsyncResponse;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import helper.DownloadFiles;
import helper.ExamListAdapter;
import helper.Exam_model;
import utility.AppController;



public class exam extends AppCompatActivity implements AsyncResponse,View.OnClickListener {

    private static final  String TAG="exam";
    private String urlJsonObj = "http://192.168.56.1:8080/mcc/fetch_exam_time_table.php";
    private List<Exam_model> examList = new ArrayList<Exam_model>();
    private ExamListAdapter adapter;
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
        setContentView(R.layout.activity_exam);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        progress = new ProgressDialog(this);
        progress.setMessage("Loading...");
        progress.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        listView= (ListView) findViewById(R.id.time_table);
        //imp for device running marshmallow



        adapter = new ExamListAdapter(this, examList);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {



                Exam_model ex=examList.get(position);
                String name=ex.getName();
                String id1=ex.getId();
                String path=ex.getPath();
                /*Toast.makeText(getApplicationContext(),"id="+id1+"  name="+name+" path="+path,Toast.LENGTH_LONG).show();*/
                String link1=path.trim().replace(" ", "%20");
                String local_path= Environment.getExternalStorageDirectory() + "/MCC/TimeTable/";

                new DownloadFiles().execute(link1, name+".pdf", local_path);

                Toast.makeText(getApplicationContext(), "Download Completed", Toast.LENGTH_SHORT).show();
                Toast.makeText(getApplicationContext(), "File Location : "+"/MCC/TimeTable/", Toast.LENGTH_LONG).show();

            }
        });
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
                        Exam_model em = new Exam_model();
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

    private boolean shouldAskPermission(){
        return(Build.VERSION.SDK_INT> Build.VERSION_CODES.LOLLIPOP_MR1);
    }

    @Override
    public void onRequestPermissionsResult(int permsRequestCode, String[] permissions, int[] grantResults){

        switch(permsRequestCode){

            case 200:
                boolean writeAccepted = grantResults[0]== PackageManager.PERMISSION_GRANTED;
                break;

        }

    }

    @Override
    public void processFinish(String s) {

    }

    @Override
    public void onClick(View v) {

    }
}
