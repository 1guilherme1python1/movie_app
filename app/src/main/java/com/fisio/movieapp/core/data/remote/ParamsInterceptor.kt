package com.fisio.movieapp.core.data.remote

import com.fisio.movieapp.BuildConfig
import com.fisio.movieapp.core.util.Constantes
import okhttp3.Interceptor
import okhttp3.Response

class ParamsInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()

        val url = request.url.newBuilder()
            .addQueryParameter(Constantes.LANGUAGEM_PARAM, Constantes.LANGUAGEM_VALUE)
            .addQueryParameter(Constantes.API_KEY_PARAM, BuildConfig.API_KEY)
            .build()

        val newRequest = request.newBuilder().url(url).build()

        return chain.proceed(newRequest)
    }
}