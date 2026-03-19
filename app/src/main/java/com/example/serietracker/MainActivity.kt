package com.example.serietracker

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import dagger.hilt.android.AndroidEntryPoint
// ⚠️ Vérifie que cet import correspond bien au dossier où tu as rangé EcranAccueil :
import com.example.serietracker.ui.screens.EcranAccueil
import com.example.serietracker.ui.theme.SerieTrackerTheme


@AndroidEntryPoint // 🚨 SUPER IMPORTANT : ça autorise Hilt à injecter le ViewModel ici
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SerieTrackerTheme { // Le thème par défaut de ton app
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    // C'est ici qu'on appelle la magie !
                    EcranAccueil()
                }
            }
        }
    }
}