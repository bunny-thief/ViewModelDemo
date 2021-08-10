package com.bunnythief.viewmodeldemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.bunnythief.viewmodeldemo.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    //associate ViewModel with UI controller
    lateinit var viewModel: MainActivityViewModel

    //add reference to binding object
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //create binding object
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        //initialize view model
        viewModel = ViewModelProvider(this).get(MainActivityViewModel::class.java)

        //set click listener to random button
        binding.randomButton.setOnClickListener {
            viewModel.setRandomInt()
            updateRandomInt()
        }

        binding.resetButton.setOnClickListener {
            resetIntText()
        }

        Log.i("MainActivity", "Length of text is: ${binding.textView.text.length}")
        Log.i("MainActivity", "textView.text: ${binding.textView.text}")
        Log.i("MainActivity", "randomInt: ${viewModel.randomInt}")

        //updates value in MainActivity with data from viewModel
        if (viewModel.randomInt != 0) {
            updateRandomInt()
        }

        //changes textView to "Click button" if reset has been called before configuration change
        if (viewModel.randomInt == -1) {
            resetIntText()
        }
    }

    //update textView with current value of randomInt
    private fun updateRandomInt() {
        binding.textView.text = viewModel.randomInt.toString()
    }

    //Clear random integer from textView
    private fun resetIntText() {
        viewModel.randomInt = -1
        binding.textView.text = "Click button"
    }
}