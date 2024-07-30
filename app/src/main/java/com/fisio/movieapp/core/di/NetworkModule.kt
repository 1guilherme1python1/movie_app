package com.fisio.movieapp.core.di

import com.fisio.movieapp.BuildConfig
import com.fisio.movieapp.core.data.remote.MovieService
import com.fisio.movieapp.core.data.remote.ParamsInterceptor
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {
    private const val TIMEOUT_SECOUNDS = 15L

    @Provides
    fun provideParamsInterceptor(): ParamsInterceptor{
        return ParamsInterceptor()
    }

    @Provides
    fun providerLogginInterceptor(): HttpLoggingInterceptor{
        return HttpLoggingInterceptor().apply {
            setLevel(
                if(BuildConfig.DEBUG){
                    HttpLoggingInterceptor.Level.BODY
                } else {
                    HttpLoggingInterceptor.Level.NONE
                }
            )
        }
    }

    //responsabilidade de fazer as requests
    @Provides
    fun providerOkHttpClient(
        paramsInterceptor: ParamsInterceptor,
        loggingInterceptor: HttpLoggingInterceptor
    ): OkHttpClient{
        return OkHttpClient
            .Builder()
            .addInterceptor(paramsInterceptor)
            .addInterceptor(loggingInterceptor)
            .readTimeout(TIMEOUT_SECOUNDS, TimeUnit.SECONDS)
            .connectTimeout(TIMEOUT_SECOUNDS, TimeUnit.SECONDS)
            .build()
    }

    @Provides
    fun providerGsonConverterFactory() : GsonConverterFactory{
        return GsonConverterFactory.create()
    }

    @Provides
    fun providerMovieService(
        client: OkHttpClient,
        converterFactory: GsonConverterFactory
    ): MovieService {
        return Retrofit
            .Builder()
            .baseUrl(BuildConfig.BASE_URL)
            .client(client)
            .addConverterFactory(converterFactory)
            .build()
            .create(MovieService::class.java)
    }
}