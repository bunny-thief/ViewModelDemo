package com.bunnythief.viewmodeldemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import com.bunnythief.viewmodeldemo.databinding.ActivityMainBinding
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    //add reference to binding object
    private lateinit var binding: ActivityMainBinding

    var randomInt: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //create binding object
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.randomButton.setOnClickListener {
        binding.textView.text = setRandomInt().toString()
        }

        binding.resetButton.setOnClickListener {
            resetIntText()
        }
    }

    private fun setRandomInt(): Int {
        return Random.nextInt(1, 10)
    }

    private fun resetIntText() {
        binding.textView.text = "Click button"
    }
}