package com.example.weatherapplication.weather

import okhttp3.Interceptor
import okhttp3.Response

class WeatherApiKeyInterceptor : Interceptor {

    private val apiKey = "4765cd99e89445428c9165252240609"

    override fun intercept(chain: Interceptor.Chain): Response {
        val original = chain.request()
        val urlWithKey = original.url.newBuilder()
            .addQueryParameter("key", apiKey)
            .build()
        val requestWithKey = original.newBuilder().url(urlWithKey).build()
        return chain.proceed(requestWithKey)
    }
}