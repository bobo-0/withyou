package com.example.boyoung.teamproject.Activity;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.boyoung.teamproject.Fragment.BoardFragment;
import com.example.boyoung.teamproject.Fragment.ChattingFragment;
import com.example.boyoung.teamproject.Fragment.HomeFragment;
import com.example.boyoung.teamproject.Fragment.MypageFragment;
import com.example.boyoung.teamproject.Fragment.SettingFragment;
import com.example.boyoung.teamproject.R;
import com.roughike.bottombar.BottomBar;
import com.roughike.bottombar.OnTabSelectListener;

public class HomeActivity extends FragmentActivity {
    String usernum;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        TextView id = (TextView) findViewById(R.id.id);
        Intent intent = getIntent();
        usernum = intent.getStringExtra("usernum");

        id.setText(usernum);

        TextView Logout = (TextView) findViewById(R.id.logout);
        Logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomeActivity.this, LoginActivity.class);
                HomeActivity.this.startActivity(intent);

            }
        });

        final LinearLayout notice = (LinearLayout)findViewById(R.id.notice);
        //bottom tool bar
        final BottomBar bottomBar = (BottomBar) findViewById(R.id.bottomBar);
        bottomBar.setOnTabSelectListener(new OnTabSelectListener() {
            @Override
            public void onTabSelected(@IdRes int tabId) {


                if(tabId == R.id.home){
                    FragmentManager fragmentManager = getSupportFragmentManager();
                    FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
                    notice.setVisibility(View.GONE);
                    fragmentTransaction.replace(R.id.contentContainer, new HomeFragment());
                    fragmentTransaction.commit();
                    Intent intent = new Intent(HomeActivity.this, HomeFragment.class);
                    intent.putExtra("usernum",usernum);
                }

                else if(tabId == R.id.board){
                    FragmentManager fragmentManager = getSupportFragmentManager();
                    FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
                    notice.setVisibility(View.GONE);
                    fragmentTransaction.replace(R.id.contentContainer, new BoardFragment());
                    fragmentTransaction.commit();
                    Intent intent = new Intent(HomeActivity.this, BoardFragment.class);
                    intent.putExtra("usernum",usernum);
                }

                else if(tabId == R.id.mypage){
                    FragmentManager fragmentManager = getSupportFragmentManager();
                    FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();

                    fragmentTransaction.replace(R.id.contentContainer, new MypageFragment());
                    fragmentTransaction.commit();
                }

                else if(tabId == R.id.chatting){
                    FragmentManager fragmentManager = getSupportFragmentManager();
                    FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();

                    fragmentTransaction.replace(R.id.contentContainer, new ChattingFragment());
                    fragmentTransaction.commit();
                }

                else if(tabId == R.id.setting){
                    FragmentManager fragmentManager = getSupportFragmentManager();
                    FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();

                    fragmentTransaction.replace(R.id.contentContainer, new SettingFragment());
                    fragmentTransaction.commit();
                }
            }
        });
    }

    public void initFragment(){
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.add(R.id.contentContainer, new HomeFragment());
        transaction.addToBackStack(null);
        transaction.commit();
    }

}