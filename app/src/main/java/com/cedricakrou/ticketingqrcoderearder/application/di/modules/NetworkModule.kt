package com.cedricakrou.ticketingqrcoderearder.application.di.modules

import android.content.Context
import com.cedricakrou.ticketingqrcoderearder.infrastructure.remote.ApiService
import com.cedricakrou.ticketingqrcoderearder.infrastructure.remote.Config
import com.facebook.stetho.okhttp3.StethoInterceptor
import dagger.Module
import dagger.Provides
import okhttp3.Cache
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.jackson.JacksonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
class NetworkModule {

    @Provides
    @Singleton
    fun providesOkHttpCache( context: Context ) : Cache = Cache( context.cacheDir, 1024 )

    @Provides
    @Singleton
    fun providesOkHttpClient( cache: Cache ) : OkHttpClient{

        val client = OkHttpClient.Builder()
            .cache(cache)
            .connectTimeout(30, TimeUnit.SECONDS)
            .writeTimeout(30, TimeUnit.SECONDS)
            .readTimeout(30, TimeUnit.SECONDS)
            .cache(cache)
            .addNetworkInterceptor( StethoInterceptor() )

        return client.build()
    }


    @Provides
    @Singleton
    fun providesRetrofit( okHttpClient: OkHttpClient) : Retrofit {


        return Retrofit.Builder()
            .baseUrl( Config.API_BASE_URL )
            .addConverterFactory( JacksonConverterFactory.create() )
            .client( okHttpClient )
            .build()
    }

    @Provides
    @Singleton
    fun providesApiService( retrofit: Retrofit ) : ApiService = retrofit.create( ApiService::class.java )

}