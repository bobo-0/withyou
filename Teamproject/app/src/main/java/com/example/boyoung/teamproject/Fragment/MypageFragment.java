package com.example.boyoung.teamproject.Fragment;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import com.example.boyoung.teamproject.Activity.ManagementActivity;
import com.example.boyoung.teamproject.R;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;


public class MypageFragment extends Fragment {


    public MypageFragment() {
        // Required empty public constructor
    }
    private boolean CheckUser(){
        Intent intent = getActivity().getIntent();
        String usernum = intent.getStringExtra("usernum");
        if(!usernum.equals("admin")){
            return true;
        }else{
            return false;
        }
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment

        View v = inflater.inflate(R.layout.fragment_mypage, container, false);
        CheckUser();
        ImageButton list = (ImageButton)v.findViewById(R.id.list);
        list.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new BackgroundTask().execute();
            }
        });


        if(CheckUser()){
            list.setVisibility(View.GONE);
        }

        return v;
    }

    class BackgroundTask extends AsyncTask<Void, Void, String> {
                    String target;

                    protected void onPreExecute(){
                        target = "http://52.79.231.229/list.php";
                    }
                    @Override
                    protected String doInBackground(Void... voids) {
                        try{
                            URL url = new URL(target);
                            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();

                            InputStream inputStream = httpURLConnection.getInputStream();
                            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

                            String temp;
                            StringBuilder stringBuilder = new StringBuilder();
                            while((temp=bufferedReader.readLine())!=null){
                                stringBuilder.append(temp+"\n");
                            }
                            bufferedReader.close();
                            inputStream.close();
                            httpURLConnection.disconnect();
                            return stringBuilder.toString().trim();
                        }catch(Exception e){
                            e.printStackTrace();
                        }
                        return null;
                    }

                    @Override
                    public void onProgressUpdate(Void... values){
                        super.onProgressUpdate(values);
                    }

                    @Override
                    public void onPostExecute(String result){
                        Intent intent = new Intent(getActivity(), ManagementActivity.class);
                        intent.putExtra("userList", result);
                        startActivity(intent);
                    }

            }
}