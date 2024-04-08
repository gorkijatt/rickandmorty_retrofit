package com.example.kotlin1.network

import com.example.kotlin1.model.Character
import com.example.kotlin1.model.RickAndMortyCharacters
import com.example.kotlin1.model.RickAndMortyEpisodes
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface RickAndMortyApiService {

    // https://rickandmortyapi.com/api/character/1
    @GET("character/{id}")
    fun getCharacter(@Path("id") id: Int): Call<Character>


    // https://rickandmortyapi.com/api/character
    @GET("character")
    fun getCharacters(): Call<RickAndMortyCharacters>


    // https://rickandmortyapi.com/api/episode
    @GET("episode")
    fun getEpisodes(): Call<RickAndMortyEpisodes>

}

