package com.example.boyoung.teamproject.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import com.example.boyoung.teamproject.ListAdapter.BoardListAdapter;
import com.example.boyoung.teamproject.Material.Board;
import com.example.boyoung.teamproject.R;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class BoardActivity extends AppCompatActivity {

    private ListView listView;
    private BoardListAdapter adapter;
    private List<Board> boardList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_board);
        Intent intent = getIntent();

        listView = (ListView)findViewById(R.id.boardlistView);
        boardList = new ArrayList<Board>();
        adapter = new BoardListAdapter(getApplicationContext(), boardList);
        listView.setAdapter(adapter);

        try{
            JSONObject jsonObject = new JSONObject(intent.getStringExtra("result"));
            JSONArray jsonArray = jsonObject.getJSONArray("response");
            int count=0;
            String postnum, name, title, content, date;
            while(count<jsonArray.length()){
                JSONObject object = jsonArray.getJSONObject(count);
                postnum = object.getString("postnum");
                name = object.getString("name");
                title = object.getString("title");
                content = object.getString("content");
                date = object.getString("date");
                Board board = new Board(postnum, name, title, content, date);
                boardList.add(board);

                count++;
            }
        }catch (Exception e){
            e.printStackTrace();
        }


    }


}
