package com.example.newsapp.Database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.newsapp.Models.Headline

@Database(entities = [Headline::class],version = 1)
abstract class HeadlineDatabase : RoomDatabase() {

    abstract fun headlineDao() : HeadlineDao

}