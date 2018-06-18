package com.mcc.myapplication;


import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;


public class GridFragment extends android.support.v4.app.Fragment {
    private GridView mGridView;
    private GridAdapter mGridAdapter;
    GridItems[] gridItems = {};
    private Activity activity;
    public Context context;

    public GridFragment() {

    }

    public GridFragment(GridItems[] gridItems, Activity activity) {
        this.gridItems = gridItems;
        this.activity = activity;
    }

    @Override
    public View onCreateView(LayoutInflater inflater,
                             @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view;

        view = inflater.inflate(R.layout.grid, container, false);

        mGridView = (GridView) view.findViewById(R.id.grid_view);

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        if(activity != null) {

            mGridAdapter = new GridAdapter(activity, gridItems);

            if(mGridView != null){
                mGridView.setAdapter(mGridAdapter);
            }

            mGridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

                @Override
                public void onItemClick(AdapterView<?> parent, View view,
                                        int pos, long id) {

                    onGridItemClick((GridView) parent, view, pos, id);
                }
            });
        }
    }

    public void onGridItemClick(GridView g, View v, int pos, long id) {
        Toast.makeText(
                activity,
                "You have Clicked: " + gridItems[pos].title, Toast.LENGTH_LONG).show();

        switch (pos){
            case 0:
                if(gridItems[pos].title=="About Us") {
                    Intent i1 = new Intent(v.getContext(), about_us.class);
                    startActivity(i1);
                }
                else
                {
                    startActivity(new Intent(v.getContext(), social_page.class));
                }
                break;
            case 1:
                if(gridItems[pos].title=="Academic Calendar") {
                    startActivity(new Intent (v.getContext(),academic_cal.class));
                }
                else {
                    Intent i2 = new Intent(v.getContext(), library.class);
                    startActivity(i2);
                }
                break;
            case 2:
                if(gridItems[pos].title=="Floor") {
                    Intent i11=new Intent(v.getContext(),Floor_info.class);
                    startActivity(i11);
                }
                else
                {
                    startActivity(new Intent(v.getContext(), exam.class));
                }
                break;
            case 3:
                if(gridItems[pos].title=="Gallery") {

                    Integer[] images={R.drawable.mcc,R.drawable.b,
                    R.drawable.c, R.drawable.d,
                    R.drawable.e, R.drawable.f, R.drawable.g};
                    Intent intent = new Intent(v.getContext(), galleries.class);
                    intent.putExtra(galleries.EXTRA_NAME, images);
                    startActivity(intent);
                }
                else {
                    startActivity(new Intent(v.getContext(),results.class));
                }
                break;
            case 4:
                if(gridItems[pos].title=="Courses") {
                    Intent i4= new Intent(v.getContext(),courses.class);
                    startActivity(i4);
                }
                else {
                    startActivity(new Intent(v.getContext(),feedback_form.class));
                }
                break;
            case 5:
                if(gridItems[pos].title=="Activities") {
                    startActivity(new Intent(v.getContext(),activities.class));
                }
                break;
            case 6:
                if(gridItems[pos].title=="Faculty") {
                    Intent i6=new Intent(v.getContext(),Faculties.class);
                    startActivity(i6);
                }
                break;
            case 7:
                if(gridItems[pos].title=="Campus") {
                    startActivity(new Intent(v.getContext(),campus.class));
                }
                break;
            case 8:
                if(gridItems[pos].title=="Map") {
                    startActivity(new Intent(v.getContext(), MapsActivity.class));
                }
                break;
        }
    }
}
