package com.example.serietracker.data.dto


import com.google.gson.annotations.SerializedName

data class PopularResponseDto(

    @SerializedName("tv_shows")
    val tvShows: List<TvShowDto>
)

