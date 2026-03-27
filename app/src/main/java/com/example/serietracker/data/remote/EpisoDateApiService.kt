package com.example.serietracker.data.remote

import com.example.serietracker.data.dto.PopularResponseDto
import retrofit2.http.GET
import retrofit2.http.Query

//On déclare une interface
interface EpisoDateApiService {

    @GET("most-popular")
    suspend fun getPopularShows(
        @Query("page") page: Int = 1
    ): PopularResponseDto

}

