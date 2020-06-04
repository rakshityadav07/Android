package com.example.roomdb.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "note_table")
class Note(
    @ColumnInfo(name = "column_title") var title : String,
    var subTitle : String,
    @PrimaryKey(autoGenerate = true) var id : Int = 0 )


//@Entity
//class User(val name : String,
//           val surName : String)