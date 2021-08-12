package com.bunnythief.viewmodeldemo

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlin.random.Random

class MainActivityViewModel: ViewModel() {
    
    private val _randomInt = MutableLiveData<Int>()
    val randomInt: LiveData<Int>
        get() = _randomInt

    // Assign random integer between 1 and 10 to randomInt
    fun setRandomInt() {
        _randomInt.value = Random.nextInt(1, 10)
    }

    //Clear random integer from textView
    fun resetIntText() {
        _randomInt.value = -1
    }

    init {
        // Initialize randomint
        _randomInt.value = 0
        Log.i("MainActivityViewModel", "MainActivityViewModel created!")
    }

}