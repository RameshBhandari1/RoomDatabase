package com.example.roomdatabase

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.example.roomdatabase.db.StudentDB
import com.example.roomdatabase.entity.User
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var etusername : EditText
    private lateinit var etpassword : EditText
    private lateinit var btnlogin : Button
    private lateinit var tvsignup : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        etusername = findViewById(R.id.etusername)
        etpassword = findViewById(R.id.etpassword)
        btnlogin = findViewById(R.id.btnlogin)
        tvsignup = findViewById(R.id.tvsignup)

        btnlogin.setOnClickListener(this)
        tvsignup.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v?.id){
            R.id.btnlogin->{
                login()
            }
            R.id.tvsignup->{
                val intent = Intent(
                    this,
                    RegisterActivity::class.java
                )
                startActivity(intent)
            }
        }
    }
     fun login(){
        val username = etusername.text.toString()
        val password = etpassword.text.toString()

        var user: User? = null
        CoroutineScope(Dispatchers.IO).launch {
            user = StudentDB
                .getInstance(this@MainActivity)
                .getUserDAO()
                .checkUser(username,password)
            if(user == null){
                withContext(Dispatchers.Main){
                    Toast.makeText(this@MainActivity, "Invalid User", Toast.LENGTH_SHORT)
                        .show()
                }
            }
            else{
                withContext(Dispatchers.Main){
                    Toast.makeText(this@MainActivity, "Login Sucessful", Toast.LENGTH_SHORT)
                        .show()
                }
                startActivity(Intent(this@MainActivity,
                DashboardActivity::class.java))
            }

        }
    }
}