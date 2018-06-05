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
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import static java.util.Calendar.MONTH;

public class ProfileFragment extends Fragment {

    private EditText nameET;
    private EditText emailET;
    private EditText usernameET;
    private EditText ageET;
    private EditText dobET;
    private EditText jobET;
    private EditText descriptionET;
    private Button submitBtn;
    private ViewGroup viewGroup;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_main, container, false);

        //init
        nameET =  view.findViewById(R.id.name);
        emailET =  view.findViewById(R.id.email);
        usernameET =  view.findViewById(R.id.username);
        ageET =  view.findViewById(R.id.age);
        dobET = view.findViewById(R.id.dob);
        jobET = view.findViewById(R.id.job);
        descriptionET = view.findViewById(R.id.description);
        submitBtn = view.findViewById(R.id.submitBtn);
        viewGroup = view.findViewById(R.id.form);

        submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onSubmit(v);
            }
        });


        return view;
    }

    public void onSubmit(View view) {
        //validate date
        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
        String dateStr = dobET.getText().toString();
        try
        {
            Date dob = sdf.parse(dateStr);
            Date now = new Date();
            int years = getDiffYears(dob, now);
            if(years < 18)
            {
                Toast.makeText(getActivity(), R.string.doberr, Toast.LENGTH_LONG).show();
                return;
            }

        }
        catch (Exception e)
        {
            Toast.makeText(getActivity(), R.string.dobmsg, Toast.LENGTH_LONG).show();
            return;
        }

        //gets username
        String username = usernameET.getText().toString();
        if(username.length() == 0)
        {
            Toast.makeText(getActivity(), R.string.usernameerror, Toast.LENGTH_LONG).show();
            return;
        }

        //gets name
        String name = nameET.getText().toString();
        if(name.length() == 0)
        {
            Toast.makeText(getActivity(), R.string.nameerror, Toast.LENGTH_LONG).show();
            return;
        }

        //gets age
        String age = ageET.getText().toString();
        String job = jobET.getText().toString();
        if(job.length() == 0)
        {
            Toast.makeText(getActivity(), R.string.joberror, Toast.LENGTH_LONG).show();
            return;
        }

        String description = jobET.getText().toString();
        if(job.length() == 0)
        {
            Toast.makeText(getActivity(), R.string.descripterror, Toast.LENGTH_LONG).show();
            return;
        }


        //validate email
        String ePattern = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$";
        java.util.regex.Pattern p = java.util.regex.Pattern.compile(ePattern);
        java.util.regex.Matcher m = p.matcher(emailET.getText().toString());
        if(!m.matches())//invalid
        {
            Toast.makeText(getActivity(), R.string.emailerror, Toast.LENGTH_LONG).show();
            return;
        }

        //clear all editTexts
        clearForm(viewGroup);
        nameET.requestFocus();

        //start a new activity

        //create intent
        Intent intent = new Intent(getContext(), HomeActivity.class);
        //pass username
        intent.putExtra(getString(R.string.username), username);
        //pass name
        intent.putExtra(getString(R.string.name), name);
        intent.putExtra(getString(R.string.age), age);
        intent.putExtra(getString(R.string.job), job);

        //start
        getActivity().startActivity(intent);
    }

    //calculates difference in years
    public static int getDiffYears(Date first, Date last) {
        Calendar a = getCalendar(first);
        Calendar b = getCalendar(last);
        int diff = b.get(Calendar.YEAR) - a.get(Calendar.YEAR);
        if (a.get(MONTH) > b.get(MONTH) ||
                (a.get(MONTH) == b.get(MONTH) && a.get(Calendar.DATE) > b.get(Calendar.DATE))) {
            diff--;
        }
        return diff;
    }
    //creates a calendar from date
    public static Calendar getCalendar(Date date) {
        Calendar cal = Calendar.getInstance(Locale.US);
        cal.setTime(date);
        return cal;
    }

    //clears all the editText
    private void clearForm(ViewGroup group) {
        for (int i = 0, count = group.getChildCount(); i < count; ++i) {
            View view = group.getChildAt(i);
            if (view instanceof EditText) {
                ((EditText)view).setText("");
            }

            if(view instanceof ViewGroup && (((ViewGroup)view).getChildCount() > 0))
                clearForm((ViewGroup)view);
        }
    }
}
