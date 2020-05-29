package br.com.zup.appmovie.model

import com.google.gson.annotations.SerializedName

data class Movie(
    @SerializedName("id")
    var id: Int,
    @SerializedName("poster_path")
    var posterPath: String,
    @SerializedName("original_title")
    var originalTitle: String
)