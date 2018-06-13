package com.example.yhussein.helloworld;

import android.support.test.espresso.ViewAction;

import com.android21buttons.fragmenttestrule.FragmentTestRule;

import org.junit.Rule;
import org.junit.Test;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static org.junit.Assert.*;

public class ProfileFragmentTest {

    @Rule
    public FragmentTestRule<StartActivity, ProfileFragment> fragmentTestRule = new FragmentTestRule<>(StartActivity.class, ProfileFragment.class);

    @Test
    public void fieldsAreVisible(){
        onView(withId(R.id.thanks)).check(matches(isDisplayed()));
        onView(withId(R.id.img)).check(matches(isDisplayed()));
        onView(withId(R.id.nametwo)).check(matches(isDisplayed()));
        onView(withId(R.id.agetwo)).check(matches(isDisplayed()));
        onView(withId(R.id.descriptiontwo)).check(matches(isDisplayed()));
        onView(withId(R.id.jobtwo)).check(matches(isDisplayed()));
    }

    @Test
    public void testCreateNewAccount(){
        onView(withId(R.id.button)).perform(click());
        assertTrue(fragmentTestRule.getFragment().getActivity().isDestroyed());
    }

}