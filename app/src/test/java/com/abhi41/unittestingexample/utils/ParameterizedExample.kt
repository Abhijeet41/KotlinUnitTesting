package com.abhi41.unittestingexample.utils

import android.provider.SyncStateContract.Helpers
import org.junit.Assert.assertEquals
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized
import org.junit.runners.Parameterized.Parameters

@RunWith(value = Parameterized::class)
class ParameterizedExample(
    val input: String,
    val expectedValue: Boolean
) {

    @Test
    fun test() {
        val helper = Helper()
        val result = helper.isPallindrome(input)
        assertEquals(expectedValue, result)
    }

    //this companion object tells our Junit these are the parameters
    companion object {
        @JvmStatic //this to define this is our static method
        @Parameters(name = "{index} : {0} is pallindrome - {1}")
        fun data(): List<Array<Any>> {
            return listOf(
                arrayOf("hello", false),
                arrayOf("level", true),
                arrayOf("a", true),
                arrayOf("", true)
            )
        }
    }
}