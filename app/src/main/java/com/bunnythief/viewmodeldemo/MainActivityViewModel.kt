package com.bunnythief.viewmodeldemo

import android.util.Log
import androidx.lifecycle.ViewModel
import kotlin.random.Random

class MainActivityViewModel: ViewModel() {

    var randomInt: Int = 0

    fun setRandomInt() {
        randomInt = Random.nextInt(1, 10)
    }

    init {
        Log.i("MainActivityViewModel", "MainActivityViewModel created!")
    }

}