package com.abhi41.unittestingexample.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.abhi41.unittestingexample.local.Quote
import com.abhi41.unittestingexample.local.dao.QuotesDao

@Database(entities = [Quote::class], version = 1)
abstract class QuoteDatabase : RoomDatabase(){

    abstract fun quoteDao(): QuotesDao

}

/*
    Note we don't need to write test cases for database class and entity class,there is
    no sense to write test cases for them Its created by google.
    we need test cases for dao class because we define our queries
 */