package com.fisio.movieapp.search_movie_feature.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.fisio.movieapp.core.domain.model.MovieSearch
import com.fisio.movieapp.search_movie_feature.domain.repository.MovieSearchRepository
import com.fisio.movieapp.search_movie_feature.domain.source.MovieSearchRemoteDataSource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class MovieSearchRepositoryImpl @Inject constructor(
    private val remoteDatSource: MovieSearchRemoteDataSource
) : MovieSearchRepos.repository {
    override fun getPopularMovies(
        query: String,
        pagingConfig: PagingConfig
    ): Flow<PagingData<MovieSearch>> {
        return Pager(
            config = pagingConfig,
            pagingSourceFactory = {
                remoteDatSource.getSearchMoviePagingSource(query)
            }).flow
    }
}