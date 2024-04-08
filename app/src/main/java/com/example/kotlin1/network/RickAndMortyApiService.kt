package com.example.kotlin1.network

import com.example.kotlin1.model.Character
import com.example.kotlin1.model.RickAndMortyCharacters
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path


interface RickAndMortyApiService {
    @GET("character/{id}")
    fun getCharacter(@Path("id") id: Int): Call<Character>


    @GET("character")
    fun getCharacters(): Call<RickAndMortyCharacters>
}

