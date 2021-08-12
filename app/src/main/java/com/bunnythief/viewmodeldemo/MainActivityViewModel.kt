package com.bunnythief.viewmodeldemo

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlin.random.Random

class MainActivityViewModel: ViewModel() {

    val randomInt = MutableLiveData<Int>()

    // Assign random integer between 1 and 10 to randomInt
    fun setRandomInt() {
        randomInt.value = Random.nextInt(1, 10)
    }

    //Clear random integer from textView
    fun resetIntText() {
        randomInt.value = -1
    }

    init {
        // Initialize randomint
        randomInt.value = 0
        Log.i("MainActivityViewModel", "MainActivityViewModel created!")
    }

}