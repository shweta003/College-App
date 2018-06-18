package com.mcc.myapplication;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ViewFlipper;

public class library extends AppCompatActivity {

    int [] resources={R.drawable.lib1, R.drawable.lib2};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_library);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        // Get the ViewFlipper
        ViewFlipper flipper = (ViewFlipper) findViewById(R.id.viewFlipper);

        // Add all the images to the ViewFlipper
        for (int i = 0; i < resources.length; i++) {
            ImageView imageView = new ImageView(this);
            imageView.setImageResource(resources[i]);
            flipper.addView(imageView);
        }
        // Set in/out flipping animations
        flipper.setInAnimation(this, android.R.anim.slide_in_left);
        flipper.setOutAnimation(this, android.R.anim.slide_out_right);

        flipper.setAutoStart(true);
        flipper.setFlipInterval(6000);

        TextView lib_intro=(TextView)findViewById(R.id.lib_intro);
        TextView lib_detail=(TextView)findViewById(R.id.lib_detail);
        TextView obj_lib=(TextView)findViewById(R.id.obj_lib);
        TextView obj1_lib=(TextView)findViewById(R.id.obj1_lib);
        TextView feature_lib=(TextView)findViewById(R.id.feature_lib);
        TextView feature1_lib=(TextView)findViewById(R.id.feature1_lib);
        TextView facility_lib=(TextView)findViewById(R.id.facility_lib);
        TextView facility1_lib=(TextView)findViewById(R.id.facility1_lib);

        Typeface heading=Typeface.createFromAsset(getAssets(),"fonts/cac_champagne.ttf");
        obj_lib.setTypeface(heading,Typeface.BOLD);
        feature_lib.setTypeface(heading,Typeface.BOLD);
        facility_lib.setTypeface(heading,Typeface.BOLD);

        Typeface body = Typeface.createFromAsset(getAssets(), "fonts/censcbk.TTF");
        lib_intro.setTypeface(body); lib_detail.setTypeface(body);
        obj1_lib.setTypeface(body);
        feature1_lib.setTypeface(body);
        facility1_lib.setTypeface(body);

        lib_intro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        lib_detail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        obj_lib.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        obj1_lib.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        feature_lib.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {

            }
        });

        feature1_lib.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {

            }
        });

        facility_lib.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {

            }
        });
        facility1_lib.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {

            }
        });
    }

}
