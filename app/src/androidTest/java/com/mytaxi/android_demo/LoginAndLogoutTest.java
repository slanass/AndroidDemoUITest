package com.mytaxi.android_demo;


import android.os.SystemClock;
import android.support.test.espresso.action.TypeTextAction;
import android.support.test.espresso.contrib.NavigationViewActions;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.support.test.espresso.NoMatchingViewException;
import android.view.Gravity;

import com.mytaxi.android_demo.activities.DriverProfileActivity;
import com.mytaxi.android_demo.activities.MainActivity;

import org.junit.After;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;

import java.util.concurrent.TimeUnit;

import static android.support.test.espresso.Espresso.onData;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.contrib.DrawerActions.open;
import static android.support.test.espresso.contrib.DrawerMatchers.isClosed;
import static android.support.test.espresso.matcher.ViewMatchers.isDescendantOfA;
import static android.support.test.espresso.matcher.ViewMatchers.isRoot;
import static android.support.test.espresso.matcher.ViewMatchers.withClassName;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.Espresso.pressBack;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static java.lang.Thread.sleep;
import static java.util.concurrent.TimeUnit.SECONDS;
import static org.hamcrest.CoreMatchers.anything;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.core.AllOf.allOf;
import static org.hamcrest.core.Is.is;

//


import static org.hamcrest.Matchers.endsWith;

//

/**
 * Created by Anass on 11/17/2018.
 */
@RunWith(AndroidJUnit4.class)
//@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class LoginAndLogoutTest {
    @Rule
    public ActivityTestRule<MainActivity> mActivityTestRule = new ActivityTestRule<>(MainActivity.class);
    public ActivityTestRule<DriverProfileActivity> dactivityTestRule = new ActivityTestRule<>(DriverProfileActivity.class);
    private String nLogin = "crazydog335";
    private String nPassword = "venture";
    private String nSearch ="sa";

    @Before
    public void setUp() throws Exception {
    }
    @Test
    public void A_Testlogin () {
        //Input login
        onView(withId(R.id.edt_username)).perform(typeText(nLogin));
        onView(withId(R.id.edt_password)).perform(typeText(nPassword));
        onView(withId(R.id.btn_login)).perform(click());
    }
    @Test

    public void B_Logout() {
        //Press menu
        //onView(isRoot()).perform(TimeUnit.SECONDS.toMillis(15)));
        try {
            Thread.sleep(2000);
            onView(withId(R.id.drawer_layout))
                    .check(matches(isClosed(Gravity.LEFT))) // Left Drawer should be closed.
                    .perform(open());
            Thread.sleep(1000);
                       onView(withId(R.id.nav_view))
                    .perform(NavigationViewActions.navigateTo(R.id.nav_logout));
            Thread.sleep(1000);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    @After
    public void tearDown() throws Exception {
    }

}