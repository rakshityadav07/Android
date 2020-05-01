package com.example.notesplanet;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    ArrayList<Note> noteArrayList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        For Date
//        Calendar c = Calendar.getInstance();
//        c.setTimeInMillis(System.currentTimeMillis());
//        c.getTime();

        RecyclerView recyclerView = findViewById(R.id.rvNotes);
        FloatingActionButton floatingActionButton = findViewById(R.id.fabAdd);

        /*Adapter   */
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        final NoteAdapter noteAdapter = new NoteAdapter(noteArrayList);
        recyclerView.setAdapter(noteAdapter);


        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Note note = new Note("Hello","world is beautiful",String.valueOf(System.currentTimeMillis()));
                noteArrayList.add(note);
//                noteAdapter.notifyDataSetChanged();
                noteAdapter.notifyItemInserted(noteArrayList.size()-1);
            }

        });

    }
}
