package com.example.boyoung.teamproject.ListAdapter;

/**
 * Created by boyoung on 2017. 11. 26..
 */
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.boyoung.teamproject.Material.Charger;
import com.example.boyoung.teamproject.R;

import java.util.List;

/**
 * Created by boyoung on 2017. 11. 25..
 */

public class ChargerListAdapter extends BaseAdapter {

    private Context context;
    private List<Charger> chargerList;

    public ChargerListAdapter(Context context, List<Charger> chargerList){
        this.context = context;
        this.chargerList = chargerList;
    }


    @Override
    public int getCount() {
        return chargerList.size();
    }

    @Override
    public Object getItem(int i) {
        return chargerList.get(i);
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

        stuffname.setText(chargerList.get(i).getStuffname());
        stuffnum.setText(chargerList.get(i).getStuffname());
        available.setText(chargerList.get(i).getAvailable());
        startdate.setText(chargerList.get(i).getStartdate());
        enddate.setText(chargerList.get(i).getEnddate());

        v.setTag(chargerList.get(i).getStuffnum());

        return v;
    }
}
