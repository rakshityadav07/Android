package com.example.roomdb.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.room.Room
import com.example.roomdb.R
import com.example.roomdb.`interface`.ClickHandler
import com.example.roomdb.database.NoteDatabase
import com.example.roomdb.models.Note
import com.example.roomdb.ui.adapter.ItemAdapter
import kotlinx.android.synthetic.main.activity_offline_notes.*

class OfflineNotes : AppCompatActivity() ,ClickHandler {

    private val offlineNotes = arrayListOf<Note>()

    val db by lazy {
        Room.databaseBuilder(this,
            NoteDatabase:: class.java,
            "notesdb.db")
            .allowMainThreadQueries()
            .build()
    }

    lateinit var userAdapter : ItemAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_offline_notes)

        userAdapter = ItemAdapter(offlineNotes,this)
        rvofflineNotes.layoutManager = LinearLayoutManager(this)
        rvofflineNotes.adapter = userAdapter

    }

    override fun handleClick(note : Note){
        Toast.makeText(this,"Upload started",Toast.LENGTH_LONG).show()
//       Upload the notes to server
    }

    override fun handleLongClick(note : Note){
        db.noteDao().deleteNote(note)
        offlineNotes.remove(note)
        userAdapter.notifyDataSetChanged()
    }

}