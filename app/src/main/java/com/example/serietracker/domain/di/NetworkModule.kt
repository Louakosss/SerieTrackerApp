package com.example.serietracker.di // Adapte le package si besoin

import com.example.serietracker.data.remote.EpisoDateApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class) // Le module vivra aussi longtemps que l'application
object NetworkModule {

    // 1. Fournir l'instance de Retrofit
    @Provides
    @Singleton // On veut une seule instance de Retrofit pour toute l'appli
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://www.episodate.com/api/")
            .addConverterFactory(GsonConverterFactory.create()) // Pour transformer le JSON en objets Kotlin
            .build()
    }

    // 2. Fournir l'instance de ton API
    @Provides
    @Singleton
    fun provideEpisoDateApi(retrofit: Retrofit): EpisoDateApiService {
        // Hilt va automatiquement utiliser le Retrofit créé juste au-dessus !
        return retrofit.create(EpisoDateApiService::class.java)
    }
}