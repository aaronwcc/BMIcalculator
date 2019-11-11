package com.example.bmicalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.math.pow

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btnCalculate.setOnClickListener {
            calculateBMI()
        }

        btnReset.setOnClickListener {
            reset()
        }
    }

    private fun calculateBMI(){
        if(etWeight.text.toString().isEmpty()){
            etWeight.setError(getString(R.string.input_error))
            return
        }

        val weight = etWeight.text.toString().toFloat();
        val height = etHeight.text.toString().toFloat();
        val bmi = weight / (height/100).pow(2);


        if(bmi < 18.5) {
            tvBmi.text = String.format("%s %.2f (%s)", getString(R.string.bmi), bmi, getString(R.string.under))
            ivProfile.setImageResource(R.drawable.under)
        } else if(bmi >= 18.5 && bmi <= 24.9){
            tvBmi.text = String.format("%s %.2f (%s)", getString(R.string.bmi), bmi, getString(R.string.normal))
            ivProfile.setImageResource(R.drawable.normal)
        }else if(bmi >= 25) {
            tvBmi.text = String.format("%s %.2f (%s)", getString(R.string.bmi), bmi, getString(R.string.over))
            ivProfile.setImageResource(R.drawable.over)
        }


    }

    private fun reset(){
        etWeight.setText("")
        etHeight.setText("")
        ivProfile.setImageResource(R.drawable.empty)
        tvBmi.setText(getString(R.string.bmi))
    }
}

// < 18.5
// >= 18.5 && <= 24.9
// >= 25