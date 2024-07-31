package com.fisio.movieapp.core.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.fisio.movieapp.movie_popular_feature.presentation.MoviePopularScreen
import com.fisio.movieapp.movie_popular_feature.presentation.MoviePopularViewModel

@Composable
fun NavigationGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = BottomNavItem.MoviePopular.route
    ){
        composable(BottomNavItem.MoviePopular.route){

//            val viewModel: MoviePopularViewModel = hiltViewModel()
//            val uiState = viewModel.uiState
//
//
//            MoviePopularScreen(uiState, navigateToDetailMovie = {})
        }
        composable(BottomNavItem.MovieSearch.route){

        }
        composable(BottomNavItem.MovieFavorito.route){

        }

    }
}