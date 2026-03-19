package com.example.serietracker.data.remote

import com.example.serietracker.data.dto.PopularResponseDto
import retrofit2.http.GET
import retrofit2.http.Query

// 1. On déclare une interface
interface EpisoDateApiService {

    // 2. On ajoute l'annotation @GET avec le chemin de l'API (à adapter selon la doc d'EpisoDate)
    @GET("most-popular")
    suspend fun getPopularShows(
        @Query("page") page: Int = 1
    ): PopularResponseDto

}

