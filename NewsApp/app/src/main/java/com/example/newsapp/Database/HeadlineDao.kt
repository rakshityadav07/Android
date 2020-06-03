package com.example.newsapp.Database

import androidx.room.*
import com.example.newsapp.Models.Headline

@Dao
interface HeadlineDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertHeadline(headline: Headline)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    fun updateHeadline(headline: Headline)

    @Query("SELECT * FROM headline_table ORDER BY articles")
    fun getHeadline() : List<Headline>



}