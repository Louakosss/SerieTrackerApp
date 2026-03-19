// Attention : vérifie que ce "package" correspond bien à ton dossier actuel
package com.example.serietracker.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

// LES IMPORTS MAGIQUES QUI TE MANQUAIENT :
import androidx.hilt.navigation.compose.hiltViewModel // [cite: 657, 665]
import androidx.lifecycle.compose.collectAsStateWithLifecycle // [cite: 212, 666]
import com.example.serietracker.domain.ui.components.CarteSerie
import com.example.serietracker.domain.ui.viewmodel.PopulairesViewModel

// LES IMPORTS DE TES CLASSES (⚠️ Si c'est rouge ici, efface la ligne et retape-la doucement pour qu'Android Studio te propose le bon chemin)


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EcranAccueil(
    viewModel: PopulairesViewModel = hiltViewModel()
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(title = { Text("Séries Populaires") })
        }
    ) { padding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding),
            contentAlignment = Alignment.Center
        ) {
            when {
                // 1. Chargement [cite: 213]
                uiState.isLoading -> {
                    CircularProgressIndicator()
                }

                // 2. Erreur [cite: 213]
                uiState.messageErreur != null -> {
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Text(text = "Erreur : ${uiState.messageErreur}", color = Color.Red)
                        Spacer(modifier = Modifier.height(8.dp))
                        Button(onClick = { viewModel.chargerSeries() }) {
                            Text("Réessayer")
                        }
                    }
                }

                // 3. Succès (Liste de séries) [cite: 216]
                else -> {
                    LazyColumn(
                        modifier = Modifier.fillMaxSize(),
                        contentPadding = PaddingValues(8.dp),
                        verticalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        items(uiState.series) { serie ->
                            CarteSerie(serie = serie)
                        }
                    }
                }
            }
        }
    }
}