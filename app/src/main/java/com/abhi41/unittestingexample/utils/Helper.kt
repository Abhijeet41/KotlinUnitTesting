package com.abhi41.unittestingexample.utils

class Helper {

    fun isPallindrome(input: String): Boolean {
        var i = 0
        var lastIndex = input.length - 1

        var result = true

        while (i < lastIndex) {
            if (input[i] != input[lastIndex]) {
                result = false
                break
            }
            i++
            lastIndex--
        }
        return result
    }

    fun validPassword(input: String) = when {

        input.isBlank() -> {
            "Password should not be blank"
        }
        input.length < 6 -> {
            "Length of password should be greater than 6"
        }
        input.length > 15 -> {
            "Length of password should be less than 15"
        }
        else -> {
            "Valid"
        }
    }

    fun reverseString(input: String): String {
        var chars = input.toCharArray()
        var i = 0
        var lastIndex = chars.size - 1
        while (i<lastIndex){
            val temp = chars[i]
            chars[i] = chars[lastIndex]
            chars[lastIndex] = temp
            i++
            lastIndex--
        }
        return chars.joinToString("")
    }

}