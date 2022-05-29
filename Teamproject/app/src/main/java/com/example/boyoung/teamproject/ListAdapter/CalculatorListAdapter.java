package com.example.boyoung.teamproject.ListAdapter;

/**
 * Created by boyoung on 2017. 11. 26..
 */
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.boyoung.teamproject.Material.Calculator;
import com.example.boyoung.teamproject.R;

import java.util.List;

/**
 * Created by boyoung on 2017. 11. 25..
 */

public class CalculatorListAdapter extends BaseAdapter {

    private Context context;
    private List<Calculator> calculatorList;

    public CalculatorListAdapter(Context context, List<Calculator> calculatorList){
        this.context = context;
        this.calculatorList = calculatorList;
    }


    @Override
    public int getCount() {
        return calculatorList.size();
    }

    @Override
    public Object getItem(int i) {
        return calculatorList.get(i);
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

        stuffname.setText(calculatorList.get(i).getStuffname());
        stuffnum.setText(calculatorList.get(i).getStuffname());
        available.setText(calculatorList.get(i).getAvailable());
        startdate.setText(calculatorList.get(i).getStartdate());
        enddate.setText(calculatorList.get(i).getEnddate());

        v.setTag(calculatorList.get(i).getStuffnum());

        return v;
    }
}
