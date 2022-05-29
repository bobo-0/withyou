package com.example.boyoung.teamproject.ListAdapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.boyoung.teamproject.Material.Board;
import com.example.boyoung.teamproject.R;

import java.util.List;

/**
 * Created by boyoung on 2017. 11. 27..
 */

public class BoardListAdapter extends BaseAdapter {
    private Context context;
    private List<Board> boardList;

    public BoardListAdapter(Context context, List<Board> boardList) {
        this.context = context;
        this.boardList = boardList;
    }

    @Override
    public int getCount() {
        return boardList.size();
    }

    @Override
    public Object getItem(int i) {
        return boardList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View v = View.inflate(context, R.layout.board,null);
        TextView postnum = (TextView)v.findViewById(R.id.postnum);
        TextView nameText = (TextView)v.findViewById(R.id.nameText);
        TextView titleText = (TextView)v.findViewById(R.id.titleText);
        TextView contentText = (TextView)v.findViewById(R.id.contentText);
        TextView dateText = (TextView)v.findViewById(R.id.dateText);

        postnum.setText(boardList.get(i).getPostnum());
        nameText.setText(boardList.get(i).getName());
        titleText.setText(boardList.get(i).getTitle());
        contentText.setText(boardList.get(i).getContent());
        dateText.setText(boardList.get(i).getDate());

        v.setTag(boardList.get(i).getPostnum());
        return v;
    }


;}
