package com.example.androidproject.superhero

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.appcompat.widget.SearchView
import com.example.androidproject.R
import com.example.androidproject.databinding.ActivitySuperHeroBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class SuperHeroActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySuperHeroBinding

    private lateinit var retrofit: Retrofit

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySuperHeroBinding.inflate(layoutInflater)
        setContentView(binding.root)
        retrofit = getRetrofit()
        initUI()
    }

    private fun initUI() {
        binding.svHero.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                searchByName(query.orEmpty())
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                return false
            }

        })
    }

    private fun searchByName(heroName: String) {
        CoroutineScope(Dispatchers.IO).launch {
            val res: Response<SuperheroDataResponse> =
                retrofit.create(ApiService::class.java).getSuperheroes(heroName)

            if (res.isSuccessful) {
                Log.i("msg", "It works")
            } else {
                Log.i("msg", "It doesn't work")
            }

        }
    }

    private fun getRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://superheroapi.com")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}