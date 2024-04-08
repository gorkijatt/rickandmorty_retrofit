package com.example.kotlin1.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RickAndMortyApiClient {
    private val retrofit = Retrofit.Builder()
        .baseUrl("https://rickandmortyapi.com/api/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    //api service
    val service: RickAndMortyApiService by lazy {
        retrofit.create(RickAndMortyApiService::class.java)
    }

}