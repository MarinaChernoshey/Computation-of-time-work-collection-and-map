package test.support.appodeal.com.task3collectionandmap.mvp.view;

import android.support.test.espresso.IdlingRegistry;
import android.support.test.espresso.IdlingResource;
import android.support.test.rule.ActivityTestRule;

import com.squareup.spoon.Spoon;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import test.support.appodeal.com.task3collectionandmap.R;
import test.support.appodeal.com.task3collectionandmap.ui.main.activity.MainActivity;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;

public class MainActivityTest {

    ///java -jar spoon-runner-1.7.1-jar-with-dependencies.jar --apk app/build/outputs/apk/debug/app-debug.apk --test-apk app/build/outputs/apk/androidTest/debug/app-debug-androidTest.apk --sdk C:/Users/fanMU/AppData/Local/Android/Sdk

    @Rule
    public ActivityTestRule<MainActivity> mActivityRule = new ActivityTestRule<>(
            MainActivity.class);

    @Before
    public void setUp() {
        IdlingResource mIdlingResource = mActivityRule.getActivity().getCountingIdlingResource();
        IdlingRegistry.getInstance().register(mIdlingResource);
    }

    @Test
    public void onClick() {
        onView(withId(R.id.editText)).perform(typeText("1000000"));
        onView(withId(R.id.buttonCalculate)).perform(click());
        onView(withId(R.id.recycler_view_col)).check(new RecyclerViewItemCountAssertion(28));
        onView(withId(R.id.recycler_view_map)).check(new RecyclerViewItemCountAssertion(9));
        onView(withId(R.id.buttonCalculate)).check(matches(isDisplayed()));
    }

}