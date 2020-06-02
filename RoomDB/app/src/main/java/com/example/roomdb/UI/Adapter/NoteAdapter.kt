package com.example.roomdb.UI.Adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.roomdb.Models.Note
import com.example.roomdb.Database.NoteDatabase
import com.example.roomdb.R
import com.example.roomdb.UI.Activity.EditActivity
import kotlinx.android.synthetic.main.item_row.view.*


class NoteAdapter(private val notes : ArrayList<Note>, private val db : NoteDatabase) : RecyclerView.Adapter<NoteAdapter.NoteViewHolder>() {

    lateinit var context: Context

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {

        context = parent.context
        return NoteViewHolder(LayoutInflater.from(context).inflate(R.layout.item_row, parent, false))
    }

    override fun getItemCount(): Int {
        return notes.size
    }

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {

        val currentNote = notes[position]

        holder.itemView.setOnLongClickListener {
            deleteNote(db,position)
        }

        holder.itemView.setOnClickListener {
            val i = Intent(context,EditActivity::class.java)
            i.putExtra("ID",currentNote.id)
            context.startActivity(i)
        }

//        holder.itemView.tvTitle.setText(currentNote.title)
//        or we can use this
        with(holder.itemView){
            tvTitle.text = currentNote.title
            tvSubTitle.text = currentNote.subTitle
        }


    }

    private fun deleteNote(db : NoteDatabase, position: Int): Boolean {
        val currentNote = notes[position]
        db.noteDao().deleteNote(currentNote)
        notes.removeAt(position)
        notifyItemRemoved(position)
        return true
    }

    class NoteViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

}