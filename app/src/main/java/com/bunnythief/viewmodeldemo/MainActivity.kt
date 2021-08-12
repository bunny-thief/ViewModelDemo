package com.bunnythief.viewmodeldemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
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

         /*Attach observer to randomInt
        Changes displayed text property of textView based on the value of randomInt*/
        viewModel.randomInt.observe(this, Observer { newRandomInt ->
            if (viewModel.randomInt.value == 0) {
                binding.textView.text = getString(R.string.textViewString)
            } else if (viewModel.randomInt.value == -1) {
                binding.textView.text = getString(R.string.clickButton)
            } else {
            binding.textView.text = newRandomInt.toString()
            }
        })

        //set click listener to randomButton
        binding.randomButton.setOnClickListener {
            viewModel.setRandomInt()
        }

        // Set click listener for resetButton
        binding.resetButton.setOnClickListener {
            viewModel.resetIntText()
        }

        Log.i("MainActivity", "Length of text is: ${binding.textView.text.length}")
        Log.i("MainActivity", "textView.text: ${binding.textView.text}")
        Log.i("MainActivity", "randomInt: ${viewModel.randomInt}")
    }

}