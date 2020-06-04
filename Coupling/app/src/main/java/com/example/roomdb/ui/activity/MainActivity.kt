package com.example.roomdb.ui.activity

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.room.Room
import com.example.roomdb.models.Note
import com.example.roomdb.ui.adapter.ItemAdapter
import com.example.roomdb.database.NoteDatabase
import com.example.roomdb.R
import com.example.roomdb.`interface`.ClickHandler
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.view_dialog.view.*

class MainActivity : AppCompatActivity() ,ClickHandler {

    val db by lazy {
        Room.databaseBuilder(this,
            NoteDatabase:: class.java,
            "notesdb.db")
            .allowMainThreadQueries()
            .build()
    }

    val notesList = arrayListOf<Note>()
    lateinit var itemAdapter: ItemAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        notesList.addAll(db.noteDao().getNotes())

        itemAdapter = ItemAdapter(notesList,this)
        rvNotes.layoutManager = LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)
        rvNotes.adapter = itemAdapter

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
                    val note = Note(title, subTitle)

                    /*Get the ID of the inserted note*/
                    val id = db.noteDao().insertNote(note)
                    /*Update the note object so that it has an ID*/
                    note.id = id.toInt()

                    notesList.add(0,note)
                    rvNotes.smoothScrollToPosition(0)
                    itemAdapter.notifyItemInserted(0)
                }
                .setNegativeButton("Close"
                ) { dialog, _ ->
                    dialog.cancel()
                }
                .setView(dialogView)
                .create()

        customAlertDialog.show()

    }

    override fun onResume() {
        super.onResume()
        notesList.clear()
        notesList.addAll(db.noteDao().getNotes())
        itemAdapter.notifyDataSetChanged()
    }

    override fun handleClick(note : Note){
        val i = Intent(this,EditActivity::class.java)
        i.putExtra("ID",note.id)
        startActivity(i)
    }

    override fun handleLongClick(note : Note){
        db.noteDao().deleteNote(note)
        notesList.remove(note)
        itemAdapter.notifyDataSetChanged()
    }


}
