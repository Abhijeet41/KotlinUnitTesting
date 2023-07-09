package com.abhi41.unittestingexample.local.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.abhi41.unittestingexample.local.Quote
import kotlinx.coroutines.flow.Flow

@Dao
interface QuotesDao {

    @Insert
    suspend fun insertQuotes(quote: Quote)
    @Update
    suspend fun updateQuote(quote: Quote)
    @Query("DELETE FROM quote")
    suspend fun delete()
    @Query("SELECT * FROM quote")
    fun getQuotes(): LiveData<List<Quote>>
    @Query("SELECT * FROM quote")
    fun getQuotesFlow(): Flow<List<Quote>>
    @Query("SELECT * FROM quote where id = :quoteId")
    suspend fun getQuoteById(quoteId: Int): Quote
}