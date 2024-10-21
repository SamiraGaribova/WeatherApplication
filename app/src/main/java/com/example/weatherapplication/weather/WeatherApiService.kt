package com.example.weatherapplication.weather

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherApiService {
    @GET("current.json")
    suspend fun getCurrentWeatherByCity(
        @Query("q") city: String
    ): Response<CurrentWeatherResponse>
}
