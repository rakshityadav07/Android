package com.example.recyclerviewnote;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Note> myList = new ArrayList<>();
    EditText etText;
    Button btnAdd;
    RecyclerView rvList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etText = findViewById(R.id.etText);
        btnAdd = findViewById(R.id.btnAdd);
        rvList = findViewById(R.id.rvList);

        rvList.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
        final NoteAdapter recyclerAdapter = new NoteAdapter(myList);
        rvList.setAdapter(recyclerAdapter);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = etText.getText().toString();
                if (name.matches("")) {
                    Toast.makeText(v.getContext(), "You did not enter a Title", Toast.LENGTH_LONG).show();
                    return;
                }
                Note list = new Note();
                list.setName(name);
                myList.add(list);
                recyclerAdapter.notifyDataSetChanged();
            }
        });

    }
}
