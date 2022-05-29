package com.example.boyoung.teamproject.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;
import com.example.boyoung.teamproject.R;
import com.example.boyoung.teamproject.Request.LoginRequest;
import org.json.JSONObject;

public class LoginActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        ImageView logo = (ImageView)findViewById(R.id.logo);

        final EditText idText = (EditText) findViewById(R.id.editText1);
        final EditText passwordText = (EditText) findViewById(R.id.editText2);

        final Button loginButton = (Button) findViewById(R.id.login);
        final TextView registerButton = (TextView) findViewById(R.id.signin);

        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent registerIntent = new Intent(LoginActivity.this, RegisterActivity.class);
                LoginActivity.this.startActivity(registerIntent);
            }
        });

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String usernum = idText.getText().toString();
                final String userPassword = passwordText.getText().toString();

                Response.Listener<String> responseListener = new Response.Listener<String>(){
                    public void onResponse(String reponse){
                        try{
                            JSONObject jsonResponse = new JSONObject(reponse);
                            boolean success = jsonResponse.getBoolean("success");
                            if(success){
                                String usernum = jsonResponse.getString("usernum");
                                String userPassword = jsonResponse.getString("password");
                                    Intent intent = new Intent(LoginActivity.this, HomeActivity.class);
                                    intent.putExtra("usernum",usernum);
                                    intent.putExtra("password",userPassword);
                                    LoginActivity.this.startActivity(intent);

                            }else{
                                AlertDialog.Builder builder = new AlertDialog.Builder(LoginActivity.this);
                                builder.setMessage("Fail to login").setNegativeButton("Retry",null).create().show();
                            }
                        }catch(Exception e){
                            e.printStackTrace();
                        }
                    }
                };
                LoginRequest loginRequest = new LoginRequest(usernum, userPassword,responseListener);
                RequestQueue queue = Volley.newRequestQueue(LoginActivity.this);
                queue.add(loginRequest);
            }
        });

    }

}