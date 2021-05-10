package com.freenow.testFiles;

import android.support.test.espresso.FailureHandler;
import android.support.test.espresso.ViewInteraction;
import android.support.test.espresso.assertion.ViewAssertions;
import android.support.test.espresso.matcher.RootMatchers;
import android.support.test.espresso.matcher.ViewMatchers;
import android.support.test.runner.AndroidJUnit4;

import com.freenow.android_demo.R;
import com.freenow.components.AppFunc;
import com.freenow.utils.BaseTest;
import com.freenow.utils.TestData;

import org.hamcrest.Matcher;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.junit.Test;
import org.junit.runner.RunWith;

import kotlin.jvm.internal.Intrinsics;

import static android.support.test.espresso.Espresso.closeSoftKeyboard;
import static android.support.test.espresso.Espresso.onData;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.replaceText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.CoreMatchers.anything;

@RunWith(AndroidJUnit4.class)
public class FreeNowTest extends BaseTest {

    AppFunc reusableMethods = new AppFunc();
    TestData Tdata = new TestData();


    //Used OnData method in this test to identify the Driver name dynamically
    @Test
    public void ValidateSriverProfile() throws InterruptedException {
        reusableMethods.LoginToFreeNow(Tdata.sUserName,Tdata.sPassword);
        waitForElementPresent(true);
        reusableMethods.searchForDriver(Tdata.sSearchTerm);
        waitForElementPresent(true);
        reusableMethods.clickOnDNameOnData(Tdata.sDriverName);
        reusableMethods.validateDriverProfile(Tdata.sDriverName);
        reusableMethods.callDriver();
    }
    //Used OnView method in this test to click on Driver name
    @Test
    public void ValidateDriverProfile_OnView() throws InterruptedException {
        reusableMethods.LoginToFreeNow(Tdata.sUserName,Tdata.sPassword);
        waitForElementPresent(true);
        reusableMethods.searchForDriver(Tdata.sSearchTerm);
        waitForElementPresent(true);
        reusableMethods.clickOnDriverNameOnView(Tdata.sDriverName);
        reusableMethods.validateDriverProfile(Tdata.sDriverName);
        reusableMethods.callDriver();
    }

}
