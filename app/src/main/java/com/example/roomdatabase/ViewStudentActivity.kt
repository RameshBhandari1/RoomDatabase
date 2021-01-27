package com.example.roomdatabase

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.roomdatabase.adapter.StudentAdapter
import com.example.roomdatabase.db.StudentDB
import com.example.roomdatabase.entity.Student
import kotlinx.coroutines.*
import kotlinx.coroutines.Dispatchers.Main

class ViewStudentActivity : AppCompatActivity() {

    private lateinit var recyclerview: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_student)

        recyclerview = findViewById(R.id.recyclerview)

        CoroutineScope(Dispatchers.IO).launch {
            val lstStudent = StudentDB.getInstance(this@ViewStudentActivity)
                .getStudentDAO()
                .getAllStudents()

            withContext(Main){
                recyclerview.adapter = StudentAdapter(this@ViewStudentActivity, lstStudent)
                recyclerview.layoutManager = LinearLayoutManager(this@ViewStudentActivity)
            }

        }

    }

}