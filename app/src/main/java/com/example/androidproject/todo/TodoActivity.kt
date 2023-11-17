package com.example.androidproject.todo

import android.app.Dialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.androidproject.R
import com.google.android.material.floatingactionbutton.FloatingActionButton

class TodoActivity : AppCompatActivity() {

    private val categories = listOf(
        TaskCategory.Business,
        TaskCategory.Other,
        TaskCategory.Personal
    )

    private val tasks = mutableListOf(
        Task("Tarea Personal", TaskCategory.Personal),
        Task("Tarea de Negocios", TaskCategory.Business),
        Task("Otra Tarea", TaskCategory.Other)
    )

    private lateinit var rvCategory: RecyclerView
    private lateinit var categoriesAdapter: CategoriesAdapter

    private lateinit var rvTasks: RecyclerView
    private lateinit var taskAdapter: TasksAdapter

    private lateinit var fabAddTask: FloatingActionButton


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_todo)

        initComponents()
        initUI()
        initListeners()
    }

    private fun initComponents() {
        rvCategory = findViewById(R.id.rvCategories)
        rvTasks = findViewById(R.id.rvTasks)
        fabAddTask = findViewById(R.id.fabAddTask)
    }

    private fun initListeners() {
        fabAddTask.setOnClickListener { showDialog() }
    }

    private fun showDialog() {
        val dialog = Dialog(this)
        dialog.setContentView(R.layout.dialog_task)
        val btnAddTask: Button = dialog.findViewById(R.id.btnAddTask)
        val etTask: EditText = dialog.findViewById(R.id.etTask)
        val rgCategories: RadioGroup = dialog.findViewById(R.id.rgTaskCategories)

        btnAddTask.setOnClickListener {
            val taskTitle: String = etTask.text.toString()
            if (taskTitle.isNotEmpty()) {
                val selectedID = rgCategories.checkedRadioButtonId
                val selectedRadioButton: RadioButton = rgCategories.findViewById(selectedID)
                val currentTaskCategory: TaskCategory = when (selectedRadioButton.text) {
                    getString(R.string.TODO_dialog_cat_business_title) -> TaskCategory.Business
                    getString(R.string.TODO_dialog_cat_personal_title) -> TaskCategory.Personal
                    else -> TaskCategory.Other
                }

                // Add task
                tasks.add(Task(taskTitle, currentTaskCategory))
                updateViewTasks()
                dialog.hide()
            }

        }

        dialog.show()
    }

    private fun initUI() {
        categoriesAdapter = CategoriesAdapter(categories)
        rvCategory.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        rvCategory.adapter = categoriesAdapter

        taskAdapter = TasksAdapter(tasks)
        rvTasks.layoutManager = LinearLayoutManager(this)
        rvTasks.adapter = taskAdapter
    }

    private fun updateViewTasks() {
        taskAdapter.notifyDataSetChanged()
    }
}