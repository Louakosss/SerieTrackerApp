package com.example.serietracker.data.repository

import com.example.serietracker.data.dto.toDomain
import com.example.serietracker.data.remote.EpisoDateApiService
import com.example.serietracker.domain.model.TvShow
import javax.inject.Inject

// @Inject constructor dit à Hilt d'injecter automatiquement l'ApiService qu'on a créé tout à l'heure
class TvShowRepository @Inject constructor(
    private val apiService: EpisoDateApiService
) {
    suspend fun getPopularSeries(page: Int = 1): Result<List<TvShow>> {
        return try {
            // 1. On appelle l'API
            val response = apiService.getPopularShows(page)

            // 2. On transforme les DTOs (données réseau) en TvShow (données pour ton UI)
            val series = response.tvShows.map { it.toDomain() }

            // 3. On renvoie un succès avec la liste
            Result.success(series)
        } catch (e: Exception) {
            // En cas d'erreur (pas d'internet, crash API...), on renvoie un échec
            Result.failure(e)
        }
    }
}