package com.example.boyoung.teamproject.Fragment;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ListView;

import com.example.boyoung.teamproject.Activity.BoardActivity;
import com.example.boyoung.teamproject.Dialog.ErrorDialog;
import com.example.boyoung.teamproject.ListAdapter.BoardListAdapter;
import com.example.boyoung.teamproject.Material.Board;
import com.example.boyoung.teamproject.R;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;


public class BoardFragment extends Fragment {
   private ListView boardListView;
   private BoardListAdapter adapter;
   private List<Board> boardList;
    public BoardFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_board, container, false);
        ImageButton write = (ImageButton)v.findViewById(R.id.write);
        write.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DialogFragment myDialogFragment = new ErrorDialog();
                myDialogFragment.setTargetFragment(BoardFragment.this, 0);
                myDialogFragment.show(getFragmentManager(), "Search Filter");
            }
        });
        ImageButton board = (ImageButton)v.findViewById(R.id.boardlist);
        board.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                new BoardListBackground().execute();
            }
        });


        return v;
    }

    class BoardListBackground extends AsyncTask<Void, Void, String> {
        String target;

        @Override
        protected void onPreExecute(){
            target = "http://52.79.231.229/boardlist.php";

        }
        @Override
        protected String doInBackground(Void... voids) {
            try{
                URL url = new URL(target);
                HttpURLConnection httpURLConnection = (HttpURLConnection)url.openConnection();
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
            }catch (Exception e){
                e.printStackTrace();
            }
            return null;
        }

        public void onProgressUpdate(Void... valiues){
            super.onProgressUpdate();
        }

        public void onPostExecute(String result){
            Intent intent = new Intent(getActivity(), BoardActivity.class);
            intent.putExtra("result", result);
            startActivity(intent);
        }
    }


}