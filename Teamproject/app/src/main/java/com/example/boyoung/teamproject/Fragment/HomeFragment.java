package com.example.boyoung.teamproject.Fragment;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import com.example.boyoung.teamproject.Activity.StuffActivity;
import com.example.boyoung.teamproject.R;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;


public class HomeFragment extends Fragment {

    private ImageButton mat, charger, blanket, shampoo, calculator, umbrella;
    private String usernum;


    public HomeFragment() {
        // Required empty public constructor
    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

//    private boolean CheckUser(){
//        Intent intent = getActivity().getIntent();
//        String usernum = intent.getStringExtra("usernum");
//        if(!usernum.equals("admin")){
//            return true;
//        }else{
//            return false;
//        }
//    }
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);

//        CheckUser();


//            if(CheckUser()) {
                //managementButton.setVisibility(View.GONE);
        mat = (ImageButton) view.findViewById(R.id.imageButton1);
        mat.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                new MatBackground().execute();
            }
        });
        charger = (ImageButton) view.findViewById(R.id.imageButton2);
        charger.setOnClickListener(new View.OnClickListener(){

            public void onClick(View v) {
                new ChargerBackground().execute();
            }

        });
        blanket = (ImageButton) view.findViewById(R.id.imageButton3);
        blanket.setOnClickListener(new View.OnClickListener(){

            public void onClick(View v) {
                new BlanketBackground().execute();
            }

        });
        shampoo = (ImageButton) view.findViewById(R.id.imageButton4);
        shampoo.setOnClickListener(new View.OnClickListener(){

            public void onClick(View v) {
                new ShampooBackground().execute();
            }

        });
        calculator = (ImageButton) view.findViewById(R.id.imageButton5);
        calculator.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                new CalculatorBackground().execute();
            }
        });
        umbrella = (ImageButton) view.findViewById(R.id.imageButton6);
        umbrella.setOnClickListener(new View.OnClickListener(){

            public void onClick(View v) {
                new UmbrellaBackground().execute();
            }

        });
                return view;
//            }else{
//                class BackgroundTask extends AsyncTask<Void, Void, String> {
//                    String target;
//
//                    protected void onPreExecute(){
//                        target = "http://52.79.231.229/list.php";
//                    }
//                    @Override
//                    protected String doInBackground(Void... voids) {
//                        try{
//                            URL url = new URL(target);
//                            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
//
//                            InputStream inputStream = httpURLConnection.getInputStream();
//                            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
//
//                            String temp;
//                            StringBuilder stringBuilder = new StringBuilder();
//                            while((temp=bufferedReader.readLine())!=null){
//                                stringBuilder.append(temp+"\n");
//                            }
//                            bufferedReader.close();
//                            inputStream.close();
//                            httpURLConnection.disconnect();
//                            return stringBuilder.toString().trim();
//                        }catch(Exception e){
//                            e.printStackTrace();
//                        }
//                        return null;
//                    }
//
//                    @Override
//                    public void onProgressUpdate(Void... values){
//                        super.onProgressUpdate(values);
//                    }
//
//                    @Override
//                    public void onPostExecute(String result){
//                        Intent intent = new Intent(getActivity(), ManagementActivity.class);
//                        intent.putExtra("userList", result);
//                        startActivity(intent);
//                    }
//                }
//                bt1 = (ImageButton) view.findViewById(R.id.imageButton1);
//                bt1.setOnClickListener(new View.OnClickListener() {
//
//                    public void onClick(View v) {
//                        new BackgroundTask().execute();
//                    }
//                });
//                return view;
//            }

    }
    class MatBackground extends AsyncTask<Void, Void, String> {
        String target;

        protected void onPreExecute(){
            target = "http://52.79.231.229/matlist.php";
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
            Intent intent = new Intent(getActivity(), StuffActivity.class);
            intent.putExtra("usernum",usernum);
            intent.putExtra("stuffList", result);
            startActivity(intent);
        }
    }
    class ChargerBackground extends AsyncTask<Void, Void, String> {
        String target;

        protected void onPreExecute(){
            target = "http://52.79.231.229/chargerlist.php";
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
            Intent intent = new Intent(getActivity(), StuffActivity.class);
            intent.putExtra("usernum",usernum);
            intent.putExtra("stuffList", result);
            startActivity(intent);
        }
    }

    class BlanketBackground extends AsyncTask<Void, Void, String> {
        String target;

        protected void onPreExecute(){
            target = "http://52.79.231.229/blanketlist.php";
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
            Intent intent = new Intent(getActivity(), StuffActivity.class);
            intent.putExtra("usernum",usernum);
            intent.putExtra("stuffList", result);
            startActivity(intent);
        }
    }
    class ShampooBackground extends AsyncTask<Void, Void, String> {
        String target;

        protected void onPreExecute(){
            target = "http://52.79.231.229/shampoolist.php";
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
            Intent intent = new Intent(getActivity(), StuffActivity.class);
            intent.putExtra("usernum",usernum);
            intent.putExtra("stuffList", result);
            startActivity(intent);
        }
    }
    class CalculatorBackground extends AsyncTask<Void, Void, String> {
        String target;

        protected void onPreExecute(){
            target = "http://52.79.231.229/calculatorlist.php";
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
            Intent intent = new Intent(getActivity(), StuffActivity.class);
            intent.putExtra("usernum",usernum);
            intent.putExtra("stuffList", result);
            startActivity(intent);
        }
    }
    class UmbrellaBackground extends AsyncTask<Void, Void, String> {
        String target;

        protected void onPreExecute(){
            target = "http://52.79.231.229/umbrellalist.php";
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
            Intent intent = new Intent(getActivity(), StuffActivity.class);
            intent.putExtra("usernum",usernum);
            intent.putExtra("stuffList", result);
            startActivity(intent);
        }
    }

}

