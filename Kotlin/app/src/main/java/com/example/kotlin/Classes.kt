package com.example.kotlin

class Note(val title : String = "",val desc : String = "",val time : String = ""){


}

class Notes constructor(val title : String,val desc : String,val time : String){

    constructor(desc: String) : this("",desc,"")

    constructor(desc: String, time: String) : this("",desc,time )

}

class noteBody(val title: String,val desc: String,val time: String){

    val note : Note

    init {
        note = Note(title,desc,time)
    }

}


