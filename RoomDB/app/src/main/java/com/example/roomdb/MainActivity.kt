package com.example.roomdb

import android.content.Context
import android.os.Bundle
import android.text.Layout
import android.view.LayoutInflater
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.room.Room
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.view_dialog.view.*

class MainActivity : AppCompatActivity() {

    val db by lazy {
        Room.databaseBuilder(this,
            NoteDatabase :: class.java,
            "notesdb.db")
            .allowMainThreadQueries()
            .build()
    }

    val notesList = arrayListOf<Note>()

    lateinit var noteAdapter: NoteAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        notesList.addAll(db.noteDao().getNotes())

        noteAdapter = NoteAdapter(notesList,db)
        rvNotes.layoutManager = LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)
        rvNotes.adapter = noteAdapter

        floatingActionButton2.setOnClickListener {
            showCustomAlert()
        }


    }

    fun showCustomAlert() {

        val dialogView = layoutInflater.inflate(R.layout.view_dialog,null,false)

        val customAlertDialog = AlertDialog.Builder(this)
                .setTitle("Hello from the Custom Alert")
                .setPositiveButton("Ok"
                ) { dialog, _ ->
                    dialog.cancel()

                    val title = dialogView.etTitle.text.toString()
                    val subTitle = dialogView.etSubTitle.text.toString()
                    val note = Note(title,subTitle)
                    db.noteDao().insertNote(note)
                    notesList.add(note)
                    noteAdapter.notifyItemInserted(notesList.size - 1)
                }
                .setNegativeButton("Close"
                ) { dialog, _ ->
                    dialog.cancel()
                }
                .setView(dialogView)
                .create()

        customAlertDialog.show()

    }
}
