package com.example.topnewsdatabinding.network

import com.example.topnewsdatabinding.BuildConfig
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

object NewsApiService {
    private const val BASE_API = "https://newsapi.org/"

    //creating a Network Interceptor to add api_key in all the request as authInterceptor
    private val interceptor = Interceptor { chain ->
        val url = chain.request().url.newBuilder()
            .addQueryParameter("apiKey", BuildConfig.API_KEY).build()
        val request = chain.request().newBuilder().url(url).build()
        chain.proceed(request)
    }

    // we are creating a networking client using OkHttp and add our authInterceptor.
    private val apiClient = OkHttpClient().newBuilder().addInterceptor(interceptor).build()

    private val retrofit = Retrofit.Builder().client(apiClient)
        .baseUrl(BASE_API)
        .addConverterFactory(MoshiConverterFactory.create())
        .addCallAdapterFactory(CoroutineCallAdapterFactory())
        .build()

    val newsApi: NewsApiInterface = retrofit.create(NewsApiInterface::class.java)
}