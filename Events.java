package com.mcc.myapplication;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.TextView;

public class Events extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_events);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);

        TextView e1=(TextView)findViewById(R.id.e1);
        TextView e3=(TextView)findViewById(R.id.e3);
        TextView e5=(TextView)findViewById(R.id.e5);
        TextView e7=(TextView)findViewById(R.id.e7);
        TextView e9=(TextView)findViewById(R.id.e9);
        TextView e11=(TextView)findViewById(R.id.e11);
        TextView e13=(TextView)findViewById(R.id.e13);
        TextView e15=(TextView)findViewById(R.id.e15) ;

        Typeface heading= Typeface.createFromAsset(getAssets(),"fonts/sofia_regular.otf");
        e1.setTypeface(heading, Typeface.BOLD); e3.setTypeface(heading, Typeface.BOLD);
        e5.setTypeface(heading, Typeface.BOLD); e7.setTypeface(heading, Typeface.BOLD);
        e9.setTypeface(heading, Typeface.BOLD); e11.setTypeface(heading, Typeface.BOLD);
        e13.setTypeface(heading, Typeface.BOLD); e15.setTypeface(heading, Typeface.BOLD);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if(id == android.R.id.home){
            NavUtils.navigateUpFromSameTask(this);
        }
        return super.onOptionsItemSelected(item);
    }
}
