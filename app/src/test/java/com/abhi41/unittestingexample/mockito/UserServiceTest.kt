package com.abhi41.unittestingexample.mockito

import com.abhi41.unittestingexample.mockito_example.UserRepository
import com.abhi41.unittestingexample.mockito_example.UserService
import com.abhi41.unittestingexample.utils.LOGIN_STATUS
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.mockito.ArgumentMatchers.anyString
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations

class UserServiceTest {

    @Mock
    lateinit var userRepository: UserRepository

    @Before
    fun setup() {
        MockitoAnnotations.openMocks(this)
        Mockito.`when`(userRepository.loginUser(anyString(), anyString()))
            .thenReturn(LOGIN_STATUS.INVALID_PASSWORD)
    }

    @Test
    fun testUserService() {
        val sut = UserService(userRepository)
        val status = sut.loginUser("acb@gmail.com", "111111")
        Assert.assertEquals("Password is invalid", status)
    }
}