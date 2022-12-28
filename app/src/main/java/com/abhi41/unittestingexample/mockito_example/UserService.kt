package com.abhi41.unittestingexample.mockito_example

import com.abhi41.unittestingexample.utils.LOGIN_STATUS

class UserService(private val userRepository: UserRepository) {

    fun loginUser(email: String, password: String): String {
        val status = userRepository.loginUser(email, password)
        return when (status) {
            LOGIN_STATUS.INVALID_USER -> "User does not exist"
            LOGIN_STATUS.INVALID_PASSWORD -> "Password is invalid"
            LOGIN_STATUS.UNKNOWN_ERROR -> "unknown error occurred"
            LOGIN_STATUS.SUCCESS -> "Logged in successfully"
        }
    }

}