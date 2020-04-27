package br.com.zup.appmovie.model

import com.google.gson.annotations.SerializedName

data class RecentMovies (
    @SerializedName("photo")
    val photo: String,
    @SerializedName("name")
    val name: String
)