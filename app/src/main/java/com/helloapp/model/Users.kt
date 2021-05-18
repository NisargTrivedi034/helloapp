package com.helloapp.model

data class Users(var name:String) {
    var userName : String = ""
    init {
        userName = name
    }
}