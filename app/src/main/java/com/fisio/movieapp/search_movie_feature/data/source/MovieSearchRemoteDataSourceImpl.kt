package com.fisio.movieapp.search_movie_feature.data.source

import com.fisio.movieapp.core.data.remote.MovieService
import com.fisio.movieapp.core.data.remote.response.SearchResponse
import com.fisio.movieapp.core.paging.MovieSearchPagingSource
import com.fisio.movieapp.search_movie_feature.domain.source.MovieSearchRemoteDataSource
import javax.inject.Inject

class MovieSearchRemoteDataSourceImpl @Inject constructor (
    private val service: MovieService
) : MovieSearchRemoteDataSource {
    override fun getSearchMoviePagingSource(query: String): MovieSearchPagingSource {
        return MovieSearchPagingSource(query, this)
    }

    override suspend fun getSearchMovies(page: Int, query: String): SearchResponse {
        return service.searchMovie(page, query)
    }
}