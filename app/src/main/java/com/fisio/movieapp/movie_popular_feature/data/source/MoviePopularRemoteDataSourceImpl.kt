package com.fisio.movieapp.movie_popular_feature.data.source

import com.fisio.movieapp.core.data.remote.MovieService
import com.fisio.movieapp.core.data.remote.response.MovieResponse
import com.fisio.movieapp.core.paging.MoviePagingSource
import com.fisio.movieapp.movie_popular_feature.domain.source.MoviePopularRemoteDataSource
import javax.inject.Inject

class MoviePopularRemoteDataSourceImpl
@Inject
constructor(
    private val service: MovieService
) : MoviePopularRemoteDataSource {
    override fun getPopularMoviesPagingSource(): MoviePagingSource {
        return MoviePagingSource(this)
    }

    override suspend fun getPopularMovies(page: Int): MovieResponse {
        return service.getPopularMovies(page)
    }

}