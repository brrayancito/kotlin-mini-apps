package com.example.androidproject.todo

sealed class TaskCategory {
    object Personal: TaskCategory()
    object Business: TaskCategory()
    object Other: TaskCategory()
}