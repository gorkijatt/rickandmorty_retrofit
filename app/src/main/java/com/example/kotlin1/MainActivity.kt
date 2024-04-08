package com.example.kotlin1

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import com.example.kotlin1.model.Character
import com.example.kotlin1.model.RickAndMortyCharacters
import com.example.kotlin1.model.RickAndMortyEpisodes
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
        getEpisodes()
    }

    fun getCharacter(){
        val service = RickAndMortyApiClient.service

        //calling the api
        val characterId = 2 // Example character ID
        val call = service.getCharacter(characterId)


        //getting the character information
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

    fun getCharacters(){

        //retrofit client
        val service = RickAndMortyApiClient.service

        //retrofit interfaces
        val call = service.getCharacters()

        //retrieving result
        call.enqueue(object :Callback<RickAndMortyCharacters>{
            override fun onResponse(call: Call<RickAndMortyCharacters>, response: Response<RickAndMortyCharacters>) {
                val characters = response.body()

                //checking if it is not null
                characters?.let { characters ->
                    //if not null than looping
                    for (character in characters.results) {
                        // Access individual character data here
                        Log.d("RickAndMorty",character.image)
                        Toast.makeText(applicationContext, character.image, Toast.LENGTH_SHORT).show()
                    }
                }

            }

            override fun onFailure(call: Call<RickAndMortyCharacters>, t: Throwable) {
                Toast.makeText(applicationContext, t.message, Toast.LENGTH_SHORT).show()

            }

        })
    }

    fun getEpisodes(){
        //retrofit client
        val service = RickAndMortyApiClient.service

        //retrofit interfaces
        val call = service.getEpisodes()

        //retrieving result
        call.enqueue(object :Callback<RickAndMortyEpisodes>{
            override fun onResponse(call: Call<RickAndMortyEpisodes>, response: Response<RickAndMortyEpisodes>) {
                val episodes = response.body()

                //checking if it is not null
                episodes?.let { episodes ->
                    //if not null than looping
                    for (episodes in episodes.results) {
                        // Access individual character data here
                        Log.d("RickAndMorty",episodes.name)
                    }
                }

            }

            override fun onFailure(call: Call<RickAndMortyEpisodes>, t: Throwable) {
                Toast.makeText(applicationContext, t.message, Toast.LENGTH_SHORT).show()

            }

        })
    }
}




