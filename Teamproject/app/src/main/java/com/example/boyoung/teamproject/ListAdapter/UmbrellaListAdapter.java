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
import com.example.boyoung.teamproject.Material.Umbrella;

import java.util.List;

/**
 * Created by boyoung on 2017. 11. 25..
 */

public class UmbrellaListAdapter extends BaseAdapter {

    private Context context;
    private List<Umbrella> umbrellaList;

    public UmbrellaListAdapter(Context context, List<Umbrella> umbrellaList){
        this.context = context;
        this.umbrellaList = umbrellaList;
    }


    @Override
    public int getCount() {
        return umbrellaList.size();
    }

    @Override
    public Object getItem(int i) {
        return umbrellaList.get(i);
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

        stuffname.setText(umbrellaList.get(i).getStuffname());
        stuffnum.setText(umbrellaList.get(i).getStuffname());
        available.setText(umbrellaList.get(i).getAvailable());
        startdate.setText(umbrellaList.get(i).getStartdate());
        enddate.setText(umbrellaList.get(i).getEnddate());

        v.setTag(umbrellaList.get(i).getStuffnum());

        return v;
    }
}
