package com.example.androidproject.superhero

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {
    @GET("/api/1312672489454273/search/{name}")
    suspend fun getSuperheroes(@Path("name") superheroName: String): Response<SuperheroDataResponse>

    @GET("/api/1312672489454273/{superhero_id}")
    suspend fun getSuperheroInf(@Path("superhero_id") superheroId: String): Response<SuperheroInfoResponse>
}