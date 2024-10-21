package com.example.weatherapplication.weather

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.weatherapplication.R
import com.example.weatherapplication.databinding.FragmentWeatherBinding
import com.squareup.picasso.Picasso

class WeatherFragment : Fragment() {

    private var _binding: FragmentWeatherBinding? = null
    private val binding get() = _binding!!
    private val weatherViewModel: WeatherViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentWeatherBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        weatherViewModel.fetchWeatherData("New-York")

        weatherViewModel.uiState.observe(viewLifecycleOwner) { state ->
            when (state) {
                is UiState.Loading -> {
                    // Show loading indicator
                    binding.cityTextView.text = "Loading..."
                    binding.temperatureTextView.text = "--"
                    binding.conditionTextView.text = ""
                }
                is UiState.Success -> {
                    binding.cityTextView.text = state.weatherResponse.location.name
                    binding.temperatureTextView.text = "${state.weatherResponse.current.temperature}°C"
                    binding.conditionTextView.text = state.weatherResponse.current.condition.text
                    val iconUrl = "https:${state.weatherResponse.current.condition.icon}"
                    Picasso.get().load(iconUrl).into(binding.weatherIconImageView)
                    setBackground(state.weatherResponse.current.condition.text)
                }
                is UiState.Error -> {
                    Log.e("WeatherFragment", "Error: ${state.error.message}")
                    binding.cityTextView.text = "Error: ${state.error.message}"
                    binding.temperatureTextView.text = "--"
                    binding.conditionTextView.text = ""
                }
            }
        }
    }

    private fun setBackground(condition: String) {
        val backgroundResId = when {
            condition.contains("clear", ignoreCase = true) -> R.drawable.clear
            condition.contains("sun", ignoreCase = true) -> R.drawable.sunny1
            condition.contains("cloud", ignoreCase = true) -> R.drawable.cloudy1
            condition.contains("rain", ignoreCase = true) -> R.drawable.rainy
            condition.contains("snow", ignoreCase = true) -> R.drawable.snowy

            else -> R.drawable.default1 // Fallback background
        }
        binding.backgroundImageView.setImageResource(backgroundResId)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
