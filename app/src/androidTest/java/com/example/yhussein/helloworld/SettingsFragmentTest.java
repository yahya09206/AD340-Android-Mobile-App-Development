package com.example.yhussein.helloworld;

import android.support.test.espresso.matcher.ViewMatchers;
import android.support.test.runner.AndroidJUnit4;

import com.android21buttons.fragmenttestrule.FragmentTestRule;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onData;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withSpinnerText;
import static org.hamcrest.CoreMatchers.anything;
import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.*;

@RunWith(AndroidJUnit4.class)
public class SettingsFragmentTest {

    @Rule
    public FragmentTestRule<DebugActivity, SettingsFragment> fragmentTestRule = new FragmentTestRule<>(DebugActivity.class, SettingsFragment.class);

    @Test
    public void fieldsAreVisible(){
        onView(withId(R.id.reminderTime)).check(matches(isDisplayed()));
        onView(withId(R.id.maxDistance)).check(matches(isDisplayed()));
        onView(withId(R.id.ageRange)).check(matches(isDisplayed()));
        onView(withId(R.id.genderSpinner)).check(matches(isDisplayed()));
        onView(withId(R.id.accountTypeSpinner)).check(matches(isDisplayed()));
        onView(withId(R.id.saveBtn)).check(matches(isDisplayed()));
    }

    @Test
    public void testGenderSpinner(){
        onView(withId(R.id.genderSpinner)).perform(click());
        onData(anything()).atPosition(0).perform(click());
        onView(withId(R.id.genderSpinner)).check(matches(withSpinnerText(containsString("Female"))));
    }

    @Test
    public void testGenderSpinner2(){
        onView(withId(R.id.genderSpinner)).perform(click());
        onData(anything()).atPosition(1).perform(click());
        onView(withId(R.id.genderSpinner)).check(matches(withSpinnerText(containsString("Male"))));
    }

    @Test
    public void testAccountTypeSpinner(){
        onView(withId(R.id.accountTypeSpinner)).perform(click());
        onData(anything()).atPosition(0).perform(click());
        onView(withId(R.id.accountTypeSpinner)).check(matches(withSpinnerText(containsString("Private"))));
    }

    @Test
    public void testAccountTypeSpinner2(){
        onView(withId(R.id.accountTypeSpinner)).perform(click());
        onData(anything()).atPosition(1).perform(click());
        onView(withId(R.id.accountTypeSpinner)).check(matches(withSpinnerText(containsString("Public"))));
    }

}