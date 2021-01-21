package com.example.roomdatabase

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*

class RegisterActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var etfname : EditText
    private lateinit var etlname : EditText
    private lateinit var etusername : EditText
    private lateinit var etpassword : EditText
    private lateinit var etcpassword : EditText
    private lateinit var btnregister : Button
    private lateinit var tvsignin : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        etfname = findViewById(R.id.etfname)
        etlname = findViewById(R.id.etlname)
        etusername = findViewById(R.id.etusername)
        etpassword = findViewById(R.id.etpassword)
        etcpassword = findViewById(R.id.etcpassword)
        tvsignin = findViewById(R.id.tvsignin)

        btnregister = findViewById(R.id.btnregister)
        btnregister.setOnClickListener(this)
        tvsignin.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v?.id){
            R.id.btnregister-> {
                Toast.makeText(this, "Register Sucessfull", Toast.LENGTH_SHORT).show()

                val intent = Intent(
                    this,
                    MainActivity::class.java
                )
                startActivity(intent)
            }
            R.id.tvsignin-> {
                val intent = Intent(
                    this,
                    MainActivity::class.java
                )
                startActivity(intent)
            }
        }
    }
}