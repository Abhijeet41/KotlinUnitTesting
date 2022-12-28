package com.abhi41.unittestingexample.utils

import android.content.Context
import com.abhi41.unittestingexample.model.Quote
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.lang.reflect.Type


class QuoteManager {

    var quoteList = emptyList<Quote>()

    // var quoteArryList = emptyArray<Quote>()
    var currentQuoteIndex = 0

    fun populateQuoteFromAssets(context: Context, fileName: String) {
        val inputStream = context.assets.open(fileName)
        val size: Int = inputStream.available()
        val buffer = ByteArray(size)
        inputStream.read(buffer)
        inputStream.close()
        val json = String(buffer, Charsets.UTF_8)
        val gson = Gson()
        val listType: Type = object : TypeToken<List<Quote>>() {}.type
        quoteList = gson.fromJson(json, listType)
        // quoteArryList = gson.fromJson(json, Array<Quote>::class.java)
    }

    fun populateQuotes(quotes: List<Quote>) {
        quoteList = quotes
    }

    fun getCurrentQuote(): Quote {
        return quoteList[currentQuoteIndex]
    }

    fun getNextQuote(): Quote {
        if (currentQuoteIndex == quoteList.size - 1) {
            return quoteList[currentQuoteIndex]
        } else {
            return quoteList[++currentQuoteIndex]
        }
    }

    fun getPreviousQuote(): Quote {
        if (currentQuoteIndex == 0){
            return quoteList[currentQuoteIndex]
        } else {
            return quoteList[--currentQuoteIndex]
        }
    }

}