package com.freenow.utils;


import android.support.test.espresso.Espresso;
import android.support.test.espresso.FailureHandler;
import android.support.test.espresso.ViewAction;
import android.support.test.espresso.ViewInteraction;
import android.support.test.espresso.action.ViewActions;
import android.support.test.espresso.assertion.ViewAssertions;
import android.support.test.espresso.matcher.ViewMatchers;
import android.support.test.rule.ActivityTestRule;
import android.support.test.rule.GrantPermissionRule;

import com.freenow.android_demo.R;
import com.freenow.android_demo.activities.MainActivity;

import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.junit.Before;
import org.junit.Rule;

import kotlin.jvm.internal.Intrinsics;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.replaceText;
import static android.support.test.espresso.matcher.ViewMatchers.withId;

public class BaseTest {
    @Rule
    public ActivityTestRule<MainActivity> mActivityTestRule = new ActivityTestRule<>(MainActivity.class);

    @Rule
    public GrantPermissionRule mGrantPermissionRule =
            GrantPermissionRule.grant(
                    "android.permission.ACCESS_FINE_LOCATION");

    public final void clickOnElementWithId(int id) {
        Espresso.onView(ViewMatchers.withId(id)).check(ViewAssertions.matches(ViewMatchers.isDisplayed())).perform(new ViewAction[]{ViewActions.click()});
    }

    public final boolean viewIsDisplayed(@NotNull ViewInteraction view, @Nullable Matcher matchProperty) {
        Intrinsics.checkParameterIsNotNull(view, "view");
        final boolean[] condition = new boolean[]{true};
        view.withFailureHandler((FailureHandler)(new FailureHandler() {
            public final void handle(@Nullable Throwable error, @Nullable Matcher viewMatcher) {
                condition[0] = false;
            }
        })).check(ViewAssertions.matches(matchProperty));
        return condition[0];
    }

    public void setText(Integer Id,String sText){
        onView(withId(Id))
                .perform(replaceText(sText));
    }
    public final void isElementDisplayedWithId(int id) {
        Espresso.onView(ViewMatchers.withId(id)).check(ViewAssertions.matches(ViewMatchers.isDisplayed()));
    }
    public final void isElementDisplayedWithIdAndText(int id,  String text) {
        Espresso.onView(Matchers.allOf(ViewMatchers.withId(id), ViewMatchers.withText(text))).check(ViewAssertions.matches(ViewMatchers.isDisplayed()));
    }
    public final void waitForElementPresent(boolean max) throws InterruptedException {
        long millis = max ? 3000L : 1000L;
        Thread.sleep(millis);
    }

}
