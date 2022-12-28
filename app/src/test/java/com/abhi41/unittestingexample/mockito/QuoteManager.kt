package com.abhi41.unittestingexample.mockito

import android.content.Context
import android.content.res.AssetManager
import com.abhi41.unittestingexample.utils.QuoteManager
import com.nhaarman.mockitokotlin2.doReturn
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.mockito.ArgumentMatchers.anyString
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations

class QuoteManagerTest {

    @Mock
    lateinit var context: Context

    @Mock
    lateinit var assetManager: AssetManager

    @Before
    fun setup(){
        MockitoAnnotations.openMocks(this)
    }

    @Test
    fun test(){
        val testStream = QuoteManagerTest::class.java.getResourceAsStream("/quotes.json")
        doReturn(assetManager).`when`(context).assets
        Mockito.`when`(context.assets.open(anyString())).thenReturn(testStream)

        val sut = QuoteManager()
        sut.populateQuoteFromAssets(context,"")

        val quote = sut.getCurrentQuote()
        Assert.assertEquals("Genius is one percent inspiration and ninety-nine percent perspiration.",quote.text)
    }

}