package com.example.newsapp

import androidx.room.*

@Dao
interface HeadlineDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertHeadline(headline: Headline)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    fun updateHeadline(headline: Headline)

    @Query("SELECT * FROM headline_table ORDER BY articles")
    fun getHeadline() : List<Headline>



}