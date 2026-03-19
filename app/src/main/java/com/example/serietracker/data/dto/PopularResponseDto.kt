package com.example.serietracker.data.dto


import com.google.gson.annotations.SerializedName

data class PopularResponseDto(
    // D'autres champs possibles comme "total", "page", etc. (tu peux les ignorer si tu ne t'en sers pas)

    @SerializedName("tv_shows") // Le nom exact de la clé dans l'API
    val tvShows: List<TvShowDto> // La variable que tu appelles dans ton Repository
)

