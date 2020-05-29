package br.com.zup.appmovie.model

import com.google.gson.annotations.SerializedName

data class DiscoveryResponse(
    @SerializedName("results")
    var results: List<Movie>
)
