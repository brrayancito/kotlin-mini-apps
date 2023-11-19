package com.example.androidproject.superhero

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.androidproject.databinding.ItemSuperheroBinding


class SuperheroViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    private val binding = ItemSuperheroBinding.bind(view)

    fun bind(superHero: SuperHero) {
        binding.tvSuperheroName.text = superHero.name
    }
}