package com.mcc.myapplication;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class about_us extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_us);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //ImageView iv = (ImageView) findViewById(R.id.aboutUS);
        TextView aMCC = (TextView) findViewById(R.id.about_MCC);
        TextView vision = (TextView) findViewById(R.id.vision);
        TextView mission = (TextView) findViewById(R.id.mission);
        TextView objective = (TextView) findViewById(R.id.objective);
        TextView abt1=(TextView)findViewById(R.id.abt1);
        TextView abt2=(TextView)findViewById(R.id.abt2);
        TextView vision1=(TextView)findViewById(R.id.vision1);
        TextView mission1=(TextView)findViewById(R.id.mission1);
        TextView mission2=(TextView)findViewById(R.id.mission2);
        TextView mission3=(TextView)findViewById(R.id.mission3);
        TextView obj1=(TextView)findViewById(R.id.obj1);
        TextView obj2=(TextView)findViewById(R.id.obj2);
        TextView obj3=(TextView)findViewById(R.id.obj3);
        TextView obj4=(TextView)findViewById(R.id.obj4);
        TextView obj5=(TextView)findViewById(R.id.obj5);

        Typeface heading=Typeface.createFromAsset(getAssets(),"fonts/cac_champagne.ttf");
        aMCC.setTypeface(heading,Typeface.BOLD);
        vision.setTypeface(heading,Typeface.BOLD);
        mission.setTypeface(heading,Typeface.BOLD);
        objective.setTypeface(heading, Typeface.BOLD);

        Typeface body = Typeface.createFromAsset(getAssets(),"fonts/censcbk.TTF");
        abt1.setTypeface(body); abt2.setTypeface(body);
        vision1.setTypeface(body);
        mission1.setTypeface(body); mission2.setTypeface(body); mission3.setTypeface(body);
        obj1.setTypeface(body); obj2.setTypeface(body); obj3.setTypeface(body);
        obj4.setTypeface(body); obj5.setTypeface(body);

        aMCC.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {

                                    }
                                }
        );

        vision.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

            }
        });

        mission.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        objective.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_abt_us, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id=item.getItemId();

        if(id==R.id.menu_princi_view){
            startActivity(new Intent(this,Princi_views.class));
        }
        return super.onOptionsItemSelected(item);
    }
}
