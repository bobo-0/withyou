package com.example.boyoung.teamproject.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.example.boyoung.teamproject.ListAdapter.UserListAdapter;
import com.example.boyoung.teamproject.Material.User;
import com.example.boyoung.teamproject.R;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class ManagementActivity extends AppCompatActivity {

    private ListView listView;
    private UserListAdapter adapter;
    private List<User> userList;
    private List<User> saveList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_management);
        Intent intent = getIntent();

        TextView id = (TextView) findViewById(R.id.id);
        String name = intent.getStringExtra("usernum");
        id.setText(name);

        TextView Logout = (TextView) findViewById(R.id.logout);
        Logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ManagementActivity.this, LoginActivity.class);
                ManagementActivity.this.startActivity(intent);

            }
        });


        listView = (ListView)findViewById(R.id.listView);
        userList = new ArrayList<User>();
        saveList = new ArrayList<User>();
        adapter = new UserListAdapter(getApplicationContext(), userList, this,saveList);
        listView.setAdapter(adapter);

        try{
            JSONObject jsonObject = new JSONObject(intent.getStringExtra("userList"));
            JSONArray jsonArray = jsonObject.getJSONArray("response");
            int count=0;
            String usernum, password, username, userphone;
            while(count<jsonArray.length()){
                JSONObject object = jsonArray.getJSONObject(count);
                usernum = object.getString("usernum");
                password = object.getString("password");
                username = object.getString("username");
                userphone = object.getString("userphone");
                User user = new User(usernum, password, username, userphone);
                if(!usernum.equals("admin")){
                    userList.add(user);
                    saveList.add(user);
                }

                count++;
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        EditText search = (EditText) findViewById(R.id.search);
        search.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                //텍스트가 바뀔 때 마다 실행
                searchUser(charSequence.toString());
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
    }

    public void searchUser(String search){
        userList.clear();
        for(int i=0; i<saveList.size();i++){
            if(saveList.get(i).getUsernum().contains(search)){
                userList.add(saveList.get(i));
            }
        }
        adapter.notifyDataSetChanged();
    }

}
