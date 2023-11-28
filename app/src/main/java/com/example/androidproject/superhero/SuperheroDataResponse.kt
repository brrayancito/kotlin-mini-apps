package com.example.androidproject.superhero

import com.google.gson.annotations.SerializedName

data class SuperheroDataResponse(
    @SerializedName("response") val response: String,
    @SerializedName("results-for") val resultsFor: String,
    @SerializedName("results") val superheroes: List<SuperHero>
)

data class SuperHero(
    @SerializedName("id") val id: String,
    @SerializedName("name") val name: String,
    @SerializedName("image") val image: SuperHeroImage
)

data class SuperHeroImage(
    @SerializedName("url") val url: String
)