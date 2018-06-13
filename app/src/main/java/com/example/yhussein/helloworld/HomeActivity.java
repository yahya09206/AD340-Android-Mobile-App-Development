package com.example.yhussein.helloworld;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.yhussein.helloworld.R;

import org.w3c.dom.Text;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_home);

        TextView thanks = findViewById(R.id.thanks);
        TextView profilename = findViewById(R.id.nametwo);
        TextView profileage = findViewById(R.id.agetwo);
        TextView profilejob = findViewById(R.id.jobtwo);
        TextView profileinfo = findViewById(R.id.descriptiontwo);


        //get intent used to start activity
        Intent intent = this.getIntent();
        //get username
        String username = intent.getStringExtra(getString(R.string.username));
        String name = intent.getStringExtra(getString(R.string.name));
        String age = intent.getStringExtra(getString(R.string.age));
        String job = intent.getStringExtra(getString(R.string.job));
        String info = intent.getStringExtra(getString(R.string.description));

        //set text
        thanks.setText(getString(R.string.thanks) + " " +username+"!");
        profilename.setText(getString(R.string.proname) + name);
        profileage.setText(getString(R.string.proage) + age);
        profilejob.setText(getString(R.string.projob) + job);
        profileinfo.setText(getString(R.string.prodescription) + info);


    }

    //on button click
    public void createNewAccount(View view) {
        //exit current activity to the parent
        this.finish();
    }
}
