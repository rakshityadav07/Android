package com.example.roomdb.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.roomdb.models.Note

@Database(entities = [Note:: class] , version = 1)
abstract class NoteDatabase : RoomDatabase() {

    abstract fun noteDao() : NotesDao


}