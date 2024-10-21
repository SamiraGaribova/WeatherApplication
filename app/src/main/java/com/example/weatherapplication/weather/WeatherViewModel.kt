package com.example.weatherapplication.weather

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class WeatherViewModel : ViewModel() {
    private val _uiState = MutableLiveData<UiState>()
    val uiState: LiveData<UiState> = _uiState

    fun fetchWeatherData(city: String) {
        _uiState.value = UiState.Loading
        viewModelScope.launch {
            try {
                val response = ApiManager.getWeatherApiService().getCurrentWeatherByCity(city)
                if (response.isSuccessful) {
                    response.body()?.let {
                        _uiState.value = UiState.Success(it)
                    } ?: run {
                        _uiState.value = UiState.Error(Throwable("No data found"))
                    }
                } else {
                    _uiState.value = UiState.Error(Throwable("Error: ${response.code()}"))
                }
            } catch (e: Exception) {
                _uiState.value = UiState.Error(e)
            }
        }
    }
}
