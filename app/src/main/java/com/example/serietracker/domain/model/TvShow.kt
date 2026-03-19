package com.example.serietracker.domain.model


data class TvShow(
    val id: Int,
    val name: String,
    val network: String,
    val country: String,
    val status: String,
    val imageThumbnailPath: String
)

