package com.fisio.movieapp.movie_popular_feature.presentation

import androidx.compose.foundation.background
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.paging.compose.collectAsLazyPagingItems
import com.fisio.movieapp.R
import com.fisio.movieapp.core.util.UtilFunctions
import com.fisio.movieapp.movie_popular_feature.presentation.components.MovieContent
import com.fisio.movieapp.movie_popular_feature.presentation.state.MoviePopularState

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MoviePopularScreen(
    uiState: MoviePopularState,
    navigateToDetailMovie: (Int) -> Unit
) {
    val movies = uiState.movies.collectAsLazyPagingItems()

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = stringResource(id = R.string.popular_movies),
                        color = Color.White
                    )
                },
                Modifier.background(color = Color.Black)
            )
        },
        content = { paddingValue ->
            MovieContent(
                modifier = Modifier,
                pagingMovies = movies,
                paddingValues = paddingValue,
                onClick = { movieId ->
                    UtilFunctions.logInfo("Movie_id", movieId.toString())
                    navigateToDetailMovie(movieId)
                }
            )
        }
    )
}