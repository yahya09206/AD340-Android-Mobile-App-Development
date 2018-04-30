package com.example.yhussein.helloworld;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import static java.util.Calendar.MONTH;

public class MainActivity extends AppCompatActivity {

    private EditText nameET;
    private EditText emailET;
    private EditText usernameET;
    private EditText ageET;
    private EditText dobET;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //init
        nameET =  findViewById(R.id.name);
        emailET =  findViewById(R.id.email);
        usernameET =  findViewById(R.id.username);
        ageET =  findViewById(R.id.age);
        dobET = findViewById(R.id.dob);


    }

    public void onSubmit(View view) {
        //validate dateji
        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
        String dateStr = dobET.getText().toString();
        try
        {
            Date dob = sdf.parse(dateStr);
            Date now = new Date();
            int years = getDiffYears(dob, now);
            if(years < 18)
            {
                Toast.makeText(this, R.string.doberr, Toast.LENGTH_LONG).show();
                return;
            }

        }
        catch (Exception e)
        {
            Toast.makeText(this, R.string.dobmsg, Toast.LENGTH_LONG).show();
            return;
        }

        //gets username
        String username = usernameET.getText().toString();
        if(username.length() == 0)
        {
            Toast.makeText(this, R.string.usernameerror, Toast.LENGTH_LONG).show();
            return;
        }

        //gets name
        String name = nameET.getText().toString();
        if(name.length() == 0)
        {
            Toast.makeText(this, R.string.nameerror, Toast.LENGTH_LONG).show();
            return;
        }


        //validate email
        String ePattern = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$";
        java.util.regex.Pattern p = java.util.regex.Pattern.compile(ePattern);
        java.util.regex.Matcher m = p.matcher(emailET.getText().toString());
        if(!m.matches())//invalid
        {
            Toast.makeText(this, R.string.emailerror, Toast.LENGTH_LONG).show();
            return;
        }

        //clear all editTexts
        clearForm((ViewGroup) findViewById(R.id.form));
        nameET.requestFocus();

        //start a new activity

        //create intent
        Intent intent = new Intent(this, HomeActivity.class);
        //pass username
        intent.putExtra(getString(R.string.username), username);
        //start
        this.startActivity(intent);
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
