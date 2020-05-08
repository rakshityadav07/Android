package com.example.restrofitgsonapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import java.util.ArrayList;

public class GsonAdapter extends RecyclerView.Adapter<GsonAdapter.gsonViewholder> {

    ArrayList<User> users;

    public void setUsers(ArrayList<User> users) {
        this.users = users;
        notifyDataSetChanged();
    }

    public GsonAdapter(ArrayList<User> users) {
        this.users = users;
    }

    @NonNull
    @Override
    public gsonViewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = (LayoutInflater) parent.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View itemView  = layoutInflater.inflate(R.layout.string_row,parent,false);
        return new gsonViewholder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull gsonViewholder holder, int position) {
        holder.tvName.setText(users.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return users.size() ;
    }


    class gsonViewholder extends RecyclerView.ViewHolder{

        TextView tvName;

        public gsonViewholder(@NonNull View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.tvName);
        }
    }


}
