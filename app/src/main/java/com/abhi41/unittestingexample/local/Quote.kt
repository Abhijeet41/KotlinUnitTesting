package com.abhi41.unittestingexample.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Quote(
    @PrimaryKey(autoGenerate = true)
    val id:Int,
    val text: String,
    val author: String
)