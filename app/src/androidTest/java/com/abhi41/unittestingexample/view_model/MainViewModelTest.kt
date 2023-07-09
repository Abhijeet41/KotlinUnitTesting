package com.abhi41.unittestingexample.view_model

import android.content.Intent
import androidx.test.espresso.Espresso.*
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.intent.Intents
import androidx.test.espresso.intent.Intents.intended
import androidx.test.espresso.intent.matcher.IntentMatchers.hasAction
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.abhi41.unittestingexample.MainActivity
import org.junit.Rule
import org.junit.Test
import com.abhi41.unittestingexample.R
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import org.hamcrest.core.AllOf.allOf

@HiltAndroidTest
class MainViewModelTest {
    /*
        we use rule to define that this activity should get launch first
     */
    @get:Rule(order = 0)
    val hiltRule = HiltAndroidRule(this)

    @get:Rule(order = 1)
    val activitySenarioRule = ActivityScenarioRule(MainActivity::class.java)


    @Test
    fun testNextButton_expectedCorrectQuote(){
        /*
            first we need to access views for interaction
            we define actions for access rules
         */
        onView(withId(R.id.txtNext)).perform(click())
        onView(withId(R.id.txtNext)).perform(click())
        onView(withId(R.id.txtNext)).perform(click())
        onView(withId(R.id.quoteText)).check(matches(withText("Difficulties increase the nearer we get to the goal.")))
    }

    @Test
    fun testsharebutton_expectedIntentChooser(){
        Intents.init()
        val expected = allOf(hasAction(Intent.ACTION_SEND))
        onView(withId(R.id.floatingActionButton)).perform(click())
        intended(expected) //this is nothing but assert, raised intent operation
        Intents.release()
    }
}