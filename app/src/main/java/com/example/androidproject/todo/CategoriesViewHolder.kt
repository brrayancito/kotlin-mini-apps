package com.example.androidproject.todo


import android.content.Context
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.androidproject.R

class CategoriesViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    private val textViewCategoryName: TextView = view.findViewById(R.id.tvCategoryName)
    private val imageViewCategoryIcon: ImageView = view.findViewById(R.id.ivCategoryIcon)
    private val cvCategory: CardView = view.findViewById(R.id.cvCategory)
    fun render(taskCategory: TaskCategory, onSelectedItem: (Int) -> Unit) {

        itemView.setOnClickListener { onSelectedItem(layoutPosition) }

        val color = if (taskCategory.isSelected) {
            R.color.todo_background_card
        } else {
            R.color.todo_background_disabled
        }

        cvCategory.setCardBackgroundColor(
            ContextCompat.getColor(
                cvCategory.context,
                color
            )
        )

        when (taskCategory) {
            TaskCategory.Business -> {
                textViewCategoryName.text = "Negocios"
                imageViewCategoryIcon.setImageDrawable(
                    ContextCompat.getDrawable(
                        imageViewCategoryIcon.context,
                        R.drawable.icon_category_business
                    )
                )

                imageViewCategoryIcon.setColorFilter(ContextCompat.getColor(
                    imageViewCategoryIcon.context,
                    R.color.todo_business_category
                ))
            }

            TaskCategory.Other -> {
                textViewCategoryName.text = "Otro"
                imageViewCategoryIcon.setImageDrawable(
                    ContextCompat.getDrawable(
                        imageViewCategoryIcon.context,
                        R.drawable.icon_category_other
                    )
                )

                imageViewCategoryIcon.setColorFilter(ContextCompat.getColor(
                    imageViewCategoryIcon.context,
                    R.color.todo_other_category
                ))
            }

            TaskCategory.Personal -> {
                textViewCategoryName.text = "Personal"
                imageViewCategoryIcon.setImageDrawable(
                    ContextCompat.getDrawable(
                        imageViewCategoryIcon.context,
                        R.drawable.icon_category_personal
                    )
                )
                imageViewCategoryIcon.setColorFilter(ContextCompat.getColor(
                    imageViewCategoryIcon.context,
                    R.color.todo_personal_category
                ))

            }
        }

    }
}


