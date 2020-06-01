package com.example.newsapp

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [Headline::class],version = 1)
abstract class HeadlineDatabase : RoomDatabase() {

    abstract fun headlineDao() : HeadlineDao

}