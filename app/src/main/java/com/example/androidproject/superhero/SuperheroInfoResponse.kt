package com.example.androidproject.superhero

import com.google.gson.annotations.SerializedName

data class SuperheroInfoResponse(
    @SerializedName("name") val name: String,
    @SerializedName("powerstats") val powerstats: PowerStats,
    @SerializedName("image") val image: HeroImage
)

data class PowerStats(
    @SerializedName("intelligence") val intelligence: String,
    @SerializedName("strength") val strength: String,
    @SerializedName("speed") val speed: String,
    @SerializedName("durability") val durability: String,
    @SerializedName("power") val power: String,
    @SerializedName("combat") val combat: String
)

data class HeroImage(
    @SerializedName("url") val url: String
)