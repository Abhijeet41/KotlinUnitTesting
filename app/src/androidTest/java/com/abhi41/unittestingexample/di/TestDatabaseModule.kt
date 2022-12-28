package com.abhi41.foodrecipe.di

import android.content.Context
import androidx.room.Room
import com.abhi41.unittestingexample.di.DatabaseModule
import com.abhi41.unittestingexample.local.database.QuoteDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import dagger.hilt.testing.TestInstallIn
import javax.inject.Singleton

@TestInstallIn(components = [SingletonComponent::class], replaces = [DatabaseModule::class])
@Module
class TestDatabaseModule {

    @Provides
    @Singleton
    fun provideTestDB(@ApplicationContext context: Context):QuoteDatabase {
        return Room.inMemoryDatabaseBuilder(
            context,
            QuoteDatabase::class.java
        ).allowMainThreadQueries().build()
    }

}