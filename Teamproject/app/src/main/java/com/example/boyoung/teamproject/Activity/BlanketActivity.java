package com.example.boyoung.teamproject.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import com.example.boyoung.teamproject.ListAdapter.BlanketListAdapter;
import com.example.boyoung.teamproject.Material.Blanket;
import com.example.boyoung.teamproject.R;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;


public class BlanketActivity extends AppCompatActivity {

    String usernum;
    private ListView listView;
    private BlanketListAdapter adapter;
    private List<Blanket> blanketList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stuff);
        Intent intent = getIntent();

        TextView Logout = (TextView) findViewById(R.id.logout);
        Logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(BlanketActivity.this, LoginActivity.class);
                BlanketActivity.this.startActivity(intent);

            }
        });

        listView = (ListView)findViewById(R.id.listView);
        blanketList = new ArrayList<Blanket>();
        adapter = new BlanketListAdapter(getApplicationContext(), blanketList);
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

                Blanket blanket = new Blanket(stuffname,stuffnum,available,startdate,enddate);
                blanketList.add(blanket);

                count++;
            }
        }catch (Exception e){
            e.printStackTrace();
        }

    }


}
