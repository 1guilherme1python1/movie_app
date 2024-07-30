package com.fisio.movieapp.movie_popular_feature.data.mapper

import com.fisio.movieapp.core.data.remote.model.MovieResult
import com.fisio.movieapp.core.domain.model.Movie
import com.fisio.movieapp.core.util.toPostUrl

fun List<MovieResult>.toMovie() = map{movieResult ->
    Movie(
        id = movieResult.id,
        title = movieResult.title,
        voteAverage = movieResult.voteAverage,
        imageUrl = movieResult.posterPath?.toPostUrl() ?: ""
    )
}