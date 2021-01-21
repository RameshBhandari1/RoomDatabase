package com.example.roomdatabase

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

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
                    val intent = Intent(
                        this,
                        DashboardActivity::class.java
                    )
                    startActivity(intent)
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
}