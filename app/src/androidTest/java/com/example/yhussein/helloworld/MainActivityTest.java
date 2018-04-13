package com.example.yhussein.helloworld;

import android.support.test.InstrumentationRegistry;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

@RunWith(AndroidJUnit4.class)
public class MainActivityTest {

    @Rule
    public ActivityTestRule<MainActivity> testRule = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void fullinfo(){
        //check to see if text matches from main screen
        onView(withId(R.id.textView))
                .check(matches(withText(R.string.hello)));
        //check to see if text string matches the one on the menu
        onView(withId(R.id.textView))
                .check(matches(withText(R.string.info)));
    }

}