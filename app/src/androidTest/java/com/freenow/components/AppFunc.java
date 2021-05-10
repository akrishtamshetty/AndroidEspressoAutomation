package com.freenow.components;

import android.support.design.widget.FloatingActionButton;
import android.support.test.espresso.matcher.RootMatchers;
import android.support.test.espresso.matcher.ViewMatchers;
import android.widget.ImageView;
import android.widget.TextView;

import com.freenow.android_demo.R;
import com.freenow.utils.BaseTest;

import org.hamcrest.Matcher;
import org.jetbrains.annotations.NotNull;

import kotlin.jvm.internal.Intrinsics;

import static android.support.test.espresso.Espresso.closeSoftKeyboard;
import static android.support.test.espresso.Espresso.onData;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.replaceText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withContentDescription;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.CoreMatchers.anything;

public class AppFunc extends BaseTest {

    public void LoginToFreeNow(String sUserName, String sPassword){
        if (!viewIsDisplayed(
                onView(withContentDescription("Open navigation drawer")),
                ViewMatchers.isDisplayed())
        ) {
            setText(R.id.edt_username, sUserName);
            closeSoftKeyboard();
            setText(R.id.edt_password, sPassword);
            clickOnElementWithId(R.id.btn_login);
        }
    }

    public void searchForDriver(String sDriverName){
        clickOnElementWithId(R.id.searchContainer);
        setText(R.id.textSearch,sDriverName);
    }

    public void clickOnDriverNameOnView(String sDName){
        onView(withText(sDName)).inRoot(RootMatchers.isPlatformPopup()).perform(click());
    }
    public void clickOnDNameOnData(String sDriverName) {
        int i = 0;
        boolean isFound = false;

        do {
            i++;
            if (viewIsDisplayed(
                    onData(anything()).inRoot(RootMatchers.isPlatformPopup()).atPosition(i).check(matches(withText(sDriverName))),
                    ViewMatchers.isDisplayed())
            ) {
                onData(anything()).inRoot(RootMatchers.isPlatformPopup()).atPosition(i).check(matches(withText(sDriverName))).perform(click());
                break;
            }
        } while(i < 6);

    }

    public void validateDriverProfile(String sDName){
        isElementDisplayedWithIdAndText(R.id.textViewDriverName,sDName);
        isElementDisplayedWithId(R.id.imageViewDriverAvatar);
        isElementDisplayedWithId(R.id.textViewDriverLocation);
        isElementDisplayedWithId(R.id.textViewDriverDate);
        isElementDisplayedWithId(R.id.fab);
    }
    public void callDriver(){
        clickOnElementWithId(R.id.fab);
    }
}
