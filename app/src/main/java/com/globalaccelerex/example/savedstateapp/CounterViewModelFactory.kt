package com.globalaccelerex.example.savedstateapp

import androidx.lifecycle.SavedStateHandle
import javax.inject.Inject

/**
 * A custom Factory that is used specifically by the [CounterViewModel] for creating it's instance properly with a [SavedStateHandle].
 *
 * If there are other dependencies required by the ViewModel, they should be injected in the constructor of this factory and subsequently passed to the constructor of the ViewModel.
 */
class CounterViewModelFactory @Inject constructor(): ViewModelAssistedFactory<CounterViewModel> {
    override fun create(handle: SavedStateHandle): CounterViewModel {
        return CounterViewModel(handle)
    }
}