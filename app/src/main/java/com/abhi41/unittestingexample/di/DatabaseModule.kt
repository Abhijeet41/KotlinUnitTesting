package com.abhi41.unittestingexample.di

import android.content.Context
import androidx.room.Room
import com.abhi41.unittestingexample.local.database.QuoteDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Singleton
    @Provides
    fun provideDatabase(
        @ApplicationContext context: Context  // dagger provide us context to use this for creation of builder
    ) = Room.databaseBuilder(
        context,
        QuoteDatabase::class.java,
        "FakerDB"
    ).fallbackToDestructiveMigration().build()

    @Singleton
    @Provides
    fun provideDao(database: QuoteDatabase) = database.quoteDao()

}