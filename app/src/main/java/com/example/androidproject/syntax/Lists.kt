package com.example.androidproject.syntax

fun main() {
    val inmutableList: List<String> =
        listOf("Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday")
    println(inmutableList.size)
    println(inmutableList)

    inmutableList.forEach    { day -> println(day) }

    val daysWithLetterT = inmutableList.filter { it.lowercase().contains("t") }
    println(daysWithLetterT)

    val mutableList: MutableList<String> =
        mutableListOf("Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday")

    mutableList.add("Lastday")
    mutableList.add(0, "Firstday")
    println(mutableList)
}