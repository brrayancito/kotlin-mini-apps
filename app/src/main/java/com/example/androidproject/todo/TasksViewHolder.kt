package com.example.androidproject.todo

import android.content.res.ColorStateList
import android.graphics.Paint
import android.view.View
import android.widget.CheckBox
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.androidproject.R

class TasksViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    private val textViewTask: TextView = view.findViewById(R.id.tvTask)
    private val checkBox: CheckBox = view.findViewById(R.id.cbTask)

    fun render(task: Task) {
        if (task.isSelected) {
            textViewTask.paintFlags = textViewTask.paintFlags or Paint.STRIKE_THRU_TEXT_FLAG
        } else {
            textViewTask.paintFlags = textViewTask.paintFlags and Paint.STRIKE_THRU_TEXT_FLAG.inv()
        }

        val color = when(task.category) {
            TaskCategory.Business -> R.color.todo_business_category
            TaskCategory.Personal -> R.color.todo_personal_category
            TaskCategory.Other -> R.color.todo_other_category
        }

        checkBox.isChecked = task.isSelected
        checkBox.buttonTintList = ColorStateList.valueOf(ContextCompat.getColor(checkBox.context, color))
        textViewTask.text = task.name
    }
}