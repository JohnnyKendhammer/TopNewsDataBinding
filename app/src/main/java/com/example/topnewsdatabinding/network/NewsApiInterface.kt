package com.example.topnewsdatabinding.network

import com.example.topnewsdatabinding.network.models.LatestNews
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsApiInterface {
    @GET("v2/top-headlines")
    suspend fun fetchLatestNewsAsync(@Query("country") query: String): LatestNews
}