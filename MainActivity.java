package com.mcc.myapplication;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.widget.TextView;

import com.viewpagerindicator.PageIndicator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    public PageIndicator mIndicator;
    private ViewPager awesomePager;
    private PagerAdapter pm;
    TextView txt_mcc;

    ArrayList<Category> codeCategory;

    String deviceNames[] = { "About Us", "Academic Calendar", "Floor", "Gallery", "Courses", "Activities", "Faculty", "Campus","Map",
            "Social", "Library", "Exam", "Result", "Feedback"};

    int images[] = { R.drawable.abt_64, R.drawable.cal_64,
            R.drawable.floor_64, R.drawable.gallery_64,
            R.drawable.course_64, R.drawable.activity_64,
            R.drawable.faculty_64, R.drawable.campus_64,
            R.drawable.map_64,
            R.drawable.social_64, R.drawable.lib_64,
            R.drawable.exam_64 , R.drawable.result_64, R.drawable.feedback_64};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        awesomePager = (ViewPager) findViewById(R.id.pager);
        mIndicator = (PageIndicator) findViewById(R.id.pagerIndicator);
        txt_mcc=(TextView)findViewById(R.id.txt_mcc);

        Typeface heading = Typeface.createFromAsset(getAssets(),"fonts/cac_champagne.ttf");
        txt_mcc.setTypeface(heading,Typeface.BOLD_ITALIC);

        ArrayList<String> a = new ArrayList<String>();
        ArrayList<Integer> b = new ArrayList<Integer>();
        Category m = new Category();

        for(int i = 0; i < deviceNames.length; i++) {
            a.add(i, deviceNames[i]);
            b.add(i, images[i]);
            m.name = a.get(i);
            m.img_id= b.get(i);
        }

        codeCategory = new ArrayList<Category>();
        codeCategory.add(m);

        Iterator<String> it = a.iterator();
        Iterator<Integer> it1 = b.iterator();
        List<GridFragment> gridFragments = new ArrayList<GridFragment>();
        it = a.iterator();

        int i = 0;
        while(it.hasNext()) {
            ArrayList<GridItems> imLst = new ArrayList<GridItems>();

            GridItems itm = new GridItems(0, it.next(),it1.next());
            imLst.add(itm);
            i = i + 1;

            if(it.hasNext()) {
                GridItems itm1 = new GridItems(1, it.next(),it1.next());
                imLst.add(itm1);
                i = i + 1;
            }

            if(it.hasNext()) {
                GridItems itm2 = new GridItems(2, it.next(),it1.next());
                imLst.add(itm2);
                i = i + 1;
            }

            if(it.hasNext()) {
                GridItems itm3 = new GridItems(3, it.next(),it1.next());
                imLst.add(itm3);
                i = i + 1;
            }

            if(it.hasNext()) {
                GridItems itm4 = new GridItems(4, it.next(),it1.next());
                imLst.add(itm4);
                i = i + 1;
            }

            if(it.hasNext()) {
                GridItems itm5 = new GridItems(5, it.next(),it1.next());
                imLst.add(itm5);
                i = i + 1;
            }

            if(it.hasNext()) {
                GridItems itm6 = new GridItems(6, it.next(),it1.next());
                imLst.add(itm6);
                i = i + 1;
            }

            if(it.hasNext()) {
                GridItems itm7 = new GridItems(7, it.next(),it1.next());
                imLst.add(itm7);
                i = i + 1;
            }

            if(it.hasNext()) {
                GridItems itm8 = new GridItems(8, it.next(),it1.next());
                imLst.add(itm8);
                i = i + 1;
            }

            GridItems[] gp = {};
            GridItems[] gridPage = imLst.toArray(gp);
            gridFragments.add(new GridFragment(gridPage, MainActivity.this));
        }

        pm = new PagerAdapter(getSupportFragmentManager(), gridFragments);
        awesomePager.setAdapter(pm);
        mIndicator.setViewPager(awesomePager);
    }

    private class PagerAdapter extends FragmentStatePagerAdapter {

        private List<GridFragment> fragments;

        public PagerAdapter(FragmentManager fm, List<GridFragment> fragments) {
            super(fm);
            this.fragments = fragments;
        }

        @Override
        public Fragment getItem(int pos) {
            return this.fragments.get(pos);
        }

        @Override
        public int getCount() {
            return this.fragments.size();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }
}
