package com.example.roomdatabase

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import com.example.roomdatabase.db.StudentDB
import com.example.roomdatabase.entity.Student
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class UpdateActivity : AppCompatActivity() {

    private lateinit var etFullname : EditText
    private lateinit var etAge : EditText
    private lateinit var btnUpdate : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_update)

        etFullname = findViewById(R.id.etFullName)
        etAge = findViewById(R.id.etAge)
        btnUpdate = findViewById(R.id.btnUpdate)


        val intent = intent.getParcelableExtra<Student>("student")
        if(intent != null){
            etFullname.setText(intent.fullName)
            etAge.setText(intent.age.toString())
        }
        btnUpdate.setOnClickListener{
            val student = Student(fullName = etFullname.text.toString(), age = etAge.text.toString().toInt())
            student.stdId = intent!!.stdId

            CoroutineScope(Dispatchers.IO).launch {
                StudentDB.getInstance(this@UpdateActivity).getStudentDAO().updateStudent(student)
                startActivity(Intent(this@UpdateActivity,ViewStudentActivity::class.java))
            }
        }

    }

    /*override fun onClick(v: View?) {
        when(v?.id){
            R.id.btnUpdate->{


            }
        }
    }*/
}