package com.example.yhussein.helloworld;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class StartActivity extends AppCompatActivity {

    private TabLayout tabLayout;
    private ViewPager pager;
    private PagerAdapter pagerAdapter;
    public String username;
    public String name;
    public String age;
    public String job;
    public String info;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        pager = findViewById(R.id.pager);
        tabLayout = findViewById(R.id.tabLayout);

        //get intent used to start activity
        Intent intent = this.getIntent();
        //get username
        username = intent.getStringExtra(getString(R.string.username));
        name = intent.getStringExtra(getString(R.string.name));
        age = intent.getStringExtra(getString(R.string.age));
        job = intent.getStringExtra(getString(R.string.job));
        info = intent.getStringExtra(getString(R.string.description));

        pagerAdapter = new PagerAdapter(getSupportFragmentManager(), tabLayout.getTabCount());
        pager.setAdapter(pagerAdapter);
        //tabLayout.setupWithViewPager(pager);
        pager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                pager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

    }
}
