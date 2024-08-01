package com.fisio.movieapp.search_movie_feature.domain.repository

import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.fisio.movieapp.core.domain.model.MovieSearch
import kotlinx.coroutines.flow.Flow

interface MovieSearchRepository {
    fun getPopularMovies(query: String, pagingConfig: PagingConfig): Flow<PagingData<MovieSearch>>
}