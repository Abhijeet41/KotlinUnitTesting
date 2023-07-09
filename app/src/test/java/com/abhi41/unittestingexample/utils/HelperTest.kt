package com.abhi41.unittestingexample.utils

import org.junit.After
import org.junit.Assert.*
import org.junit.Before

import org.junit.Test

class HelperTest {

    //so the use of parameterized testing is we can test multiple values in single testcase

    lateinit var helper: Helper

    @Before
    fun setup(){
        helper = Helper()
        println("Before Every Test Case")
    }

    @After
    fun tearDown(){
        println("After Every Test Case")
    }

    @Test
    fun isPallindrome() {
        //Arrange
      //  val helper = Helper()
        //Act
        val result = helper.isPallindrome("hello")
        //Assert
        //we know hello is not Pallindrome text that's why we define asserEquals false
        assertEquals(false,result)
        //assertNotEquals() we have different variation
    }

    @Test
    fun isPallindrome_Expected_True() {
        //Arrange
       // val helper = Helper()
        //Act
        val result = helper.isPallindrome("level")
        //Assert
        //we know level is  Pallindrome text thats why we define asserEquals true
        assertEquals(true,result)
        //assertNotEquals() we have different variation
    }
}