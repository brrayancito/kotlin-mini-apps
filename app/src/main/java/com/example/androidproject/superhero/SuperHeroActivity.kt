package com.example.androidproject.superhero

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.appcompat.widget.SearchView
import androidx.core.view.isVisible
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.androidproject.databinding.ActivitySuperHeroBinding
import com.example.androidproject.superhero.SuperheroDetailsActivity.Companion.EXTRA_ID
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class SuperHeroActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySuperHeroBinding
    private lateinit var retrofit: Retrofit

    private lateinit var superheroAdapter: SuperheroAdapter

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

            override fun onQueryTextChange(newText: String?) = false
        })

        superheroAdapter =
            SuperheroAdapter() { navigateToSuperheroDetails(it) }

        binding.rvSuperheroList.setHasFixedSize(true)
        binding.rvSuperheroList.layoutManager = LinearLayoutManager(this)
        binding.rvSuperheroList.adapter = superheroAdapter
    }

    private fun searchByName(heroName: String) {
        binding.loading.isVisible = true

        CoroutineScope(Dispatchers.IO).launch {
            val res: Response<SuperheroDataResponse> =
                retrofit.create(ApiService::class.java).getSuperheroes(heroName)

            if (res.isSuccessful) {
                val response: SuperheroDataResponse? = res.body()
                if (response != null) {
                    runOnUiThread {
                        Log.i("msg", response.toString())
                        superheroAdapter.updateSuperheroList(response.superheroes)
                        binding.loading.isVisible = false
                    }
                }

            } else {
                Log.i("msg", "It doesn't work")
            }

        }
    }

    private fun getRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://superheroapi.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    private fun navigateToSuperheroDetails(id: String) {
        val intent = Intent(this, SuperheroDetailsActivity::class.java)
        intent.putExtra(EXTRA_ID, id)
        startActivity(intent)
    }

}