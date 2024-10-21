package com.example.weatherapplication.weather

sealed class UiState {
    object Loading : UiState()
    data class Success(val weatherResponse: CurrentWeatherResponse) : UiState()
    data class Error(val error: Throwable) : UiState()
}
