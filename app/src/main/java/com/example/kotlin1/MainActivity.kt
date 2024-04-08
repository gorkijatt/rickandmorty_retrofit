package com.example.kotlin1

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import com.example.kotlin1.model.Character
import com.example.kotlin1.network.RickAndMortyApiClient
import com.example.kotlin1.network.RickAndMortyApiService
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //retrofit client
        val service = RickAndMortyApiClient.service

        //calling the api
        val characterId = 2 // Example character ID
        val call = service.getCharacter(characterId)


        //api calling
        call.enqueue(object : Callback<Character> {
            override fun onResponse(call: Call<Character>, response: Response<Character>) {
                val character = response.body()
                if (character != null) {
                    val message = "Name: ${character.name}, Status: ${character.status}"
                    Toast.makeText(applicationContext, message, Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(applicationContext, "Character data is null", Toast.LENGTH_SHORT).show()
                }
            }

            override fun onFailure(call: Call<Character>, t: Throwable) {
                Toast.makeText(applicationContext, t.message, Toast.LENGTH_SHORT).show()

            }
        })


    }






}




