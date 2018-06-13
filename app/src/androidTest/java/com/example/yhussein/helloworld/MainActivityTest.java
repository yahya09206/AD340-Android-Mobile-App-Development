package com.example.yhussein.helloworld;

import android.content.Intent;
import android.support.test.espresso.ViewAction;
import android.support.test.espresso.ViewInteraction;
import android.support.test.espresso.intent.Intents;
import android.support.test.espresso.intent.rule.IntentsTestRule;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.LargeTest;
import android.text.InputType;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.intent.Intents.intended;
import static android.support.test.espresso.intent.matcher.BundleMatchers.hasEntry;
import static android.support.test.espresso.intent.matcher.IntentMatchers.hasAction;
import static android.support.test.espresso.intent.matcher.IntentMatchers.hasCategories;
import static android.support.test.espresso.intent.matcher.IntentMatchers.hasComponent;
import static android.support.test.espresso.intent.matcher.IntentMatchers.hasData;
import static android.support.test.espresso.intent.matcher.IntentMatchers.hasExtras;
import static android.support.test.espresso.intent.matcher.IntentMatchers.toPackage;
import static android.support.test.espresso.intent.matcher.UriMatchers.hasHost;
import static android.support.test.espresso.matcher.RootMatchers.withDecorView;
import static android.support.test.espresso.matcher.ViewMatchers.isClickable;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withInputType;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.CoreMatchers.allOf;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;
import static org.hamcrest.core.IsCollectionContaining.hasItem;


@RunWith(AndroidJUnit4.class)
public class MainActivityTest {

    @Rule
    public IntentsTestRule<MainActivity> testRule = new IntentsTestRule<>(MainActivity.class);

    @Test
    public void onCreate() {

        //Check all EditText fields are visible

        onView(withId(R.id.name)).check(matches(isDisplayed()));
        onView(withId(R.id.email)).check(matches(isDisplayed()));
        onView(withId(R.id.username)).check(matches(isDisplayed()));
        onView(withId(R.id.age)).check(matches(isDisplayed()));
        onView(withId(R.id.dob)).check(matches(isDisplayed()));
        onView(withId(R.id.description)).check(matches(isDisplayed()));
    }

    @Test
    public void checkAgeField(){

        //Check the age field is a number inout field
       onView(withId(R.id.age)).check(matches(withInputType(InputType.TYPE_CLASS_NUMBER)));
    }

    @Test
    public void checkDateField(){

        //Check the age field is a date/time field
        onView(withId(R.id.dob)).check(matches(withInputType(InputType.TYPE_CLASS_DATETIME)));
    }

    @Test
    public void checkUsernameField(){

        //Check the age field is a number inout field
        onView(withId(R.id.username)).check(matches(withInputType(InputType.TYPE_CLASS_TEXT)));
    }



    //Check on submit button clicked with scenerios
    @Test
    public void onSubmitWithInValidDate() {

        onView(withId(R.id.dob)).perform(typeText("12/3")).perform(closeSoftKeyboard());
        onView(withId(R.id.submitBtn)).perform(click());
        onView(withText(R.string.dobmsg)).
                inRoot(withDecorView(not(is(testRule.getActivity().getWindow().getDecorView())))).
                check(matches(isDisplayed()));

    }

    @Test
    public void onSubmitWithValidData() {
        onView(withId(R.id.name)).perform(typeText("Joe")).perform(closeSoftKeyboard());
        onView(withId(R.id.email)).perform(typeText("joe@mail.com")).perform(closeSoftKeyboard());
        onView(withId(R.id.username)).perform(typeText("joe")).perform(closeSoftKeyboard());
        onView(withId(R.id.age)).perform(typeText("23")).perform(closeSoftKeyboard());
        onView(withId(R.id.dob)).perform(typeText("11/11/1990")).perform(closeSoftKeyboard());
        onView(withId(R.id.job)).perform(typeText("Sample description")).perform(closeSoftKeyboard());

        onView(withId(R.id.submitBtn)).perform(click());


        intended(hasComponent(StartActivity.class.getName()));

    }



}
