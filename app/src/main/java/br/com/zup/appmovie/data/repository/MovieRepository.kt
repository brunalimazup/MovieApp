package br.com.zup.appmovie.data.repository

import android.util.Log
import androidx.lifecycle.MutableLiveData
import br.com.zup.appmovie.data.service.DiscoveryService
import br.com.zup.appmovie.data.service.MovieService
import br.com.zup.appmovie.model.DiscoveryResponse
import br.com.zup.appmovie.model.MovieDetails
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MovieRepository {
    private val movieMutableLiveData: MutableLiveData<DiscoveryResponse> = MutableLiveData()
    private val detailsMutableLiveData: MutableLiveData<MovieDetails> = MutableLiveData()

    val retrofit = Retrofit.Builder()
        .baseUrl("https://api.themoviedb.org/3/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val detailsService = retrofit.create(MovieService::class.java)
    fun getDetailsMovies(id: String): MutableLiveData<MovieDetails> {
        val request = detailsService.getMovieDetails(id, "079a8da33b1d25243977c4834788bcd1")
        request.enqueue(object : Callback<MovieDetails> {
            override fun onFailure(call: Call<MovieDetails>, t: Throwable) {
                Log.d("MovieRepository", "Erro na requisição")
            }

            override fun onResponse(call: Call<MovieDetails>, response: Response<MovieDetails>) {
                Log.d("MovieRepository", "Sucesso")
                Log.d("MovieRepository", response.code().toString())
                val body = response.body()
                if (body != null) {
                    detailsMutableLiveData.postValue(response.body())
                }
            }

        })

        return detailsMutableLiveData

    }


    val discoveryService = retrofit.create(DiscoveryService::class.java)
    fun getRecentMovies(): MutableLiveData<DiscoveryResponse> {
        val request = discoveryService.getRecentMovies("079a8da33b1d25243977c4834788bcd1")
        request.enqueue(object : Callback<DiscoveryResponse> {
            override fun onFailure(call: Call<DiscoveryResponse>, t: Throwable) {
                Log.d("MovieRepository", "Erro na requisição")
            }

            override fun onResponse(
                call: Call<DiscoveryResponse>,
                response: Response<DiscoveryResponse>
            ) {
                Log.d("MovieRepository", "Sucesso")
                Log.d("MovieRepository", response.code().toString())
                val body = response.body()
                if (body != null) {
                    movieMutableLiveData.postValue(response.body())
                }
            }

        })
        return movieMutableLiveData
    }
}

