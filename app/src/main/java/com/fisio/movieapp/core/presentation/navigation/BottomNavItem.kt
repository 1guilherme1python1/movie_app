package com.fisio.movieapp.core.presentation.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Movie
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Star
import androidx.compose.ui.graphics.vector.ImageVector

sealed class BottomNavItem (val title: String, val icon: ImageVector, val route: String){
    data object MoviePopular: BottomNavItem(
        title = "Filmes Populares",
        icon = Icons.Default.Movie,
        route = "movie_popular_screen"
    )

    data object MovieSearch: BottomNavItem(
        title = "Pesquisar",
        icon = Icons.Default.Search,
        route = "movie_search"
    )

    data object MovieFavorito: BottomNavItem(
        title = "Favoritos",
        icon = Icons.Default.Star,
        route = "movie_favorito"
    )
}