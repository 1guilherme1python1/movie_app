package com.fisio.movieapp.search_movie_feature.domain.source

import com.fisio.movieapp.core.data.remote.response.SearchResponse
import com.fisio.movieapp.core.paging.MovieSearchPagingSource

interface MovieSearchRemoteDataSource {
    fun getSearchMoviePagingSource(query: String) : MovieSearchPagingSource
    suspend fun getSearchMovies(page: Int, query: String): SearchResponse
}