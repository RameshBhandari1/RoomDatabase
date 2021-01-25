package com.example.roomdatabase.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.roomdatabase.entity.User

@Database(
    entities = [(User::class)],
    version = 1
)
abstract  class StudentDB : RoomDatabase (){

}