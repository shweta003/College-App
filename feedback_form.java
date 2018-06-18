package com.mcc.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class feedback_form extends AppCompatActivity implements OnItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback_form);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        EditText nameField = (EditText) findViewById(R.id.editTextName);
        String name = nameField.getText().toString();

        EditText emailField = (EditText) findViewById(R.id.editTextEmail);
        String email = emailField.getText().toString();

        EditText commentField = (EditText) findViewById(R.id.editTextComments);
        String feedback = commentField.getText().toString();

        Spinner feedbackSpinner = (Spinner) findViewById(R.id.SpinnerFeedbackType);

        List<String> categories = new ArrayList<String>();
        categories.add("Praise");
        categories.add("Gripe");
        categories.add("Suggestions");
        categories.add("Bug");

        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, categories);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        feedbackSpinner.setAdapter(dataAdapter);
        feedbackSpinner.setOnItemSelectedListener(this);

        String feedbackType = feedbackSpinner.getSelectedItem().toString();
    }
public void sendFeedback(View button){
    // Do click handling here
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
}
