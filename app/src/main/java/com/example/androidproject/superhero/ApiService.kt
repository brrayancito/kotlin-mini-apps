package com.example.androidproject.superhero

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {
    @GET("/api/1312672489454273/search/{name}")
    suspend fun getSuperheroes(@Path("name") superHeroName: String): Response<SuperheroDataResponse>
}