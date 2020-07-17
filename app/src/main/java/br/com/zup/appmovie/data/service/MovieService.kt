package br.com.zup.appmovie.data.service


import br.com.zup.appmovie.model.MovieDetails
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MovieService {

    @GET("movie/{movie_id}")
    fun getMovieDetails(
        @Path("movie_id") id: String, @Query("api_key")
        apiKey: String
    ): Call<MovieDetails>


}