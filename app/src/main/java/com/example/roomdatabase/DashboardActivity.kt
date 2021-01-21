package com.example.roomdatabase

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class DashboardActivity : AppCompatActivity() {
     private  lateinit var btnAddStudent : Button
     private  lateinit var btnViewStudent : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)

        btnAddStudent = findViewById(R.id.btnAddStudent)
        btnViewStudent = findViewById(R.id.btnViewStudent)

        btnAddStudent.setOnClickListener{
            val intent = Intent(
                    this,
                    AddStudentActivity::class.java
            )
            startActivity(intent)
        }
        btnViewStudent.setOnClickListener{
            val intent = Intent(
                    this,
                    ViewStudentActivity::class.java
            )
            startActivity(intent)
        }
    }

   /* override fun onClick(v: View?) {
        when(v?.id){
            R.id.btnAddStudent->{
                val intent = Intent(
                    this,
                    AddStudentActivity::class.java
                )
                startActivity(intent)
            }
            R.id.btnViewStudent->{
                val intent = Intent(
                    this,
                    ViewStudentActivity::class.java
                )
                startActivity(intent)
            }
        }
    }*/
}