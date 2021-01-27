package com.example.roomdatabase.dao

import androidx.room.*
import com.example.roomdatabase.entity.User

@Dao
interface UserDAO {

    //Registration
    @Insert
    suspend fun registerUser(user: User)

    @Query("select * from User where username = (:username) and password=(:password)")
    suspend fun checkUser(username : String, password : String) : User
}