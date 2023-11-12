package com.example.androidproject.syntax

fun main() {
    showMyAge(26);
    val myAge = getMyAge(1997);
    if (myAge == 26) println("You're older!");
    println(myAge); // -> 26
}

fun showMyAge(age: Int) {
    println("You are $age years old!");
}

fun getMyAge(born: Int): Int {
    return 2023 - born;
}