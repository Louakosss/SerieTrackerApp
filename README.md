#  SerieTracker

Une application Android moderne développée en Kotlin pour découvrir et suivre les séries TV populaires.

Ce projet a été réalisé pour mettre en pratique les standards de développement Android de 2024.

##  Fonctionnalités
* Affichage d'une liste dynamique des séries populaires.
* Chargement asynchrone et mise en cache des images des séries.
* Gestion des états de chargement (Loading, Success, Error).

##  Architecture
Le projet respecte strictement la **Clean Architecture** et le motif **MVVM** (Model-View-ViewModel) pour garantir un code testable, maintenable et évolutif :
* **Couche UI** : Jetpack Compose + ViewModel (gestion des états avec StateFlow).
* **Couche Domain** : Modèles de données purs (métier).
* **Couche Data** : Repository et appels réseau (API).

##  Technologies et Librairies utilisées
* **Langage :** [Kotlin](https://kotlinlang.org/)
* **UI :** [Jetpack Compose](https://developer.android.com/jetpack/compose) (Material Design 3)
* **Architecture :** MVVM, Coroutines & Flow
* **Réseau :** [Retrofit](https://square.github.io/retrofit/) & Gson (pour le parsing JSON)
* **Images :** [Coil](https://coil-kt.github.io/coil/) (pour le chargement asynchrone)
* **Injection de dépendances :** [Dagger Hilt](https://dagger.dev/hilt/)

##  Comment lancer le projet ?
1. Clonez ce dépôt sur votre machine locale.
2. Ouvrez le projet avec **Android Studio** (version Jellyfish ou supérieure recommandée).
3. Laissez Gradle synchroniser les dépendances (Patientez jusqu'à la fin du build).
4. Lancez l'application sur un émulateur ou un appareil physique via le bouton "Run".