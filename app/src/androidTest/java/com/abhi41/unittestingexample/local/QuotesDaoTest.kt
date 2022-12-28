package com.abhi41.unittestingexample.local

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import com.abhi41.unittestingexample.local.dao.QuotesDao
import com.abhi41.unittestingexample.local.database.QuoteDatabase
import com.abhi41.unittestingexample.utils.getOrAwaitValue
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Assert
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import javax.inject.Inject

@HiltAndroidTest
class QuotesDaoTest {
     /*
        Our test cases we need to run in isolation means if we run one test case it should no
        impact on another test case. we should run it independently.
        we need our new database to test for that we need dummy database and it will be run
        in memory (InMemory Database)
      */
    @get:Rule  //we need this for getOrAwaitValue method to execute tasks synchronously.
    val instantExecutorRule = InstantTaskExecutorRule()
    @get:Rule
    val hiltAndroidRule = HiltAndroidRule(this)

    @Inject
    lateinit var quoteDatabase: QuoteDatabase
    lateinit var quotesDao: QuotesDao

    @Before
    fun setUp(){
        hiltAndroidRule.inject()
/*        quoteDatabase = Room.inMemoryDatabaseBuilder(
            ApplicationProvider.getApplicationContext(),
            QuoteDatabase::class.java
        ).allowMainThreadQueries().build()*/
        quotesDao = quoteDatabase.quoteDao()
    }

    @Test
    fun insertQuote_expectedSingleQuote() = runBlocking {
        val quote = Quote(0,"This is a test quote","CheeztQuote")
        quotesDao.insertQuotes(quote)

        val result = quotesDao.getQuotes().getOrAwaitValue()
        Assert.assertEquals(1,result.size)
        Assert.assertEquals("This is a test quote",result[0].text)
    }

    @Test
    fun deleteQuote_expectedNoResults() = runBlocking {
        val quote = Quote(0,"This is a test quote","CheeztQuote")
        quotesDao.insertQuotes(quote)
        quotesDao.delete()

        val result = quotesDao.getQuotes().getOrAwaitValue()
        Assert.assertEquals(0,result.size)

    }

    @After
    fun tearDown(){
        quoteDatabase.close()
    }
}