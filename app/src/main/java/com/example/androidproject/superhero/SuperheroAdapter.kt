package com.example.androidproject.superhero

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.androidproject.R


class SuperheroAdapter(private var superheroes: List<SuperHero> = emptyList()) :
    RecyclerView.Adapter<SuperheroViewHolder>() {

    fun updateSuperheroList(superheroList: List<SuperHero>){
        this.superheroes = superheroList
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SuperheroViewHolder {
        val layoutInflater =
            LayoutInflater.from(parent.context).inflate(R.layout.item_superhero, parent, false)
        return SuperheroViewHolder(layoutInflater)
    }

    override fun onBindViewHolder(holder: SuperheroViewHolder, position: Int) {
        val superhero = superheroes[position]
        holder.bind(superhero)
    }

    override fun getItemCount(): Int {
        return superheroes.size
    }
}