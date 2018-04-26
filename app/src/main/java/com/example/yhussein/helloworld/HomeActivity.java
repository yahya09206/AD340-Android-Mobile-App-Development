package com.example.yhussein.helloworld;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.yhussein.helloworld.R;

import org.w3c.dom.Text;

public class HomeActivity extends AppCompatActivity {

    TextView thanksTv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        thanksTv = findViewById(R.id.thanks);

        //get intent used to start activity
        Intent intent = this.getIntent();
        //get username
        String username = intent.getStringExtra(getString(R.string.username));

        //set text
        thanksTv.setText(getString(R.string.thankyou)+username+"!");

        //


    }

    //on button click
    public void createNewAccount(View view) {
        //exit current activity to the parent
        this.finish();
    }
}
