package com.example.yhussein.helloworld;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import static java.util.Calendar.MONTH;

public class ProfileFragment extends Fragment {

    TextView thanks;
    TextView profilename;
    TextView profileage;
    TextView profilejob;
    TextView profileinfo;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_home, container, false);


        TextView thanks = view.findViewById(R.id.thanks);
        TextView profilename = view.findViewById(R.id.nametwo);
        TextView profileage = view.findViewById(R.id.agetwo);
        TextView profilejob = view.findViewById(R.id.jobtwo);
        TextView profileinfo = view.findViewById(R.id.descriptiontwo);

        //set text
        thanks.setText(getString(R.string.thanks) + " " +((StartActivity)getActivity()).username+"!");
        profilename.setText(getString(R.string.proname) +((StartActivity)getActivity()).name);
        profileage.setText(getString(R.string.proage) + ((StartActivity)getActivity()).age);
        profilejob.setText(getString(R.string.projob) + ((StartActivity)getActivity()).job);
        profileinfo.setText(getString(R.string.prodescription) + ((StartActivity)getActivity()).info);

        return view;
    }


}
