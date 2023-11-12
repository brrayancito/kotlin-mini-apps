package com.example.androidproject.syntax

fun main() {
    val weekDays =
        arrayOf("Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday")
    println(weekDays[weekDays.size - 1]) //-> Sunday

    // for loop
    for (day in weekDays)  println("$day in a beautiful day!")
    for (i in weekDays.indices) println("$i - ${weekDays[i]}")
    for (i in weekDays.indices.reversed()) println("$i - ${weekDays[i]}")
    for (i in 1..10) println(i)
    for (i in 10 downTo  1) println(i)

    val name = "fernanda"
    for (l in name) println(l)

    // foreach loop
    weekDays.forEach { println(it) }
    for ((i, day) in weekDays.withIndex()) println("Position: $i - Value: $day")
}