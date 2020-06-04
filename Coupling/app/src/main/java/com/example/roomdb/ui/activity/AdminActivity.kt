package com.example.roomdb.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.roomdb.R
import com.example.roomdb.`interface`.ClickHandler
import com.example.roomdb.models.Note
import com.example.roomdb.ui.adapter.ItemAdapter

class AdminActivity : AppCompatActivity() ,ClickHandler{

    private val notes = arrayListOf<Note>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_admin)

        val adapter = ItemAdapter(notes,this)

    }

    override fun handleClick(note: Note) {
        TODO("Not yet implemented")
    }

    override fun handleLongClick(note: Note) {
        TODO("Not yet implemented")
    }


}