package com.fisio.movieapp.core.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.fisio.movieapp.core.domain.model.MovieSearch
import com.fisio.movieapp.search_movie_feature.domain.source.MovieSearchRemoteDataSource

class MovieSearchPagingSource(
    private val query: String,
    private val remoteDataSource: MovieSearchRemoteDataSource
)  : PagingSource<Int, MovieSearch>(){
    override fun getRefreshKey(state: PagingState<Int, MovieSearch>): Int? {
        TODO("Not yet implemented")
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, MovieSearch> {
        TODO("Not yet implemented")
    }

}