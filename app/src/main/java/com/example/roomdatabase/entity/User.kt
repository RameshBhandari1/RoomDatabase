package com.example.roomdatabase.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.roomdatabase.R

@Entity
data class User(
    var fname :String? = null,
    var lname :String? = null,
    var username :String? = null,
    var password :String? = null,
){
    @PrimaryKey(autoGenerate = true)
    var Id : Int? = 0
}