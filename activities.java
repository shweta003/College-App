package com.mcc.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;
import android.widget.ViewFlipper;

public class activities extends AppCompatActivity {

    int mFlipping = 0 ; // Initially flipping is off
    String[] items={"Sports","Events"};
    ListView lv;
    ArrayAdapter<String> adapter;
    int [] resources={R.drawable.a, R.drawable.b, R.drawable.c, R.drawable.d, R.drawable.e, R.drawable.f};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activities);
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

       // if(mFlipping==0){
            /** Start Flipping */
         //   flipper.setFlipInterval(6000);
          //  flipper.startFlipping();
         //   mFlipping=1;
       // }
      //  else{
            /** Stop Flipping */
       //     flipper.stopFlipping();
      //      mFlipping=0;
     //   }


        lv= (ListView)findViewById(R.id.main_activity);

        //setListAdapter(new ArrayAdapter<String>(this, R.layout.header, activity));

        adapter= new ArrayAdapter<String>(this,R.layout.activity_items, items);
        lv.setAdapter(adapter);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(), "clicked at" + position, Toast.LENGTH_LONG).show();

                    //Class selected= Class.forName("com.mcc.myapplication."+ pos);
                    switch (position) {
                        case 0:
                        startActivity(new Intent(getBaseContext(),sports.class));
                            break;
                        case 1:
                            startActivity(new Intent(getBaseContext(),Events.class));
                            break;
                    }

            }
        });
    }
/*
        @Override
        protected void onPause() {
            super.onPause();
            finish();
        }
        */
}

