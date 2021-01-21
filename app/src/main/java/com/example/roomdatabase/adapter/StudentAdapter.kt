package com.example.roomdatabase.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.roomdatabase.R
import com.example.roomdatabase.model.Student

class StudentAdapter (
    val lstStudent : ArrayList<Student>,
    val context : Context
    ): RecyclerView.Adapter<StudentAdapter.StudentViewHolder>(){
    class StudentViewHolder(view: View) : RecyclerView.ViewHolder(view){
        val tvname: TextView
        val tvage: TextView
        val delete :ImageView
        val edit :ImageView

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

    override fun onBindViewHolder(holder: StudentAdapter.StudentViewHolder, position: Int) {
        val student = lstStudent[position]
        holder.tvname.text = student.StudentName
        holder.tvage.text = student.Age.toString()
    }

    override fun getItemCount(): Int {
        return lstStudent.size
    }

}