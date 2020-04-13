package com.globalaccelerex.example.savedstateapp

import androidx.lifecycle.LiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel

/**
 * A custom [ViewModel] that takes in a [SavedStateHandle] which it uses to persist some state against process death
 */
class CounterViewModel(private val savedState: SavedStateHandle) :
    ViewModel() {

    companion object {
        private const val ARGS_CURRENT_COUNT = "currentCount"
    }

    fun updateCount() {
        val currentCount = savedState[ARGS_CURRENT_COUNT] ?: 0
        savedState.set(ARGS_CURRENT_COUNT, currentCount + 1)
    }

    fun currentCount(): LiveData<Int> = savedState.getLiveData(ARGS_CURRENT_COUNT, 0)
}