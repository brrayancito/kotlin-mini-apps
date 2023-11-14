package com.example.androidproject.todo

import android.view.View
import android.widget.CheckBox
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.androidproject.R

class TasksViewHolder(view: View): RecyclerView.ViewHolder(view) {
    private val textViewTask: TextView = view.findViewById(R.id.tvTask)
    private val checkBox: CheckBox = view.findViewById(R.id.cbTask)

    fun render(task: Task) {
            textViewTask.text = task.name
    }
}