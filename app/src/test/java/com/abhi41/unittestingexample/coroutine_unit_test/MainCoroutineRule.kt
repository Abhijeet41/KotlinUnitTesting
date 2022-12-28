package com.abhi41.unittestingexample.coroutine_unit_test

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.setMain
import org.junit.rules.TestWatcher
import org.junit.runner.Description

class MainCoroutineRule: TestWatcher() {
    val testDispathcer = StandardTestDispatcher()

    override fun starting(description: Description?) {
        super.starting(description)
        Dispatchers.setMain(testDispathcer)
    }

    override fun finished(description: Description?) {
        super.finished(description)
        Dispatchers.resetMain()
    }
}