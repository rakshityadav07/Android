//package com.example.jsonparsing
//
//import android.content.Context
//import android.util.Log
//import android.view.LayoutInflater
//import android.view.View
//import android.view.ViewGroup
//import androidx.recyclerview.widget.RecyclerView
//import kotlinx.android.synthetic.main.string_row.view.*
//
//open class ResponseAdapter(responses: ArrayList<Response>) : RecyclerView.Adapter<ResponseAdapter.JsonViewHolder>() {
//
//    val responses  = arrayListOf<Response>()
//
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): JsonViewHolder {
//        val layoutInflater : LayoutInflater = parent.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
//        val view = layoutInflater.inflate(R.layout.string_row,parent,false)
//        return JsonViewHolder(view)
//    }
//
//    override fun onBindViewHolder(holder: JsonViewHolder, position: Int) {
//        holder.tvName.text = responses[position].user.name.first
//        holder.tvString.text = responses[position].text
//    }
//
//    override fun getItemCount(): Int {
//        return responses.size
//    }
//
//    class JsonViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
//        val tvString = itemView.tvString
//        val tvName = itemView.tvName
//    }
//
//}