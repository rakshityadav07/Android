package com.example.jsonparsing;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ResponseAdapter extends RecyclerView.Adapter<ResponseAdapter.ResponseViewholder> {

    ArrayList<Response> responses ;

    public ResponseAdapter(ArrayList<Response> responses) {
        this.responses = responses;
    }

    @NonNull
    @Override
    public ResponseViewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater li = (LayoutInflater) parent.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View itemView = li.inflate(R.layout.string_row,parent,false);
        return new ResponseViewholder(itemView);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull ResponseViewholder holder, int position) {
        holder.tvName.setText(responses.get(position).getUser().getName().getFirst() + responses.get(position).getUser().getName().getLast());
        holder.tvString.setText(responses.get(position).getText());
    }

    @Override
    public int getItemCount() {
        return responses.size();
    }


    class ResponseViewholder extends RecyclerView.ViewHolder{
        TextView tvString,tvName;

        public ResponseViewholder(@NonNull View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.tvName);
            tvString = itemView.findViewById(R.id.tvString);
        }
    }
}
