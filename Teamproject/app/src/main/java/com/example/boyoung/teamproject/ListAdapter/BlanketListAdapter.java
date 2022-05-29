package com.example.boyoung.teamproject.ListAdapter;

/**
 * Created by boyoung on 2017. 11. 26..
 */
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.boyoung.teamproject.Material.Blanket;
import com.example.boyoung.teamproject.R;

import java.util.List;

/**
 * Created by boyoung on 2017. 11. 25..
 */

public class BlanketListAdapter extends BaseAdapter {

    private Context context;
    private List<Blanket> blanketList;

    public BlanketListAdapter(Context context, List<Blanket> blanketList){
        this.context = context;
        this.blanketList = blanketList;
    }


    @Override
    public int getCount() {
        return blanketList.size();
    }

    @Override
    public Object getItem(int i) {
        return blanketList.get(i);
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

        stuffname.setText(blanketList.get(i).getStuffname());
        stuffnum.setText(blanketList.get(i).getStuffname());
        available.setText(blanketList.get(i).getAvailable());
        startdate.setText(blanketList.get(i).getStartdate());
        enddate.setText(blanketList.get(i).getEnddate());

        v.setTag(blanketList.get(i).getStuffnum());

        return v;
    }
}
