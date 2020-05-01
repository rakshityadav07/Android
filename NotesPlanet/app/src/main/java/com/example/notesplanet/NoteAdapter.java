package com.example.notesplanet;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.notesplanet.Note;
import com.example.notesplanet.R;


import java.util.ArrayList;

public class NoteAdapter extends RecyclerView.Adapter<NoteAdapter.NoteHolder> {

    private ArrayList<Note> noteArrayList;
    Context context;

    public NoteAdapter(ArrayList<Note> notes) {
        this.noteArrayList = notes;
    }

    //This is called for the number of times during which there is no view available for reuse
    @NonNull
    @Override
    public com.example.notesplanet.NoteAdapter.NoteHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        context = viewGroup.getContext();
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.item_row, viewGroup, false);
        return new NoteHolder(view);
    }

    //This is always called for every row
    @Override
    public void onBindViewHolder(@NonNull com.example.notesplanet.NoteAdapter.NoteHolder noteHolder, int position) {

        Note currentNote = noteArrayList.get(position);

        noteHolder.time.setText(currentNote.getDate());
        noteHolder.desc.setText(currentNote.getDescription());
        noteHolder.name.setText(currentNote.getTitle());
    }

    @Override
    public int getItemCount() {
        return noteArrayList.size();
    }

    public class NoteHolder extends RecyclerView.ViewHolder {

        TextView name, desc, time;
        LinearLayout rootLayout;

        public NoteHolder(@NonNull View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.tvName);
            desc = itemView.findViewById(R.id.tvDesc);
            time = itemView.findViewById(R.id.tvTime);
            rootLayout = itemView.findViewById(R.id.rootLayout);

            rootLayout.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    int position = getAdapterPosition();

                    Note itemToBeRemoved = noteArrayList.get(position);
//                    noteArrayList.remove(position);
//                    noteArrayList.add(itemToBeRemoved);
//                    notifyDataSetChanged();
                    notifyItemMoved(position,noteArrayList.size()-1);
                    return true;
                }
            });

            rootLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    int currentPos = getAdapterPosition();
                    Note currObj = noteArrayList.get(currentPos);

                    Toast.makeText(context,
                            "The clicked notes has the title : " + currObj.getTitle(),
                            Toast.LENGTH_SHORT).show();
                }
            });

        }
    }

}