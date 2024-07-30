package com.fisio.movieapp.movie_popular_feature.presentation.state

import androidx.paging.PagingData
import com.fisio.movieapp.core.domain.model.Movie
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.emptyFlow

data class MoviePopularState(
    val movie: Flow<PagingData<Movie>> = emptyFlow()
)
