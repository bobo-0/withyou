package com.example.boyoung.teamproject.Activity;

import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;
import com.example.boyoung.teamproject.R;
import com.example.boyoung.teamproject.Request.PostRequest;

import org.json.JSONException;
import org.json.JSONObject;

public class PostActivity extends AppCompatActivity {
    private AlertDialog dialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        final EditText Post = (EditText) findViewById(R.id.postnumText);
        final EditText Wname = (EditText) findViewById(R.id.nameText);
        final EditText Wtitle = (EditText) findViewById(R.id.titleText);
        final EditText Wcontent = (EditText) findViewById(R.id.contentText);
        final EditText Wdate = (EditText) findViewById(R.id.dateText);


        Button registerButton = (Button) findViewById(R.id.registerButton);
        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String postnum = Post.getText().toString();
                String name = Wname.getText().toString();
                String title = Wtitle.getText().toString();
                String content= Wcontent.getText().toString();
                String date = Wdate.getText().toString() ;


                if(postnum.equals("")||name.equals("")||title.equals("")||content.equals("")||date.equals("")){
                    AlertDialog.Builder builder = new AlertDialog.Builder(PostActivity.this);
                    dialog = builder.setMessage("There is empty place").setNegativeButton("OK",null).create();
                    dialog.show();
                    return;
                }
                Response.Listener<String> responseListener = new Response.Listener<String>(){
                    public void onResponse(String response){
                        try{
                            JSONObject jsonResponse = new JSONObject(response);
                            boolean success = jsonResponse.getBoolean("success");
                            if (success) {
                                AlertDialog.Builder builder = new AlertDialog.Builder(PostActivity.this);
                                dialog = builder.setMessage("Success to Register").setNegativeButton("OK",null).create();
                                dialog.show();
                                finish();
                            }else{
                                AlertDialog.Builder builder = new AlertDialog.Builder(PostActivity.this);
                                dialog = builder.setMessage("Register Failed")
                                        .setNegativeButton("Ok",null)
                                        .create();
                                dialog.show();
                            }
                        }catch(JSONException e){
                            e.printStackTrace();
                        }
                    }
                };

                PostRequest postRequest = new PostRequest(postnum, name,title, content,date, responseListener);
                RequestQueue queue = Volley.newRequestQueue(PostActivity.this);
                queue.add(postRequest);
            }
        });

    }
    protected void onStop(){
        super.onStop();
        if(dialog!=null){
            dialog.dismiss();
            dialog=null;
        }
    }
}
