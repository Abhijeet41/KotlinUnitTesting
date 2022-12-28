package com.abhi41.unittestingexample.utils

import android.content.Context
import androidx.test.core.app.ApplicationProvider
import com.abhi41.unittestingexample.model.Quote
import com.google.gson.JsonSyntaxException
import org.junit.Assert.*

import org.junit.After
import org.junit.Before
import org.junit.Test
import java.io.FileNotFoundException

class QuoteManagerTest {


    //to test if we passed file name empty
    @Test(expected = FileNotFoundException::class)
    fun populateQuoteFromAssets() {
        val quoteManager = QuoteManager()
        val context = ApplicationProvider.getApplicationContext<Context>()
        quoteManager.populateQuoteFromAssets(context, "")
    }

    @Test(expected = JsonSyntaxException::class)
    fun testpopulateQuoteFromAssets_InvalidJson_expected() {
        val quoteManager = QuoteManager()
        val context = ApplicationProvider.getApplicationContext<Context>()
        quoteManager.populateQuoteFromAssets(context, "malformed.json")
    }

    @Test
    fun testpopulateQuoteFromAssets_ValidJson_expected() {
        val quoteManager = QuoteManager()
        val context = ApplicationProvider.getApplicationContext<Context>()
        quoteManager.populateQuoteFromAssets(context, "quotes.json")
    }

    @Test
    fun testpopulateQuoteFromAssets_ValidJson_expected_count() {
        val quoteManager = QuoteManager()
        val context = ApplicationProvider.getApplicationContext<Context>()
        quoteManager.populateQuoteFromAssets(context, "quotes.json")
        assertEquals(9,quoteManager.quoteList.size)
    }

    @Test
    fun testPreviousQuote_expected_Correct() {
        //arrange
        val quoteManager = QuoteManager()
        quoteManager.populateQuotes(
            listOf(
                Quote("This is first quote","1"),
                Quote("This is first quote","2"),
                Quote("This is first quote","3"),
            )
        )
        //Act
        val quote = quoteManager.getPreviousQuote()
        //Assert
        assertEquals("1",quote.author)
    }

    @Test
    fun testNextQuote_expected_Correct() {
        //arrange
        val quoteManager = QuoteManager()
        quoteManager.populateQuotes(
            listOf(
                Quote("This is first quote","1"),
                Quote("This is first quote","2"),
                Quote("This is first quote","3"),
            )
        )
        //Act
        val quote = quoteManager.getNextQuote()
        //Assert
        assertEquals("2",quote.author)
    }

}