package com.example.androidproject.superhero

import com.google.gson.annotations.SerializedName

data class SuperheroInfoResponse(
    @SerializedName("name") val name: String,
    @SerializedName("powerstats") val powerstats: PowerStats,
    @SerializedName("image") val image: HeroImage,
    @SerializedName("biography") val biography: Biography
)

data class Biography(
    @SerializedName("full-name") val fullName: String,
    @SerializedName("publisher") val publisher: String
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