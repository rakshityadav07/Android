package com.example.roomdb.database

import androidx.room.*
import com.example.roomdb.models.Note

@Dao
interface NotesDao {

    @Insert
    fun insertNote(note: Note) : Long

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertMultipleNotes(note: List<Note>) : List<Long>

    @Update
    fun updateNote(note: Note)

    @Delete
    fun deleteNote(note: Note)

    @Query("SELECT * FROM note_table ORDER BY id DESC")
    fun getNotes() : List<Note>

    @Query("SELECT * FROM note_table WHERE id = :noteId")
    fun getNoteById(noteId : Int) : Note

}