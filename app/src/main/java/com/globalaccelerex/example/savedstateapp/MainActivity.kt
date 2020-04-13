package com.globalaccelerex.example.savedstateapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.globalaccelerex.example.savedstateapp.databinding.ActivityMainBinding
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    /**
     * The [CounterViewModelFactory] is provided by Dagger member Injection which in turn is used to create the viewModel
     */
    @Inject
    lateinit var counterViewModelFactory: CounterViewModelFactory
    private val counterViewModel: CounterViewModel by savedStateViewModel { counterViewModelFactory }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        DaggerAppComponent.create().inject(this)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonCount.setOnClickListener {
            counterViewModel.updateCount()
        }
        counterViewModel.currentCount().observe(this, Observer { count ->
            binding.textViewCurrentCount.text = count.toString()
        })
    }
}
