package com.example.topnewsdatabinding.repositories

import com.example.topnewsdatabinding.network.NewsApiInterface

class NewsRepo(private val apiInterface: NewsApiInterface) {
    suspend fun getLatestNews() = apiInterface.fetchLatestNewsAsync("us")
}