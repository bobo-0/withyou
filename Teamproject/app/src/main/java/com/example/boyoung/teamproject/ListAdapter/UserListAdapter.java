package com.example.boyoung.teamproject.ListAdapter;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;
import com.example.boyoung.teamproject.R;
import com.example.boyoung.teamproject.Request.DeleteRequest;
import com.example.boyoung.teamproject.Material.User;

import org.json.JSONObject;

import java.util.List;

/**
 * Created by boyoung on 2017. 11. 25..
 */

public class UserListAdapter extends BaseAdapter {

    private Context context;
    private List<User> userList;
    private Activity parentActivity;
    private List<User> saveList;

    public UserListAdapter(Context context, List<User> userList, Activity parentActivity,List<User> saveList){
        this.context = context;
        this.userList = userList;
        this.parentActivity = parentActivity;
        this.saveList = saveList;
    }

    @Override
    public int getCount() {
        return userList.size();
    }

    @Override
    public Object getItem(int i) {
        return userList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(final int i, View view, ViewGroup viewGroup) {
        View v = View.inflate(context, R.layout.user, null);
        final TextView usernum = (TextView) v.findViewById(R.id.usernum);
        TextView password = (TextView) v.findViewById(R.id.password);
        TextView username = (TextView) v.findViewById(R.id.username);
        TextView userphone = (TextView) v.findViewById(R.id.userphone);

        usernum.setText(userList.get(i).getUsernum());
        password.setText(userList.get(i).getPassword());
        username.setText(userList.get(i).getUsername());
        userphone.setText(userList.get(i).getUserphone());

        v.setTag(userList.get(i).getUsernum());

        Button deleteButton = (Button)v.findViewById(R.id.delete);
        deleteButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                Response.Listener<String> responseListener = new Response.Listener<String>(){
                    @Override
                            public void onResponse(String response){
                        try{
                            JSONObject jsonResponse = new JSONObject(response);
                            boolean success = jsonResponse.getBoolean("success");
                            if (success) {
                                userList.remove(i);
                                for(int i=0;i<saveList.size();i++) {
                                    if(saveList.get(i).getUsernum().equals(usernum.getText().toString())){
                                        saveList.remove(i);
                                        break;
                                    }
                                }
                                notifyDataSetChanged();
                            }
                        }catch(Exception e){
                            e.printStackTrace();
                        }

                    }
                };
                DeleteRequest deleteRequest = new DeleteRequest(usernum.getText().toString(),responseListener);
                RequestQueue queue = Volley.newRequestQueue(parentActivity);
                queue.add(deleteRequest);
            }
        });


        return v;
    }
}
