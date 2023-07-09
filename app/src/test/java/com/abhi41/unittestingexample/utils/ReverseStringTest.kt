package com.abhi41.unittestingexample.utils

import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotEquals
import org.junit.Test
import java.lang.IllegalArgumentException


class ReverseStringTest {

    @Test
    fun checkValidReverseTest(){
        val result = Helper().reverseString("abhijeet")
        assertEquals("teejihba",result)
    }

    @Test
    fun `invalid reverse test`(){
        val result = Helper().reverseString("abhijeet")
        assertNotEquals("asldj",result)
    }

    @Test
    fun checkEmptyTest(){
        val result = Helper().reverseString("")
        assertEquals("",result)
    }

    @Test
    fun checkSingleCharTest(){
        val result = Helper().reverseString("s")
        assertEquals("s",result)
    }

    @Test(expected = IllegalArgumentException::class)
    fun testStringReversalNullCheck(){
        val result = Helper().reverseString(null)
    }


}