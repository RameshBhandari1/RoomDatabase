package com.example.roomdatabase

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import com.example.roomdatabase.db.StudentDB
import com.example.roomdatabase.entity.User
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Dispatchers.Main
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

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
                val fname = etfname.text.toString()
                val lname = etlname.text.toString()
                val username = etusername.text.toString()
                val password = etpassword.text.toString()
                val confirmPassword = etcpassword.text.toString()
                if (password != confirmPassword) {
                    etpassword.error = "Password does not match"
                    etpassword.requestFocus()
                    return
                } else {
                    val user = User(fname, lname, username, password)
                    CoroutineScope(Dispatchers.IO).launch {
                        StudentDB
                            .getInstance(this@RegisterActivity)
                            .getUserDAO()
                            .registerUser(user)
                        // Switch to Main thread
                        withContext(Main){
                            Toast.makeText(this@RegisterActivity, "user registered", Toast.LENGTH_SHORT).show()
                        }
                    }
                }
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