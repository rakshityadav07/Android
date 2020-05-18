package com.example.roomdb

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "note_table")
class Note(
    @ColumnInfo(name = "column_title") val title : String,
    val subTitle : String,
    @PrimaryKey(autoGenerate = true) val id : Int = 0 )


@Entity
class User(val name : String,
           val surName : String)