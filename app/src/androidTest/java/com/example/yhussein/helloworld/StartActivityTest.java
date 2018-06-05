package com.example.yhussein.helloworld;


import android.support.test.espresso.ViewInteraction;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.LargeTest;
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
import static android.support.test.espresso.Espresso.pressBack;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.pressImeActionButton;
import static android.support.test.espresso.action.ViewActions.replaceText;
import static android.support.test.espresso.action.ViewActions.swipeLeft;
import static android.support.test.espresso.action.ViewActions.swipeRight;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withClassName;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.is;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class StartActivityTest {

    @Rule
    public ActivityTestRule<StartActivity> mActivityTestRule = new ActivityTestRule<>(StartActivity.class);

    @Test
    public void startActivityTest() {
        // Added a sleep statement to match the app's execution delay.
        // The recommended way to handle such scenarios is to use Espresso idling resources:
        // https://google.github.io/android-testing-support-library/docs/espresso/idling-resource/index.html
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        ViewInteraction appCompatEditText = onView(
                allOf(withId(R.id.name),
                        childAtPosition(
                                allOf(withId(R.id.form),
                                        childAtPosition(
                                                withClassName(is("android.support.constraint.ConstraintLayout")),
                                                0)),
                                1),
                        isDisplayed()));
        appCompatEditText.perform(click());

        ViewInteraction appCompatEditText2 = onView(
                allOf(withId(R.id.name),
                        childAtPosition(
                                allOf(withId(R.id.form),
                                        childAtPosition(
                                                withClassName(is("android.support.constraint.ConstraintLayout")),
                                                0)),
                                1),
                        isDisplayed()));
        appCompatEditText2.perform(replaceText("Jose perez"), closeSoftKeyboard());

        ViewInteraction appCompatEditText3 = onView(
                allOf(withId(R.id.email),
                        childAtPosition(
                                allOf(withId(R.id.form),
                                        childAtPosition(
                                                withClassName(is("android.support.constraint.ConstraintLayout")),
                                                0)),
                                2),
                        isDisplayed()));
        appCompatEditText3.perform(replaceText("aninal@mail.com"), closeSoftKeyboard());

        ViewInteraction appCompatEditText4 = onView(
                allOf(withId(R.id.username),
                        childAtPosition(
                                allOf(withId(R.id.form),
                                        childAtPosition(
                                                withClassName(is("android.support.constraint.ConstraintLayout")),
                                                0)),
                                3),
                        isDisplayed()));
        appCompatEditText4.perform(replaceText("jose"), closeSoftKeyboard());

        ViewInteraction appCompatEditText5 = onView(
                allOf(withId(R.id.age),
                        childAtPosition(
                                allOf(withId(R.id.form),
                                        childAtPosition(
                                                withClassName(is("android.support.constraint.ConstraintLayout")),
                                                0)),
                                4),
                        isDisplayed()));
        appCompatEditText5.perform(replaceText("18"), closeSoftKeyboard());

        ViewInteraction appCompatEditText6 = onView(
                allOf(withId(R.id.dob),
                        childAtPosition(
                                allOf(withId(R.id.form),
                                        childAtPosition(
                                                withClassName(is("android.support.constraint.ConstraintLayout")),
                                                0)),
                                5),
                        isDisplayed()));
        appCompatEditText6.perform(replaceText("12"), closeSoftKeyboard());

        ViewInteraction appCompatEditText7 = onView(
                allOf(withId(R.id.dob), withText("12"),
                        childAtPosition(
                                allOf(withId(R.id.form),
                                        childAtPosition(
                                                withClassName(is("android.support.constraint.ConstraintLayout")),
                                                0)),
                                5),
                        isDisplayed()));
        appCompatEditText7.perform(pressImeActionButton());

        ViewInteraction appCompatEditText8 = onView(
                allOf(withId(R.id.job),
                        childAtPosition(
                                allOf(withId(R.id.form),
                                        childAtPosition(
                                                withClassName(is("android.support.constraint.ConstraintLayout")),
                                                0)),
                                6),
                        isDisplayed()));
        appCompatEditText8.perform(replaceText("student"), closeSoftKeyboard());

        //pressBack();

        ViewInteraction appCompatButton = onView(
                allOf(withId(R.id.submitBtn), withText("Submit"),
                        childAtPosition(
                                allOf(withId(R.id.form),
                                        childAtPosition(
                                                withClassName(is("android.support.constraint.ConstraintLayout")),
                                                0)),
                                8),
                        isDisplayed()));
        appCompatButton.perform(click());

        ViewInteraction appCompatEditText9 = onView(
                allOf(withId(R.id.dob), withText("12"),
                        childAtPosition(
                                allOf(withId(R.id.form),
                                        childAtPosition(
                                                withClassName(is("android.support.constraint.ConstraintLayout")),
                                                0)),
                                5),
                        isDisplayed()));
        appCompatEditText9.perform(replaceText("12/2/2000"));

        ViewInteraction appCompatEditText10 = onView(
                allOf(withId(R.id.dob), withText("12/2/2000"),
                        childAtPosition(
                                allOf(withId(R.id.form),
                                        childAtPosition(
                                                withClassName(is("android.support.constraint.ConstraintLayout")),
                                                0)),
                                5),
                        isDisplayed()));
        appCompatEditText10.perform(closeSoftKeyboard());

        //pressBack();

        ViewInteraction appCompatButton2 = onView(
                allOf(withId(R.id.submitBtn), withText("Submit"),
                        childAtPosition(
                                allOf(withId(R.id.form),
                                        childAtPosition(
                                                withClassName(is("android.support.constraint.ConstraintLayout")),
                                                0)),
                                8),
                        isDisplayed()));
        appCompatButton2.perform(click());

        ViewInteraction appCompatEditText11 = onView(
                allOf(withId(R.id.dob), withText("12/2/2000"),
                        childAtPosition(
                                allOf(withId(R.id.form),
                                        childAtPosition(
                                                withClassName(is("android.support.constraint.ConstraintLayout")),
                                                0)),
                                5),
                        isDisplayed()));
        appCompatEditText11.perform(click());

        ViewInteraction appCompatEditText12 = onView(
                allOf(withId(R.id.dob), withText("12/2/2000"),
                        childAtPosition(
                                allOf(withId(R.id.form),
                                        childAtPosition(
                                                withClassName(is("android.support.constraint.ConstraintLayout")),
                                                0)),
                                5),
                        isDisplayed()));
        appCompatEditText12.perform(replaceText("12/2/1998"));

        ViewInteraction appCompatEditText13 = onView(
                allOf(withId(R.id.dob), withText("12/2/1998"),
                        childAtPosition(
                                allOf(withId(R.id.form),
                                        childAtPosition(
                                                withClassName(is("android.support.constraint.ConstraintLayout")),
                                                0)),
                                5),
                        isDisplayed()));
        appCompatEditText13.perform(closeSoftKeyboard());

        //pressBack();

        ViewInteraction appCompatButton3 = onView(
                allOf(withId(R.id.submitBtn), withText("Submit"),
                        childAtPosition(
                                allOf(withId(R.id.form),
                                        childAtPosition(
                                                withClassName(is("android.support.constraint.ConstraintLayout")),
                                                0)),
                                8),
                        isDisplayed()));
        appCompatButton3.perform(click());

        // Added a sleep statement to match the app's execution delay.
        // The recommended way to handle such scenarios is to use Espresso idling resources:
        // https://google.github.io/android-testing-support-library/docs/espresso/idling-resource/index.html
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        ViewInteraction appCompatButton4 = onView(
                allOf(withId(R.id.button), withText("Create New Account"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                6),
                        isDisplayed()));
        appCompatButton4.perform(click());

        // Added a sleep statement to match the app's execution delay.
        // The recommended way to handle such scenarios is to use Espresso idling resources:
        // https://google.github.io/android-testing-support-library/docs/espresso/idling-resource/index.html
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        ViewInteraction tabView = onView(
                allOf(childAtPosition(
                        childAtPosition(
                                withId(R.id.tabLayout),
                                0),
                        1),
                        isDisplayed()));
        tabView.perform(click());

        ViewInteraction viewPager = onView(
                allOf(withId(R.id.pager),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.support.constraint.ConstraintLayout")),
                                        0),
                                1),
                        isDisplayed()));
        viewPager.perform(swipeLeft());

        ViewInteraction tabView2 = onView(
                allOf(childAtPosition(
                        childAtPosition(
                                withId(R.id.tabLayout),
                                0),
                        2),
                        isDisplayed()));
        tabView2.perform(click());

        ViewInteraction viewPager2 = onView(
                allOf(withId(R.id.pager),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.support.constraint.ConstraintLayout")),
                                        0),
                                1),
                        isDisplayed()));
        viewPager2.perform(swipeLeft());

        ViewInteraction tabView3 = onView(
                allOf(childAtPosition(
                        childAtPosition(
                                withId(R.id.tabLayout),
                                0),
                        0),
                        isDisplayed()));
        tabView3.perform(click());

        ViewInteraction viewPager3 = onView(
                allOf(withId(R.id.pager),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.support.constraint.ConstraintLayout")),
                                        0),
                                1),
                        isDisplayed()));
        viewPager3.perform(swipeRight());

    }

    private static Matcher<View> childAtPosition(
            final Matcher<View> parentMatcher, final int position) {

        return new TypeSafeMatcher<View>() {
            @Override
            public void describeTo(Description description) {
                description.appendText("Child at position " + position + " in parent ");
                parentMatcher.describeTo(description);
            }

            @Override
            public boolean matchesSafely(View view) {
                ViewParent parent = view.getParent();
                return parent instanceof ViewGroup && parentMatcher.matches(parent)
                        && view.equals(((ViewGroup) parent).getChildAt(position));
            }
        };
    }
}
