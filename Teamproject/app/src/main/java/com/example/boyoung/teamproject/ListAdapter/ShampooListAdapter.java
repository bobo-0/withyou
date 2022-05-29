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
import com.example.boyoung.teamproject.Material.Shampoo;

import java.util.List;

/**
 * Created by boyoung on 2017. 11. 25..
 */

public class ShampooListAdapter extends BaseAdapter {

    private Context context;
    private List<Shampoo> shampooList;

    public ShampooListAdapter(Context context, List<Shampoo> shampooList){
        this.context = context;
        this.shampooList = shampooList;
    }


    @Override
    public int getCount() {
        return shampooList.size();
    }

    @Override
    public Object getItem(int i) {
        return shampooList.get(i);
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

        stuffname.setText(shampooList.get(i).getStuffname());
        stuffnum.setText(shampooList.get(i).getStuffname());
        available.setText(shampooList.get(i).getAvailable());
        startdate.setText(shampooList.get(i).getStartdate());
        enddate.setText(shampooList.get(i).getEnddate());

        v.setTag(shampooList.get(i).getStuffnum());

        return v;
    }
}
