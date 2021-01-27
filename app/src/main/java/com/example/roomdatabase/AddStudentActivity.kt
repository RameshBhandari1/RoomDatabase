package com.example.roomdatabase

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.RadioButton
import android.widget.Toast
import com.example.roomdatabase.db.StudentDB
import com.example.roomdatabase.entity.Student
import com.google.android.material.textfield.TextInputEditText
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.lang.Exception

class AddStudentActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var etFullName: TextInputEditText
    private lateinit var etAge: TextInputEditText
    private lateinit var etAddress: TextInputEditText
    private lateinit var rdoMale: RadioButton
    private lateinit var rdoFemale: RadioButton
    private lateinit var rdoOthers: RadioButton
    private lateinit var btnSave: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_student)

        etFullName = findViewById(R.id.etFullName)
        etAge = findViewById(R.id.etAge)
        etAddress = findViewById(R.id.etAddress)
        rdoMale = findViewById(R.id.rdoMale)
        rdoFemale = findViewById(R.id.rdoFemale)
        rdoOthers = findViewById(R.id.rdoOthers)
        btnSave = findViewById(R.id.btnSave)

        btnSave.setOnClickListener(this)

    }

    override fun onClick(v: View?) {
        when (v?.id){
            R.id.btnSave->{
                saveStudent()
            }
        }
    }

    fun saveStudent() {
        val fullName = etFullName.text.toString()
        val age = etAge.text.toString().toInt()
        val address = etAddress.text.toString()
        var gender = ""
        when {
            rdoFemale.isSelected -> {
                gender = "Female"
            }
            rdoMale.isSelected -> {
                gender = "Male"
            }
            rdoOthers.isSelected -> {
                gender = "Others"
            }
        }

        val student = Student(fullName, age, gender, address)
        try {
            CoroutineScope(Dispatchers.IO).launch {
                StudentDB
                    .getInstance(this@AddStudentActivity)
                    .getStudentDAO()
                    .insertStudent(student)
                withContext(Dispatchers.Main){
                    Toast.makeText(this@AddStudentActivity, "Student Added", Toast.LENGTH_SHORT).show()
                }
            }
        } catch (ex: Exception) {
            Toast.makeText(this, "Error ${ex.localizedMessage}", Toast.LENGTH_SHORT).show()
        }

    }
}