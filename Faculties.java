package com.mcc.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ExpandableListView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import helper.ExpandableListAdapter;

public class Faculties extends AppCompatActivity {
    private static ExpandableListView expandableListView;
    private static ExpandableListAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_faculties);
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
        headers.add("Departments of Economics");
        headers.add("Departments of Accountancy");
        headers.add("Departments of Maths and Statistics");
        headers.add("Department of English");
        headers.add("Department of Commerce");
        headers.add("Department of Environment Studies");
        headers.add("Department of Business Law");
        headers.add("Department of Physical Education Sports");
        headers.add("Department of BCAF/BCBI");
        headers.add("Department of BMS");
        headers.add("Department of BCFM");
        headers.add("Department of B.Sc. Computer Science");
        headers.add("Department of B.Sc. Information Technology");

        ArrayList<String> eco= new ArrayList<String>();
        eco.add("Dr. (Mrs.) Parvathi Venkatesh");
        eco.add("Mrs. C. K. Kaul");
        eco.add("Shri. S. A. Pawar");
        eco.add("Dr. Arjun Lakhe");

        ArrayList<String> acc=new ArrayList<String>();
        acc.add("Shri. P. V. Lele");
        acc.add("Shri. Nikhil Karkhanis");
        acc.add("Mrs. Riya R. Dhamapurkar");

        ArrayList<String> ms=new ArrayList<String>();
        ms.add("Dr. V. M. Sarode");
        ms.add("Shri B. Seshadri");
        ms.add("Dr. K. G. Rajan");

        ArrayList<String> eng=new ArrayList<String>();
        eng.add("Ms. Shayeree Ghosh");
        eng.add("Shri Jayanta A. Ghorpade");
        eng.add("Shri Nitin Lalsare");

        ArrayList<String> com = new ArrayList<String>();
        com.add("Dr. (Mrs.) A. P. Kulkarni");
        com.add("Shri S. V. Rane");
        com.add("Mrs. Anuradha Ganesh");
        com.add("Ms. Sulbha Kamble");

        ArrayList<String> evs= new ArrayList<String>();
        evs.add("Shri Amit Yadav");

        ArrayList<String> bl= new ArrayList<String>();
        bl.add("Dr. Pramila D’souza");

        ArrayList<String> sports= new ArrayList<String>();
        sports.add("Dr. B. D. Salvi");

        ArrayList<String> af=new ArrayList<String>();
        af.add("Mrs. Shilpa Thakur");
        af.add("Dr. Rajashree Deshpande");
        af.add("Ms. Alpa Katira");
        af.add("Ms. Archana Kadam");
        af.add("Mr. Vinay Gudi");
        af.add("Mr. Nitin Pawar");
        af.add("Mrs. Seema Atharde");

        ArrayList<String> bms= new ArrayList<String>();
        bms.add("Mrs. Viji Kannan");
        bms.add("Mrs. Seema Ashar");
        bms.add("Mrs. Kanchana Sattur");
        bms.add("Mrs. Radhika Dalal");

        ArrayList<String> fm= new ArrayList<String>();
        fm.add("Mrs. Shilpa Thakur");
        fm.add("Mrs. Vinaya Marathe");
        fm.add("Mr. Shreevallaban Narayaanan");
        fm.add("Mrs. Swamini Sabnis");

        ArrayList<String> cs= new ArrayList<String>();
        cs.add("Mrs. Reena Nagda");
        cs.add("Mrs. Shylashree Dev");
        cs.add("Mrs. Pooja Patil");
        cs.add("Mrs. Vaishanvi Assar");

        ArrayList<String> it= new ArrayList<String>();
        it.add("Mr. Hiren Dand");
        it.add("Mrs. Jyotika Chheda");
        it.add("Ms. Priti Pathak");
        it.add("Mrs. Samruddhi Kotibhaskar");
        it.add("Mr. Vishal Borude");
        it.add("Mr. Jojan Mathai");

        // Hash map for both header and child
        HashMap<String, List<String>> hashMap = new HashMap<String, List<String>>();

        // Adding header and childs to hash map
        hashMap.put(headers.get(0), eco);
        hashMap.put(headers.get(1), acc);
        hashMap.put(headers.get(2), ms);
        hashMap.put(headers.get(3), eng);
        hashMap.put(headers.get(4),com);
        hashMap.put(headers.get(5),evs);
        hashMap.put(headers.get(6),bl);
        hashMap.put(headers.get(7),sports);
        hashMap.put(headers.get(8),af);
        hashMap.put(headers.get(9),bms);
        hashMap.put(headers.get(10),fm);
        hashMap.put(headers.get(11),cs);
        hashMap.put(headers.get(12),it);

        adapter = new ExpandableListAdapter(Faculties.this, headers, hashMap);

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
