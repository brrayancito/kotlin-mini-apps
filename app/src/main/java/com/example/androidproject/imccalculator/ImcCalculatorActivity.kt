package com.example.androidproject.imccalculator

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import com.example.androidproject.R
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.slider.RangeSlider
import java.text.DecimalFormat

class ImcCalculatorActivity : AppCompatActivity() {
    // Cards View
    private lateinit var cardMale: CardView
    private lateinit var cardFemale: CardView

    private var isCardMaleSelected = true

    // Height View
    private var height: Int = 120
    private lateinit var textViewHeight: TextView
    private lateinit var rangeSliderHeight: RangeSlider

    // Weight View
    private var weight: Int = 50
    private lateinit var textViewWeight: TextView
    private lateinit var btnIncreaseWeight: FloatingActionButton
    private lateinit var btnDecreaseWeight: FloatingActionButton

    // Age View
    private var age: Int = 20
    private lateinit var textViewAge: TextView
    private lateinit var btnIncreaseAge: FloatingActionButton
    private lateinit var btnDecreaseAge: FloatingActionButton

    // Calculate btn
    private lateinit var btnCalculate: Button

    // Companion Object
   companion object{
       const val IMC_KEY = "IMC_RESULT"
   }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_imc_calculator)
        initComponents()
        initListeners()
    }


    private fun initComponents() {
        cardMale = findViewById<CardView>(R.id.cardMale)
        cardFemale = findViewById<CardView>(R.id.cardFemale)

        textViewHeight = findViewById<TextView>(R.id.tvHeight)
        rangeSliderHeight = findViewById<RangeSlider>(R.id.rsHeight)

        textViewWeight = findViewById(R.id.tvWeight)
        btnIncreaseWeight = findViewById(R.id.btnIncreaseWeight)
        btnDecreaseWeight = findViewById(R.id.btnDecreaseWeight)

        textViewAge = findViewById(R.id.tvAge)
        btnDecreaseAge = findViewById(R.id.btnDecreaseAge)
        btnIncreaseAge = findViewById(R.id.btnIncreaseAge)

        btnCalculate = findViewById(R.id.btnCalculate)
    }

    private fun initListeners() {
        val cardSelectedColor = ContextCompat.getColor(this, R.color.background_component_selected)
        val cardNotSelectedColor = ContextCompat.getColor(this, R.color.background_component)

        // Cards
        cardMale.setOnClickListener {
            if (!isCardMaleSelected) {
                cardMale.setCardBackgroundColor(cardSelectedColor)
                cardFemale.setCardBackgroundColor(cardNotSelectedColor)
                isCardMaleSelected = true
            }
        }
        cardFemale.setOnClickListener {
            if (isCardMaleSelected) {
                cardMale.setCardBackgroundColor(cardNotSelectedColor)
                cardFemale.setCardBackgroundColor(cardSelectedColor)
                isCardMaleSelected = false
            }
        }

        // Range
        rangeSliderHeight.addOnChangeListener { _, value, _ ->
            var df = DecimalFormat("#.##")
            height = df.format(value).toInt()
            textViewHeight.text = "$height cm"
        }

        // Weight
        btnDecreaseWeight.setOnClickListener {
            if (weight > 0) {
                weight--
                textViewWeight.text = weight.toString()
            }
        }

        btnIncreaseWeight.setOnClickListener {
            weight++
            textViewWeight.text = weight.toString()
        }

        // Age
        btnIncreaseAge.setOnClickListener {
            age++
            textViewAge.text = age.toString()
        }

        btnDecreaseAge.setOnClickListener {
            if (age > 0) {
                age--
                textViewAge.text = age.toString()
            }
        }

        // Btn Calculate
        btnCalculate.setOnClickListener {
            val imc = calculateIMC()
            navigateToImcResult(imc)


        }
    }

    private fun calculateIMC(): Double {
        val df = DecimalFormat("#.##")
        val imc = weight / (height.toDouble() / 100 * height.toDouble() / 100)
        return df.format(imc).toDouble()
    }

    private fun navigateToImcResult(imc: Double) {
        val intent = Intent(this, ImcResultActivity::class.java)
        intent.putExtra(IMC_KEY, imc)
        startActivity(intent)
    }

}