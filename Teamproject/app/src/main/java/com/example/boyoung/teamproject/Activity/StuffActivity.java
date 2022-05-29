package com.example.boyoung.teamproject.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import com.example.boyoung.teamproject.ListAdapter.StuffListAdapter;
import com.example.boyoung.teamproject.Material.Stuff;
import com.example.boyoung.teamproject.R;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;


public class StuffActivity extends AppCompatActivity {

    String usernum;
    private ListView listView;
    private StuffListAdapter adapter;
    private List<Stuff> stuffList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stuff);
        Intent intent = getIntent();

        TextView Logout = (TextView) findViewById(R.id.logout);
        Logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(StuffActivity.this, LoginActivity.class);
                StuffActivity.this.startActivity(intent);

            }
        });

        listView = (ListView)findViewById(R.id.listView);
        stuffList = new ArrayList<Stuff>();
        adapter = new StuffListAdapter(getApplicationContext(), stuffList);
        listView.setAdapter(adapter);

        try{
            JSONObject jsonObject = new JSONObject(intent.getStringExtra("stuffList"));
            JSONArray jsonArray = jsonObject.getJSONArray("response");
            int count=0;
            String stuffname, stuffnum, available, startdate, enddate;
            while(count<jsonArray.length()){
                JSONObject object = jsonArray.getJSONObject(count);
                stuffname = object.getString("stuffname");
                stuffnum = object.getString("stuffnum");
                available = object.getString("available");
                startdate = object.getString("startdate");
                enddate = object.getString("enddate");

                Stuff stuff = new Stuff(stuffname,stuffnum,available,startdate,enddate);
                stuffList.add(stuff);

                count++;
            }
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
