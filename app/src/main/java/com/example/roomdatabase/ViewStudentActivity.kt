package com.example.roomdatabase

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.roomdatabase.adapter.StudentAdapter
import com.example.roomdatabase.model.Student

class ViewStudentActivity : AppCompatActivity() {

    private var lstStudent = ArrayList<Student>()
    private lateinit var recyclerview: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_student)

        recyclerview = findViewById(R.id.recyclerview)
        addStudent()
        val adapter = StudentAdapter(lstStudent, this)
        recyclerview.layoutManager = LinearLayoutManager(this)
        recyclerview.adapter = adapter
    }

    fun addStudent() {
        lstStudent.add(Student("Ramesh Bhandari", 21))
        lstStudent.add(Student("Sabin Chapagain", 22))
        lstStudent.add(Student("Unish Bhattarai", 21))
    }
}