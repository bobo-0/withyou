package com.example.boyoung.teamproject.Dialog;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.LinearLayout;

import com.example.boyoung.teamproject.Activity.HomeActivity;
import com.example.boyoung.teamproject.R;

public class ErrorDialog extends DialogFragment {
    View view;

    public Dialog onCreateDialog(Bundle savedInstanceState) {
        view = getActivity().getLayoutInflater().inflate(R.layout.dialog_error, new LinearLayout(getActivity()), false);

        Dialog builder = new Dialog(getActivity());
        builder.getWindow().requestFeature(Window.FEATURE_NO_TITLE);
        builder.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_LAYOUT_IN_SCREEN);
        builder.setContentView(view);
        builder.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

        Button home = (Button)view.findViewById(R.id.ok);
        home.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(), HomeActivity.class);
                startActivity(intent);
            }});
        return builder;
    }
}