package com.abhi41.unittestingexample.view_model

import android.content.Context
import androidx.lifecycle.ViewModel
import com.abhi41.unittestingexample.model.Quote
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import dagger.hilt.android.HiltAndroidApp
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import java.lang.reflect.Type
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    @ApplicationContext val context: Context
) : ViewModel() {
    private var quoteList: List<Quote> = emptyList()
    private var index = 0

    init {
        quoteList = loagQuoteFromAssets()
    }

    private fun loagQuoteFromAssets(): List<Quote> {
        val inputStream = context.assets.open("quotes.json")
        val size: Int = inputStream.available()
        val buffer = ByteArray(size)
        inputStream.read(buffer)

        val json = String(buffer, Charsets.UTF_8)
        val gson = Gson()
        val listType: Type = object : TypeToken<List<Quote>>() {}.type
        return gson.fromJson(json, listType)
    }

    fun getQuote() = quoteList[index]

    fun nextQuote(): Quote {
        return if (index == quoteList.size - 1) {
            quoteList[index]
        } else {
            quoteList[++index]
        }
    }

    fun previousQuote(): Quote {
        return if (index > 0) {
            quoteList[--index]
        } else {
            quoteList[index]
        }
    }
}