package com.example.topnewsdatabinding.network.models

data class LatestNews(
        val articles: List<Article>,
        val status: String,
        val totalResults: Int
)