package com.fisio.movieapp.core.util

import com.fisio.movieapp.BuildConfig

fun String?.toPostUrl() = "${BuildConfig.BASE_URL_IMAGE}$this"

fun String?.toBackdrop() = "${BuildConfig.BASE_URL}$this"