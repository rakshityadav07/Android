package com.example.roomdb

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_row.view.*


class NoteAdapter(private val notes : ArrayList<Note>,val db : NoteDatabase) : RecyclerView.Adapter<NoteAdapter.NoteViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {

        val layoutInflater = parent.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val itemView = layoutInflater.inflate(R.layout.item_row,parent,false)
        return NoteViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return notes.size
    }

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {

        val currentNote = notes[position]

        holder.itemView.setOnLongClickListener {
            deleteNote(db,position)
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