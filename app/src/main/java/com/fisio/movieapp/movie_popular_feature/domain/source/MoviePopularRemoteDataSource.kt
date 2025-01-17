package com.fisio.movieapp.movie_popular_feature.domain.source

import com.fisio.movieapp.core.data.remote.response.MovieResponse
import com.fisio.movieapp.core.paging.MoviePagingSource

interface MoviePopularRemoteDataSource {

    fun getPopularMoviesPagingSource(): MoviePagingSource

    suspend fun getPopularMovies(page: Int): MovieResponse
}