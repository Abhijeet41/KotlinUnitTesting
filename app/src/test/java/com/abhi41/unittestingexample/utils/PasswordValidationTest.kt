package com.abhi41.unittestingexample.utils

import org.junit.Assert.*

import org.junit.Test

class PasswordValidationTest {

    @Test
    fun validPassword_blankInput_expectedReuiredField() {
        val sut = Helper()
        val result = sut.validPassword("  ")
        assertEquals(  "Password should not be blank",result)
    }

    @Test
    fun validPassword_2CharInput_expectedValidationMsg() {
        val sut = Helper()
        val result = sut.validPassword("ab")
        assertEquals("Length of password should be greater than 6",result)
    }

    @Test
    fun validPassword_CorrentInput_expectedValidPassword() {
        val sut = Helper()
        val result = sut.validPassword("Password@123")
        assertEquals("Valid",result)
    }
}