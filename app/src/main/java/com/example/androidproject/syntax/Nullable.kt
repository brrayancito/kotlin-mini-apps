package com.example.androidproject.syntax

fun main() {
    var name: String? = null
    var name2: String? = "Camille"

//    println(name?.get(2))
    println(name?.get(2) ?: "This is null")
    println(name2?.get(2) ?: "This is null")

}