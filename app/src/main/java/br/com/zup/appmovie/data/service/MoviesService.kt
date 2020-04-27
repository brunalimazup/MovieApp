package br.com.zup.appmovie.data.service

import br.com.zup.appmovie.model.RecentMovies
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.Call

interface MoviesService {

    @GET("/movie/{movie_id}")
    fun getMovieById(@Path("id") idMovie: String) : Call<RecentMovies>
}