package com.example.androidproject.syntax

fun main() {
//    getMonth(6);
//    sayMonth(5);
    val data = typeOfData("hola");
    println(data);
    sayHi();
}

fun getMonth(month: Int) {
    when(month){
        1 ->  {
            println("Enero")
            println("Primer mes del año")
        }
        2 -> println("Febrero")
        3 -> println("Marzo")
        4 -> println("Abril")
        5 -> println("Mayo")
        6 -> println("Junio")
        7 -> println("Julio")
        8 -> println("Agosto")
        9 -> println("Septiembre")
        10 -> println("Octubre")
        11 -> println("Noviembre")
        12 -> println("Diciembre")
        else -> println("No es un mes válido!")
    }

    when(month){
        1, 2, 3 -> println("Primer trimestre")
        4, 5, 6 -> println("Segundo trimestre")
        7, 8, 9 -> println("Tercer trimestre")
        10, 11, 12 -> println("Cuarto trimestre")
        else -> println("trimestre no válido!")
    }

    when(month){
        in 1..6 -> println("Primer semestre")
        in 7..12 -> println("Segundo semestre")
        !in 1..12 -> println("Semestre no válido!")
    }
}

fun sayMonth(month: Int) {
    val months = arrayOf("Enero", "Febrero", "Marzo", "Abril", "Mayo" , "Junio" , "Julio", "Agosto",
        "Septiembre", "Octubre", "Noviembre", "Diciembre" );

    if (month <= 0 || month > months.size) return println("No es un mes válido!")
    println(months[month - 1]);
}

fun typeOfData(value: Any): String {
    return when(value) {
        is Int -> "This is a num"
        is String -> "This is a string"
        is Boolean -> "This is a boolean"
        else -> "This is another type of data!"
    }
}

fun sayHi() = println("Hi!")