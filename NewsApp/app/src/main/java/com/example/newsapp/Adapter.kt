package com.example.newsapp

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_row.view.*
import org.ocpsoft.prettytime.PrettyTime
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*


class Adapter(val article : ArrayList<Article>) : RecyclerView.Adapter<Adapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = parent.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val itemView = layoutInflater.inflate(R.layout.item_row,parent,false)
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val currentArticle = article[position]

        with(holder.itemView){
            tvTitle.text = currentArticle.title
            tvSource.text = currentArticle.source.name
            tvDate.text = dateTime(currentArticle.publishedAt)
        }

        val imageUrl = currentArticle.urlToImage

        Picasso.get().load(imageUrl).into(holder.itemView.image)

    }

    override fun getItemCount(): Int {
        return article.size
    }

    fun getCountry(): String? {
        val locale = Locale.getDefault()
        val country = locale.country
        return country.toLowerCase()
    }

    /*Change time using pretty time*/
    open fun dateTime(t: String?): String? {
        val prettyTime = PrettyTime(Locale(getCountry()))
        var time: String? = null
        try {
            val simpleDateFormat = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:", Locale.ENGLISH)
            val date = simpleDateFormat.parse(t)
            time = prettyTime.format(date)
        } catch (e: ParseException) {
            e.printStackTrace()
        }
        return time
    }


    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

}
