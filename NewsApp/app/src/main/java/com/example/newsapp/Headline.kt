package com.example.newsapp

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey

@Entity(tableName = "Headline_Table")
data class Headline(
    @Embedded
    val articles: List<Article>,
    @Ignore val status: String,
    @Ignore val totalResults: Int,
    @PrimaryKey(autoGenerate = true) val id : Int = 0
)

@Entity
data class Article(
    val author: String?,
    val content: String?,
    val description: String,
    val publishedAt: String,
    @Embedded
    val source: Source,
    val title: String,
    val url: String,
    val urlToImage: String
)

data class Source(
    val id: Any?,
    val name: String
)