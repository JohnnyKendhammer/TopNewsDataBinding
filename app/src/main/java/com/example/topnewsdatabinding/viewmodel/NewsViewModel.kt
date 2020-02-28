package com.example.topnewsdatabinding.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.topnewsdatabinding.network.NewsApiService
import com.example.topnewsdatabinding.repositories.NewsRepo
import kotlinx.coroutines.Dispatchers

class NewsViewModel : ViewModel() {
    private val newsRepository: NewsRepo = NewsRepo(NewsApiService.newsApi)
    val newsLiveData = liveData(Dispatchers.IO) {
        val data = newsRepository.getLatestNews()
        emit(data)
    }
}