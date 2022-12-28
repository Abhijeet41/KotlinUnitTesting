package com.abhi41.unittestingexample.mockito_example

import com.abhi41.unittestingexample.utils.LOGIN_STATUS

class UserRepository {

    val users = listOf<User>(
        User(1, "John", "john@gmail.com", "2asdas1wq"),
        User(2, "Wein", "wein@gmail.com", "34dd3s2po"),
        User(3, "Emily", "emily@gmail.com", "1dfd2s12q"),
    )

    fun loginUser(email_id: String, password: String): LOGIN_STATUS {
        //Fetch User From DB
        val users = users.filter { user -> user.email_id == email_id }
        return if (users.size == 1) {
            if (users[0].password == password) {
                LOGIN_STATUS.SUCCESS
            } else {
                LOGIN_STATUS.INVALID_PASSWORD
            }
        } else {
            LOGIN_STATUS.INVALID_USER
        }
    }
}