package com.mcc.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

public class splashScreen extends Activity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash);

        Thread timerThread = new Thread(){
          public void run(){
              try{
                  sleep(3000);
              }catch (InterruptedException e){
                  e.printStackTrace();
              }finally {
                  startActivity(new Intent(splashScreen.this, MainActivity.class));
              }
          }
        };
        timerThread.start();
    }

    @Override
    protected void onPause() {
        super.onPause();
        finish();
    }
}
