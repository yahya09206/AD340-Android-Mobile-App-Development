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
        setContentView(R.layout.activity_home);



//        TextView profileage;
//        TextView profilejob;
//        TextView profileinfo;


        TextView thanks = findViewById(R.id.thanks);
        TextView profilename = findViewById(R.id.nametwo);

//        profileage = findViewById(R.id.age);
//        profilejob = findViewById(R.id.occupation);
//        profileinfo = findViewById(R.id.description);


        //get intent used to start activity
        Intent intent = this.getIntent();
        //get username
        String username = intent.getStringExtra(getString(R.string.username));
        String name = intent.getStringExtra(getString(R.string.name));
//        String age = intent.getStringExtra(getString(R.string.age));
//        String job = intent.getStringExtra(getString(R.string.occupation));
//        String info = intent.getStringExtra(getString(R.string.description));
//
//
//        //set text
        thanks.setText(getString(R.string.thanks) + " " +username+"!");
        profilename.setText(getString(R.string.proname) + name);
//        profileage.setText(age);
//        profilejob.setText(job);
//        profileinfo.setText(info);


    }

    //on button click
    public void createNewAccount(View view) {
        //exit current activity to the parent
        this.finish();
    }
}
