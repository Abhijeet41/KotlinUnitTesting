package com.abhi41.unittestingexample.coroutine_unit_test

import kotlinx.coroutines.*

class Util(val dispatcher: CoroutineDispatcher) {

    suspend fun getUserName(): String{
        delay(10000)
        return "CheezyCode"
    }

    suspend fun getUser(): String{
        CoroutineScope(Dispatchers.IO).launch {
            delay(2000)
        }
        return "User - CheezyCode"
    }

    suspend fun getAddress():String{
        withContext(dispatcher){
            delay(5000)
        }
        return "Alpesh Apartment"
    }

    //this is an example of advanceUntilIdle
    var globalArg = false
    fun getGlobalArgs(){
        CoroutineScope(dispatcher).launch {
            globalArg = true
        }
    }
}