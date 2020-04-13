package com.globalaccelerex.example.savedstateapp

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel

/**
 * Every [ViewModel] class that wants to use [SavedStateHandle] can have a separate factory that implements this.
 *
 * This will be used in by [viewModel] delegate to create provide the required viewModel.
 */
interface ViewModelAssistedFactory<T: ViewModel> {
    fun create(handle: SavedStateHandle): T
}