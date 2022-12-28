package com.abhi41.unittestingexample.local

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import app.cash.turbine.test
import com.abhi41.unittestingexample.local.dao.QuotesDao
import com.abhi41.unittestingexample.local.database.QuoteDatabase
import com.abhi41.unittestingexample.utils.getOrAwaitValue
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import org.junit.*
import javax.inject.Inject

@HiltAndroidTest
class QuotesDaoFlowTest {

    @get:Rule  //we need this for getOrAwaitValue method to execute tasks synchronously.
    val instantExecutorRule = InstantTaskExecutorRule()

    @get:Rule
    val hiltAndroidRule = HiltAndroidRule(this)

    @Inject
    lateinit var quoteDatabase: QuoteDatabase
    lateinit var quotesDao: QuotesDao

    @Before
    fun setUp() {
        hiltAndroidRule.inject()
/*        quoteDatabase = Room.inMemoryDatabaseBuilder(
            ApplicationProvider.getApplicationContext(),
            QuoteDatabase::class.java
        ).allowMainThreadQueries().build()*/
        quotesDao = quoteDatabase.quoteDao()
    }

    @Test
    fun insertQuote_expectedSingleQuote() = runBlocking {
        val quote = Quote(0, "This is a test quote", "CheeztQuote")
        val quote2 = Quote(0, "This is a test quote2", "CheeztQuote2")

        quotesDao.insertQuotes(quote)

        launch {
            delay(500)
            quotesDao.insertQuotes(quote2)
        }

        val result = quotesDao.getQuotesFlow().first()
        Assert.assertEquals(1, result.size)
        Assert.assertEquals("This is a test quote", result[0].text)


        //receive multiple items
        val result2 = quotesDao.getQuotesFlow().test {
            val quoteList = awaitItem()
            Assert.assertEquals(1, quoteList.size)
            val quoteList2 = awaitItem()
            Assert.assertEquals(2, quoteList2.size)
            cancel()
        }

    }

    @Test
    fun deleteQuote_expectedNoResults() = runBlocking {
        val quote = Quote(0, "This is a test quote", "CheeztQuote")
        quotesDao.insertQuotes(quote)
        quotesDao.delete()

        val result = quotesDao.getQuotes().getOrAwaitValue()
        Assert.assertEquals(0, result.size)

    }

    @After
    fun tearDown() {
        quoteDatabase.close()
    }

}