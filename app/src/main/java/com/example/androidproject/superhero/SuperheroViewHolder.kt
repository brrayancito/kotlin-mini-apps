package com.example.androidproject.superhero

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.androidproject.databinding.ItemSuperheroBinding
import com.squareup.picasso.Picasso


class SuperheroViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    private val binding = ItemSuperheroBinding.bind(view)

    fun bind(superHero: SuperHero, onSelectedItem: (String) -> Unit) {
        binding.tvSuperheroName.text = superHero.name
        Picasso.get().load(superHero.image.url).into(binding.ivSuperhero)

        binding.root.setOnClickListener {onSelectedItem(superHero.id)}
    }
}