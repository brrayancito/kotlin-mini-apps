package com.example.androidproject.superhero

import com.google.gson.annotations.SerializedName

data class SuperheroDataResponse(@SerializedName("response") val response: String) {
}