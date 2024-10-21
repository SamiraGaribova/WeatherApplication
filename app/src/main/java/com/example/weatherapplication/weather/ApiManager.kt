package com.example.weatherapplication.weather

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiManager {

    private val okhttpClient = OkHttpClient.Builder()
        .addInterceptor(WeatherApiKeyInterceptor())
        .addInterceptor(HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        })
        .build()

    private val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl("https://api.weatherapi.com/v1/")
        .addConverterFactory(GsonConverterFactory.create())
        .client(okhttpClient)
        .build()

    fun getWeatherApiService(): WeatherApiService {
        return retrofit.create(WeatherApiService::class.java)
    }
}
