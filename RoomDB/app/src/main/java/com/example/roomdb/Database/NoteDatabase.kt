package com.example.roomdb.Database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.roomdb.Models.Note

@Database(entities = [Note:: class] , version = 1)
abstract class NoteDatabase : RoomDatabase() {

    abstract fun noteDao() : NotesDao


}