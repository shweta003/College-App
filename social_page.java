package com.mcc.myapplication;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.text.Spanned;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class social_page extends AppCompatActivity {
    ImageView fb, web;
    Intent facebookAppIntent;
    TextView HyperLink;
    Spanned Text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_social_page);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        fb= (ImageView)findViewById(R.id.fbButton);
        web= (ImageView)findViewById(R.id.webButton);

        HyperLink = (TextView)findViewById(R.id.spectrumLink);

        Text = Html.fromHtml("<br />" +
                "<a href='https://www.facebook.com/Spectrum15-1531521023732144/'>Click here to visit Spectrum </a>");

        HyperLink.setMovementMethod(LinkMovementMethod.getInstance());
        HyperLink.setText(Text);

        fb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    facebookAppIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("fb://page/Mulund-College-of-Commerce-103429719774555"));
                    startActivity(facebookAppIntent);
                } catch (ActivityNotFoundException e) {
                    facebookAppIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com/Mulund-College-of-Commerce-103429719774555/"));
                    startActivity(facebookAppIntent);
                }
            }
        });

        web.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("http://mccmulund.ac.in/webpages/HomePage.aspx")));
            }
        });
    }
}
