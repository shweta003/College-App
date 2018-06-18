package com.mcc.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ExpandableListView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import helper.ExpandableListAdapter;

public class courses extends AppCompatActivity {
    private static ExpandableListView expandableListView;
    private static ExpandableListAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_courses);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        expandableListView = (ExpandableListView) findViewById(R.id.simple_expandable_listview);

        // Setting group indicator null for custom indicator
        expandableListView.setGroupIndicator(null);

        populateListView();
        setListener();
    }

    private void populateListView() {
        ArrayList<String> headers = new ArrayList<String>();
        headers.add("Under-Graduate Degree Program");
        headers.add("Post-Graduate Degree Program");
        headers.add("PhD Program");
        headers.add("Mulund Centre for Commercial Education (MCCE)");

        ArrayList<String> ug_list= new ArrayList<String>();
        ug_list.add("Bachelor of Commerce (B.Com.)");
        ug_list.add("Bachelor of Management Studies (BMS)");
        ug_list.add("Bachelor of Commerce in Accountancy & Finance (BCAF)");
        ug_list.add("Bachelor of Commerce in Banking & Insurance (BCBI)");
        ug_list.add("Bachelor of Science in Computer Science (B.Sc.Comp.Sci.)");
        ug_list.add("Bachelor of Science in Information Technology (B.Sc.IT)");

        ArrayList<String> pg_list=new ArrayList<String>();
        pg_list.add("Master of Commerce in Accountancy");
        pg_list.add("Master of Commerce in Business Management");
        pg_list.add("Master of Science in Information Technology");
        pg_list.add("Master of Arts In Business Economics");

        ArrayList<String> phd=new ArrayList<String>();
        phd.add("PhD in Commerce with Specialization in Business Economics");

        ArrayList<String> mcce_list=new ArrayList<String>();
        mcce_list.add("Advanced Certification Course in Finance Services (ACCFS, Affiliated to Indian Merchant Chambers)");
        mcce_list.add("Advanced Certification Course in Tax Laws (ACCTL, Affiliated to Indian Merchant Chambers)");
        mcce_list.add("Advanced Certification Course in Foreign Trades (ACCFT, Affiliated to Indian Merchant Chambers)");
        mcce_list.add("Advanced Certification Course in Logistics & Supply Chain (Proposed)");
        mcce_list.add("Practice Session for CPT");

        // Hash map for both header and child
        HashMap<String, List<String>> hashMap = new HashMap<String, List<String>>();

        // Adding header and childs to hash map
        hashMap.put(headers.get(0), ug_list);
        hashMap.put(headers.get(1), pg_list);
        hashMap.put(headers.get(2), phd);
        hashMap.put(headers.get(3), mcce_list);

        adapter = new ExpandableListAdapter(courses.this, headers, hashMap);

        // Setting adpater over expandablelistview
        expandableListView.setAdapter(adapter);
    }

    void setListener(){
        expandableListView.setOnGroupExpandListener(new ExpandableListView.OnGroupExpandListener() {
                    // Default position
                    int previousGroup = -1;

                    @Override
                    public void onGroupExpand(int groupPosition) {
                        if (groupPosition != previousGroup)

                            // Collapse the expanded group
                            expandableListView.collapseGroup(previousGroup);
                        previousGroup = groupPosition;
                    }

                });
    }
}
