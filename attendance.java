package com.mcc.myapplication;

import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class attendance extends AppCompatActivity implements OnItemSelectedListener {
    TextView faculty_name, dept_name;
    Spinner acad_year, sub_name;
    Button submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_attendance);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        faculty_name=(TextView)findViewById(R.id.faculty_name);
        String str_username = getIntent().getStringExtra("Username");
        faculty_name.setText(str_username);
        dept_name=(TextView)findViewById(R.id.dept_name);
        acad_year=(Spinner)findViewById(R.id.acadamic_year);

        List<String> years = new ArrayList<String>();
        years.add("First Year");
        years.add("Second Year");
        years.add("Third Year");

        sub_name=(Spinner)findViewById(R.id.subject_name);

        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, years);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        acad_year.setAdapter(dataAdapter);
        acad_year.setOnItemSelectedListener(this);
        submit=(Button)findViewById(R.id.submit);
    }
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        // On selecting a spinner item
        String item = parent.getItemAtPosition(position).toString();

        // Showing selected spinner item
        Toast.makeText(parent.getContext(), "Selected: " + item, Toast.LENGTH_LONG).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id=item.getItemId();
        if(id == android.R.id.home){
            NavUtils.navigateUpFromSameTask(this);
        }
        return super.onOptionsItemSelected(item);
    }
}
