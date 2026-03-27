package com.example.serietracker.domain.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.serietracker.data.repository.TvShowRepository
import com.example.serietracker.domain.model.TvShow
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

data class PopulairesUiState(
    val series: List<TvShow> = emptyList(),
    val isLoading: Boolean = false,
    val messageErreur: String? = null
)

@HiltViewModel
class PopulairesViewModel @Inject constructor(
    private val repository: TvShowRepository
) : ViewModel() {

    private val _uiState = MutableStateFlow(PopulairesUiState())
    val uiState: StateFlow<PopulairesUiState> = _uiState.asStateFlow()

    init {
        chargerSeries()
    }

    fun chargerSeries() {
        _uiState.update { it.copy(isLoading = true, messageErreur = null) }

        viewModelScope.launch {

            val resultat = repository.getPopularSeries(1)

            resultat.onSuccess { listeSeries ->
                _uiState.update {
                    it.copy(series = listeSeries, isLoading = false)
                }
            }

            resultat.onFailure { erreur ->
                _uiState.update {
                    it.copy(isLoading = false, messageErreur = erreur.localizedMessage ?: "Erreur de connexion")
                }
            }
        }
    }
}