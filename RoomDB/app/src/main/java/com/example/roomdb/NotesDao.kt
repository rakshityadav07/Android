package com.example.roomdb

import androidx.room.*

@Dao
interface NotesDao {

    @Insert
    fun insertNote(note: Note)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertMultipleNotes(note: List<Note>)

    @Update
    fun updateNote(note: Note)

    @Delete
    fun deleteNote(note: Note)

    @Query("SELECT * FROM note_table ORDER BY id DESC")
    fun getNotes() : List<Note>

    @Query("SELECT * FROM note_table WHERE id = :noteId")
    fun getNoteById(noteId : Int) : Note

}