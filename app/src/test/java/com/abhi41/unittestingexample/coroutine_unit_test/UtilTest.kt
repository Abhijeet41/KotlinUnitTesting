package com.abhi41.unittestingexample.coroutine_unit_test

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.Assert.*

import org.junit.After
import org.junit.Assert
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class UtilTest {

    @get:Rule
    val mainCoroutineRule = MainCoroutineRule()

    //In this we don't have any main dispatchers thats why we used StandardTestDispatcher
   // private val testDispatchers = StandardTestDispatcher()

/*    @Before   //to get rid of this before and after we should define rule
    fun setUp() {
        Dispatchers.setMain(testDispatchers)
    }*/

    @Test
    fun testGetUserName(){
        val sut = Util(mainCoroutineRule.testDispathcer)

        runTest {
            sut.getUserName()
        }
    }
    @Test
    fun testGetUser(){
        val sut = Util(mainCoroutineRule.testDispathcer)
        runTest {
            sut.getUser()
        }
    }

    @Test
    fun testAddress(){
        val sut = Util(mainCoroutineRule.testDispathcer)
        runTest {
            sut.getAddress()
        }
    }

    @Test
    fun exampleAdvanceUntilIdle(){
        val sut = Util(mainCoroutineRule.testDispathcer)
        runTest {

            //inside coroutine value not has been set becase we need advanceuntilidle for that
            sut.getGlobalArgs()
            //with the help of advanceUntilIdle we will able to execute coroutine dispatchers
            mainCoroutineRule.testDispathcer.scheduler.advanceUntilIdle()
            assertEquals(true,sut.globalArg)
        }
    }

  /*  @After
    fun tearDown() {
        Dispatchers.resetMain()
    }*/
}