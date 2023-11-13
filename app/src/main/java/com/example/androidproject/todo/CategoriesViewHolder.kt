package com.example.androidproject.todo


import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.androidproject.R

class CategoriesViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    private val textViewCategoryName: TextView = view.findViewById(R.id.tvCategoryName)
    private val imageViewCategoryIcon: ImageView = view.findViewById(R.id.ivCategoryIcon)
    fun render(taskCategory: TaskCategory) {
        when (taskCategory) {
            TaskCategory.Business -> {
                textViewCategoryName.text = "Negocios"
                imageViewCategoryIcon.setImageDrawable(
                    ContextCompat.getDrawable(
                        imageViewCategoryIcon.context,
                        R.drawable.icon_category_business
                    )
                )
            }

            TaskCategory.Other -> {
                textViewCategoryName.text = "Otro"
                imageViewCategoryIcon.setImageDrawable(
                    ContextCompat.getDrawable(
                        imageViewCategoryIcon.context,
                        R.drawable.icon_category_other
                    )
                )
            }

            TaskCategory.Personal -> {
                textViewCategoryName.text = "Personal"
                imageViewCategoryIcon.setImageDrawable(
                    ContextCompat.getDrawable(
                        imageViewCategoryIcon.context,
                        R.drawable.icon_category_personal
                    )
                )
            }
        }

    }
}


