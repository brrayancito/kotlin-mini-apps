package com.example.androidproject.superhero

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.util.TypedValue
import android.view.View
import androidx.core.view.isVisible
import com.example.androidproject.R
import com.example.androidproject.databinding.ActivitySuperheroDetailsBinding
import com.squareup.picasso.Picasso
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import kotlin.math.roundToInt

class SuperheroDetailsActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySuperheroDetailsBinding
    private lateinit var retrofit: Retrofit

    companion object {
        const val EXTRA_ID = "id"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySuperheroDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        retrofit = getRetrofit()
        val superheroId: String = intent.getStringExtra(EXTRA_ID).orEmpty()
        getSuperheroInf(superheroId)
    }

    private fun getSuperheroInf(id: String) {
        CoroutineScope(Dispatchers.IO).launch {
            val superhero: Response<SuperheroInfoResponse> =
                retrofit.create(ApiService::class.java).getSuperheroInf(id)

            if (superhero.body() != null) {
                runOnUiThread { showSuperheroInf(superhero.body()!!) }
            }
        }
    }

    private fun showSuperheroInf(superhero: SuperheroInfoResponse) {
        Picasso.get().load(superhero.image.url).into(binding.ivHero)
        binding.tvSuperheroName.text = superhero.name
        updateStats(superhero.powerstats)
    }

    private fun updateStats(powerstats: PowerStats) {
        updateHeight(binding.viewIntelligence, powerstats.intelligence)
        updateHeight(binding.viewCombat, powerstats.combat)
        updateHeight(binding.viewSpeed, powerstats.speed)
        updateHeight(binding.viewStrength, powerstats.strength)
        updateHeight(binding.viewDurability, powerstats.durability)
        updateHeight(binding.viewPower, powerstats.power)
    }

    private fun updateHeight(view: View, stat: String) {
        val params = view.layoutParams
        params.height = pixelToDp(stat.toFloat())
        view.layoutParams = params
    }

    private fun pixelToDp(px: Float): Int {
        return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, px, resources.displayMetrics)
            .roundToInt()
    }

    private fun getRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://superheroapi.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }


}
