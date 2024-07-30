package com.fisio.movieapp.core.domain.model

data class MovieSearch (
    val id: Int,
    val voteAvarage: Double = 0.0,
    val imageUrl: String = ""
)