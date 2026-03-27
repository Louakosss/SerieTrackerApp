package com.example.serietracker.data.dto

import com.google.gson.annotations.SerializedName
import com.example.serietracker.domain.model.TvShow

// 1. Le modèle brut de l'API
data class TvShowDto(
    @SerializedName("id")
    val id: Int?,

    @SerializedName("name")
    val name: String?,

    @SerializedName("image_thumbnail_path")
    val imageThumbnailPath: String?,

    @SerializedName("status")
    val status: String?,

    // 🚨 On ajoute les deux champs qui manquaient :
    @SerializedName("network")
    val network: String?,

    @SerializedName("country")
    val country: String?
)

// 2. Le Mapper
fun TvShowDto.toDomain(): TvShow {
    return TvShow(
        id = this.id ?: 0,
        name = this.name ?: "Titre inconnu",
        network = this.network ?: "inconnu",
        country = this.country ?: "inconnu",
        imageThumbnailPath = this.imageThumbnailPath ?: "",
        status = this.status ?: "Inconnu"
    )
}