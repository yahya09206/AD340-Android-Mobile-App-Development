package com.example.yhussein.helloworld;

import android.support.test.espresso.Espresso;
import android.support.test.espresso.matcher.ViewMatchers;
import android.support.test.runner.AndroidJUnit4;

import com.android21buttons.fragmenttestrule.FragmentTestRule;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static org.junit.Assert.*;

@RunWith(AndroidJUnit4.class)
public class MatchesFragmentTest {

    @Rule
    public FragmentTestRule<DebugActivity, MatchesFragment> fragmentTestRule = new FragmentTestRule<>(DebugActivity.class, MatchesFragment.class);

    @Test
    public void checkListViewIsVisible() {
        Espresso.onView(ViewMatchers.withId(R.id.matchList)).check(matches(isDisplayed()));
    }




}