package com.fisio.movieapp.movie_popular_feature.di

import com.fisio.movieapp.core.data.remote.MovieService
import com.fisio.movieapp.movie_popular_feature.data.repository.MoviePopularRepositoryImpl
import com.fisio.movieapp.movie_popular_feature.data.source.MoviePopularRemoteDataSourceImpl
import com.fisio.movieapp.movie_popular_feature.domain.repository.MoviePopularRepository
import com.fisio.movieapp.movie_popular_feature.domain.source.MoviePopularRemoteDataSource
import com.fisio.movieapp.movie_popular_feature.domain.usecase.GetPopularMoviesUseCase
import com.fisio.movieapp.movie_popular_feature.domain.usecase.GetPopularMoviesUseCaseImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object MoviePopularFeatureModule {

    @Provides
    @Singleton
    fun provideMovieDataSource(service: MovieService) : MoviePopularRemoteDataSource{
        return MoviePopularRemoteDataSourceImpl(service)
    }

    @Provides
    @Singleton
    fun providerMovieRepository(remoteDataSource: MoviePopularRemoteDataSource): MoviePopularRepository{
        return MoviePopularRepositoryImpl(remoteDataSource);
    }

    @Provides
    @Singleton
    fun providerGetMoviesPopularUseCases(moviePopularRepository: MoviePopularRepository) : GetPopularMoviesUseCase{
        return GetPopularMoviesUseCaseImpl(moviePopularRepository);
    }
}