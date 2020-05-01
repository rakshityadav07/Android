package com.example.recyclerviewnote;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class NoteAdapter extends RecyclerView.Adapter<NoteAdapter.NotesViewHolder> {

    ArrayList<Note> myList;

    public NoteAdapter(ArrayList<Note> myList) {
        this.myList = myList;
    }

    @NonNull
    @Override
    public NotesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater li = (LayoutInflater) parent.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View itemView = li.inflate(R.layout.string_row,parent,false);
        return new NotesViewHolder(itemView);
    }


    @Override
    public void onBindViewHolder(@NonNull NotesViewHolder holder, int position) {
        holder.tvText.setText(myList.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return myList.size();
    }

    class NotesViewHolder extends RecyclerView.ViewHolder{
        TextView tvText;
        public NotesViewHolder(@NonNull View itemView) {
            super(itemView);
            tvText = itemView.findViewById(R.id.tvText);
        }
    }


}
