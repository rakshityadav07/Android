package com.example.roomdb.`interface`

import com.example.roomdb.models.Note

interface ClickHandler {

    fun handleClick(note : Note)

    fun handleLongClick(note : Note)

}