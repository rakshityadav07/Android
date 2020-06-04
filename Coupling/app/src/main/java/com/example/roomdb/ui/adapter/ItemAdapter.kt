package com.example.roomdb.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.roomdb.models.Note
import com.example.roomdb.R
import com.example.roomdb.`interface`.ClickHandler
import com.example.roomdb.ui.activity.OfflineNotes
import kotlinx.android.synthetic.main.item_row.view.*


class ItemAdapter(private val notes: ArrayList<Note>, private val handler: ClickHandler) : RecyclerView.Adapter<ItemAdapter.NoteViewHolder>() {

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
            handler.handleLongClick(currentNote)
            return@setOnLongClickListener true
        }

        holder.itemView.setOnClickListener {
           handler.handleClick(currentNote)
        }

//        holder.itemView.tvTitle.setText(currentNote.title)
//        or we can use this
        with(holder.itemView){
            tvTitle.text = currentNote.title
            tvSubTitle.text = currentNote.subTitle
        }


    }


    class NoteViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

}