package com.example.boyoung.teamproject.ListAdapter;

/**
 * Created by boyoung on 2017. 11. 26..
 */
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.boyoung.teamproject.R;
import com.example.boyoung.teamproject.Material.Stuff;

import java.util.List;

/**
 * Created by boyoung on 2017. 11. 25..
 */

public class StuffListAdapter extends BaseAdapter {

    private Context context;
    private List<Stuff> stuffList;

    public StuffListAdapter(Context context, List<Stuff> stuffList){
        this.context = context;
        this.stuffList = stuffList;
    }


    @Override
    public int getCount() {
        return stuffList.size();
    }

    @Override
    public Object getItem(int i) {
        return stuffList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(final int i, View view, ViewGroup viewGroup) {
        View v = View.inflate(context, R.layout.stuff, null);
        TextView stuffname = (TextView) v.findViewById(R.id.stuffname);
        TextView stuffnum = (TextView) v.findViewById(R.id.stuffnum);
        TextView available = (TextView) v.findViewById(R.id.stuffavailable);
        TextView startdate = (TextView) v.findViewById(R.id.stuffstart);
        TextView enddate = (TextView) v.findViewById(R.id.stuffend);

        stuffname.setText(stuffList.get(i).getStuffname());
        stuffnum.setText(stuffList.get(i).getStuffname());
        available.setText(stuffList.get(i).getAvailable());
        startdate.setText(stuffList.get(i).getStartdate());
        enddate.setText(stuffList.get(i).getEnddate());

        v.setTag(stuffList.get(i).getStuffnum());

        return v;
    }
}
