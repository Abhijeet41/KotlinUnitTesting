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

    fun reverseString(input: String?): String {
        if (input == null){
            throw IllegalArgumentException("Input string is required")
        }
        var chars = input.toCharArray()
        var i = 0
        var lastIndex = chars.size - 1
        while (i < lastIndex) {
            val firstIndex = chars[i]
            chars[i] = chars[lastIndex]
            chars[lastIndex] = firstIndex
            i++
            lastIndex--
        }
        return chars.joinToString("")
    }

    fun isArmStrongNumber(input: Int): Boolean {
        /*  153
            1*1*1 + 5*5*5 + 3*3*3
            1 + 125 + 27  = 153
        */
        var armStrong: Int = 0
        var result: Int
        var original:Int = input
        val cube = 3
        var isArmStrong = false
        while (original >= 0){   //153,15,1
            result = original % 10 // 3
            result = Math.pow(result.toDouble(),cube.toDouble()).toInt() // 27
            armStrong += result
            original = original / 10 //153 /10 = 15
        }
        if (armStrong == input){
            isArmStrong = true
        }else{
            isArmStrong = false
        }
        return isArmStrong
    }

}