package helper;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.mcc.myapplication.R;

import java.util.List;

/**
 * Created by ACER on 02/06/2016.
 */
public class ExamListAdapter extends BaseAdapter {
    private Activity activity;
    private LayoutInflater inflater;
    private List<Exam_model> exam;

    public ExamListAdapter(Activity activity, List<Exam_model> exam) {
        this.activity = activity;
        this.exam = exam;
    }

    @Override
    public int getCount() {
        return exam.size();
    }

    @Override
    public Object getItem(int position) {
        return exam.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (inflater == null)
            inflater = (LayoutInflater) activity
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if (convertView == null)
            convertView = inflater.inflate(R.layout.list_item, null);
        TextView title = (TextView) convertView.findViewById(R.id.name);

        Exam_model m = exam.get(position);
        title.setText(m.getName());

        return convertView;
    }
}
