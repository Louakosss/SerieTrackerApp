package com.example.serietracker.data.repository

import com.example.serietracker.data.dto.toDomain
import com.example.serietracker.data.remote.EpisoDateApiService
import com.example.serietracker.domain.model.TvShow
import javax.inject.Inject

class TvShowRepository @Inject constructor(
    private val apiService: EpisoDateApiService
) {
    suspend fun getPopularSeries(page: Int = 1): Result<List<TvShow>> {
        return try {

            val response = apiService.getPopularShows(page)


            val series = response.tvShows.map { it.toDomain() }


            Result.success(series)
        } catch (e: Exception) {

            Result.failure(e)
        }
    }
}