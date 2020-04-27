package br.com.zup.appmovie.data.repository

import android.util.Log
import androidx.lifecycle.MutableLiveData
import br.com.zup.appmovie.data.service.MoviesService
import br.com.zup.appmovie.model.RecentMovies
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MovieRepository {
    private val movieMutableLiveData: MutableLiveData<RecentMovies> = MutableLiveData()

    val retrofit = Retrofit.Builder()
        .baseUrl("https://api.themoviedb.org/3")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val movieService = retrofit.create(MoviesService::class.java)

    fun getMovieById(id: String): MutableLiveData<RecentMovies> {
        val callback = movieService.getMovieById(id)

        callback.enqueue(object : Callback<RecentMovies> {
            override fun onFailure(call: Call<RecentMovies>, t: Throwable) {
                Log.e("MovieRepository", "Erro na requisição")
            }

            override fun onResponse(call: Call<RecentMovies>, response: Response<RecentMovies>) {
                if (response.isSuccessful) {
                    Log.i("MovieRepository", "")
                    val movies = response.body() as RecentMovies
                    movieMutableLiveData.postValue(movies)
                }
            }
        })
        return movieMutableLiveData
    }
}

