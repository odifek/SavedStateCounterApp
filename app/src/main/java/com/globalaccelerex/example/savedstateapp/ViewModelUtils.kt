package com.globalaccelerex.example.savedstateapp

import androidx.activity.viewModels
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.AbstractSavedStateViewModelFactory
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel

/**
 * A helper extension method for getting an instance of a custom [ViewModel] where the viewModel has a [ViewModelAssistedFactory] that is used to instantiate it.
 *
 * This extension method uses the ktx [viewModels] to lazily create the viewModel
 */
inline fun <reified T: ViewModel> FragmentActivity.savedStateViewModel(crossinline viewModelAssistedFactory: () -> ViewModelAssistedFactory<T>) = viewModels<T> {
    object : AbstractSavedStateViewModelFactory(this, null) {
        override fun <T : ViewModel?> create(
            key: String,
            modelClass: Class<T>,
            handle: SavedStateHandle
        ): T  = viewModelAssistedFactory().create(handle) as T

    }
}

/**
 * A savedState viewModel for a fragment
 */
inline fun <reified T: ViewModel> Fragment.savedStateViewModel(crossinline viewModelAssistedFactory: () -> ViewModelAssistedFactory<T>) = viewModels<T> {
    object : AbstractSavedStateViewModelFactory(this, null) {
        override fun <T : ViewModel?> create(
            key: String,
            modelClass: Class<T>,
            handle: SavedStateHandle
        ): T  = viewModelAssistedFactory().create(handle) as T

    }
}

/**
 * A savedState viewModel scoped to an activity
 */
inline fun <reified T: ViewModel> Fragment.activitySavedStateViewModel(crossinline viewModelAssistedFactory: () -> ViewModelAssistedFactory<T>) = activityViewModels<T> {
    object : AbstractSavedStateViewModelFactory(requireActivity(), null) {
        override fun <T : ViewModel?> create(
            key: String,
            modelClass: Class<T>,
            handle: SavedStateHandle
        ): T  = viewModelAssistedFactory().create(handle) as T

    }
}