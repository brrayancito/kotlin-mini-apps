package com.example.androidproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.androidproject.firstapp.FirstAppActivity
import com.example.androidproject.imccalculator.ImcCalculatorActivity
import com.example.androidproject.settings.SettingsActivity
import com.example.androidproject.superhero.SuperHeroActivity
import com.example.androidproject.todo.TodoActivity


class MenuActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        val btnSayHi = findViewById<Button>(R.id.btnSayHi)
        val btnIMC = findViewById<Button>(R.id.btnIMC)
        val btnTODO = findViewById<Button>(R.id.btnTODO)
        val btnSuperhero = findViewById<Button>(R.id.btnSuperhero)
        val btnSettings = findViewById<Button>(R.id.btnSettings)

        btnSayHi.setOnClickListener { navigateToSayHiView() }
        btnIMC.setOnClickListener { navigateToIMCView() }
        btnTODO.setOnClickListener {navigateToTodoView()}
        btnSuperhero.setOnClickListener {navigateToSuperheroList()}
        btnSettings.setOnClickListener {navigateToSettings()}

    }

    private fun navigateToIMCView() {
        val intent = Intent(this, ImcCalculatorActivity::class.java)
        startActivity(intent)
    }

    private fun navigateToSayHiView() {
        val intent = Intent(this, FirstAppActivity::class.java)
        startActivity(intent)
    }

    private fun navigateToTodoView() {
//        val intent = Intent(this, TodoActivity::class.java)
        startActivity(Intent(this, TodoActivity::class.java))
    }

    private fun navigateToSuperheroList() {
//        val intent = Intent(this, TodoActivity::class.java)
        startActivity(Intent(this, SuperHeroActivity::class.java))
    }

    private fun navigateToSettings() {
        startActivity(Intent(this, SettingsActivity::class.java))
    }

}