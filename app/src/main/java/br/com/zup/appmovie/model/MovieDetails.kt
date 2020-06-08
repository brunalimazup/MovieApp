package br.com.zup.appmovie.model

import com.google.gson.annotations.SerializedName

data class MovieDetails(
    @SerializedName("id")
    var id: Int,
    @SerializedName("poster_path")
    var posterPath: String,
    @SerializedName("original_title")
    var originalTitle: String,
    @SerializedName("overview")
    var overview: String,
    @SerializedName("vote_average")
    var voteAverage: String
)