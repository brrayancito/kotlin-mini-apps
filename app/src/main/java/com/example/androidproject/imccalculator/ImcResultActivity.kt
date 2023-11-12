package com.example.androidproject.imccalculator

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.core.content.ContextCompat
import com.example.androidproject.R
import com.example.androidproject.imccalculator.ImcCalculatorActivity.Companion.IMC_KEY

class ImcResultActivity : AppCompatActivity() {

    private lateinit var textViewResult: TextView
    private lateinit var textViewIMC: TextView
    private lateinit var textViewDescription: TextView
    private lateinit var btnReCalculate: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_imc_result)

        val imc = intent.extras?.getDouble(IMC_KEY) ?: -1.0

        initComponents()
        initUI(imc)
        initListeners()
    }



    private fun initUI(imc: Double) {
        when(imc) {
            in 0.00..18.50 -> {
                textViewResult.text = "😔 ${getString(R.string.IMC_underweight_title)} 😔"
                textViewResult.setTextColor(ContextCompat.getColor(this, R.color.underweight))
                textViewIMC.text = imc.toString()
                textViewDescription.text = getString(R.string.IMC_underweight_description)
            }

            in 18.51..24.99 -> {
                textViewResult.text = "😊 ${getString(R.string.IMC_normal_weight_title)} 😊"
                textViewResult.setTextColor(ContextCompat.getColor(this, R.color.normal_weight))
                textViewIMC.text = imc.toString()
                textViewDescription.text = getString(R.string.IMC_normal_weight_description)

            }

            in 25.00..29.99 -> {
                textViewResult.text = "😱 ${getString(R.string.IMC_overweight_title)} 😱"
                textViewResult.setTextColor(ContextCompat.getColor(this, R.color.overweight))
                textViewIMC.text = imc.toString()
                textViewDescription.text = getString(R.string.IMC_overweight_description)
            }

            in 30.00..99.00 -> {
                textViewResult.text = "😭 ${ getString(R.string.IMC_obesity_title) } 😭"
                textViewResult.setTextColor(ContextCompat.getColor(this, R.color.obesity))
                textViewIMC.text = imc.toString()
                textViewDescription.text = getString(R.string.IMC_obesity_description)
            }
            else -> {
                textViewResult.text = getString(R.string.error)
                textViewIMC.text = getString(R.string.error)
                textViewDescription.text = getString(R.string.error)
            }

        }
    }

    private fun initComponents() {
        textViewResult = findViewById(R.id.tvResult)
        textViewIMC = findViewById(R.id.tvIMCResult)
        textViewDescription = findViewById(R.id.tvDescription)
        btnReCalculate = findViewById(R.id.btnRecalculate)
    }

    private fun initListeners() {
        btnReCalculate.setOnClickListener { onBackPressed() }
    }




}