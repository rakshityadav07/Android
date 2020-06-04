package com.example.roomdb.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.room.Room
import com.example.roomdb.database.NoteDatabase
import com.example.roomdb.R
import kotlinx.android.synthetic.main.activity_edit.*

class EditActivity : AppCompatActivity() {

    /*We take the note from the database*/
    val db by lazy {
        Room.databaseBuilder(this,
            NoteDatabase:: class.java,
            "notesdb.db")
            .allowMainThreadQueries()
            .build()
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit)

        /*Here we extarcted the id from the current note and opened a new activty*/
        val id = intent.getIntExtra("ID",0)
        /*we change the data from the note by having the id*/
        val note = db.noteDao().getNoteById(id)
        etTitleEdit.setText(note.title,TextView.BufferType.EDITABLE)
        etSubTitleEdit.setText(note.subTitle,TextView.BufferType.EDITABLE)


        fabSave.setOnClickListener {
            /*Here we change the etTitleEdit and etSubtitleEdit from above and set it in title and Subtitle */
            note.title = etTitleEdit.text.toString()
            note.subTitle = etSubTitleEdit.text.toString()
            db.noteDao().updateNote(note)
            finish()
        }

    }



}