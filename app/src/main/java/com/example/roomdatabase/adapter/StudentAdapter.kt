package com.example.roomdatabase.adapter

import android.app.AlertDialog
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.roomdatabase.R
import com.example.roomdatabase.UpdateActivity
import com.example.roomdatabase.db.StudentDB
import com.example.roomdatabase.entity.Student
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class StudentAdapter (
    val context : Context,
    val lstStudent : List<Student>
    ): RecyclerView.Adapter<StudentAdapter.StudentViewHolder>(){

    class StudentViewHolder(view: View) : RecyclerView.ViewHolder(view){
        val tvname: TextView
        val tvage: TextView
        val delete :ImageButton
        val edit :ImageButton

        init {
            tvname = view.findViewById(R.id.tvname)
            tvage = view.findViewById(R.id.tvage)
            edit = view.findViewById(R.id.edit)
            delete = view.findViewById(R.id.delete)
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):StudentViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.view_student, parent, false)
        return StudentViewHolder(view)
    }

    override fun onBindViewHolder(holder: StudentViewHolder, position: Int) {
        val student = lstStudent[position]
        holder.tvname.text = student.fullName
        holder.tvage.text = student.age.toString()

        holder.edit.setOnClickListener{
            val intent = Intent(context, UpdateActivity::class.java)
            intent.putExtra("student", student)
            context.startActivity(intent)
        }
        holder.delete.setOnClickListener {

            val builder = AlertDialog.Builder(context)
            builder.setTitle("Delete student")
            builder.setMessage("Are you sure you want to delete ${student.fullName} ??")
            builder.setIcon(android.R.drawable.ic_dialog_alert)
            builder.setPositiveButton("Yes") { _, _ ->
                deleteStudent(student)
            }
            builder.setNegativeButton("No") { _, _ ->
                Toast.makeText(context, "Action cancelled", Toast.LENGTH_SHORT).show()
            }
            val alertDialog: AlertDialog = builder.create()
            alertDialog.setCancelable(false)
            alertDialog.show()
        }

    }

    private fun deleteStudent(student: Student) {
        CoroutineScope(Dispatchers.IO).launch {
            StudentDB.getInstance(context).getStudentDAO().DeleteStudent(student)
            withContext(Dispatchers.Main) {
                Toast.makeText(context, "Deleted", Toast.LENGTH_SHORT).show()
            }
        }

    }

    override fun getItemCount(): Int {
        return lstStudent.size
    }

}