package com.mcc.myapplication;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.text.Spanned;
import android.text.method.LinkMovementMethod;
import android.widget.TextView;

public class campus extends AppCompatActivity {

    Spanned text;
    TextView HyperLink;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_campus);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //setting typeface
        Typeface body = Typeface.createFromAsset(getAssets(),"fonts/censcbk.TTF");
        TextView txt1= (TextView)findViewById(R.id.txt1);
        TextView txt2= (TextView)findViewById(R.id.txt2);
        txt1.setTypeface(body); txt2.setTypeface(body);

        //set hyperlink
        HyperLink = (TextView)findViewById(R.id.campus_reg_link);
        text = Html.fromHtml("<br />" + "<a href='https://docs.google.com/forms/d/10yiwaaAmpIY2jCkHlkTzu9fFlaacYP3uC2lqXmSNZ7c/viewform?c=0&w=1'>Click here to Register </a>");
        HyperLink.setMovementMethod(LinkMovementMethod.getInstance());
        HyperLink.setText(text);
    }

}
