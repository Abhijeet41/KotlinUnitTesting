package com.abhi41.unittestingexample.utils

import org.junit.Assert
import org.junit.Assert.assertEquals
import org.junit.Test
import org.junit.runner.RunWith

import org.junit.runners.Parameterized
import org.junit.runners.Parameterized.Parameters

@RunWith(value = Parameterized::class)
class ParameterizedArmStrong(
    val number: Int,
    val expectedValue: Boolean
) {
    //check weather number is armstrong
    @Test
    fun test() {
        val helper = Helper()
        val result = helper.isArmStrongNumber(input = number)
        println(result)
        assertEquals(expectedValue, result)
    }

    companion object {
        @JvmStatic
        @Parameters(name = "{index} : {0} is armstrong - {1}")
        fun armStrongData(): List<Array<Any>> {
            return listOf(
                arrayOf(153, true)
                /*  arrayOf(25,false),
                  arrayOf(5,false),
                  arrayOf(0,true)*/
            )
        }
    }
}