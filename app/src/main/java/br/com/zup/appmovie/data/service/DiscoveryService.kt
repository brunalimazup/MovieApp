package br.com.zup.appmovie.data.service

import br.com.zup.appmovie.model.DiscoveryResponse
import retrofit2.http.GET
import retrofit2.Call
import retrofit2.http.Query

interface DiscoveryService {

    @GET("discover/movie")
    fun getRecentMovies(
        @Query("api_key")
        apiKey: String
    ): Call<DiscoveryResponse>
}

//https://api.themoviedb.org/3/discover/movie?api_key=079a8da33b1d25243977c4834788bcd1