package com.example.androidproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.androidproject.firstapp.FirstAppActivity
import com.example.androidproject.imccalculator.ImcCalculatorActivity


class MenuActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        val btnSayHi = findViewById<Button>(R.id.btnSayHi)
        val btnIMC = findViewById<Button>(R.id.btnIMC)
        btnSayHi.setOnClickListener { navigateToSayHiView() }
        btnIMC.setOnClickListener { navigateToIMCView() }

    }

    private fun navigateToIMCView() {
        val intent = Intent(this, ImcCalculatorActivity::class.java)
        startActivity(intent)
    }

    private fun navigateToSayHiView() {
        val intent = Intent(this, FirstAppActivity::class.java)
        startActivity(intent)
    }

}