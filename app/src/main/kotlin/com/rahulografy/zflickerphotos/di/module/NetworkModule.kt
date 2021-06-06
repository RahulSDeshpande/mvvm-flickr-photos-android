package com.rahulografy.zflickerphotos.di.module

import android.app.Application
import com.facebook.stetho.okhttp3.StethoInterceptor
import com.rahulografy.zflickerphotos.data.source.remote.photos.service.PhotosRemoteService
import com.rahulografy.zflickerphotos.di.ApplicationScoped
import com.rahulografy.zflickerphotos.util.Constants.Network.Api.API_BASE_URL
import com.rahulografy.zflickerphotos.util.Constants.Network.Api.API_KEY
import com.rahulografy.zflickerphotos.util.Constants.Network.Api.API_RESPONSE_FORMAT
import com.rahulografy.zflickerphotos.util.Constants.Network.Cache.NAME
import com.rahulografy.zflickerphotos.util.Constants.Network.Timeout.CONNECTION
import com.rahulografy.zflickerphotos.util.Constants.Network.Timeout.READ
import com.rahulografy.zflickerphotos.util.Constants.Network.Timeout.WRITE
import com.rahulografy.zflickerphotos.util.Memory
import dagger.Module
import dagger.Provides
import java.io.File
import java.util.concurrent.TimeUnit
import okhttp3.Cache
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.logging.HttpLoggingInterceptor
import okhttp3.logging.HttpLoggingInterceptor.Level.BODY
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

@Module
class NetworkModule {

    private fun buildOkHttpClient(application: Application): OkHttpClient =
        OkHttpClient
            .Builder()
            .addNetworkInterceptor(getAuthInterceptor())
            .addNetworkInterceptor(StethoInterceptor())
            .addNetworkInterceptor(HttpLoggingInterceptor().setLevel(BODY))
            .connectTimeout(CONNECTION, TimeUnit.SECONDS)
            .writeTimeout(WRITE, TimeUnit.SECONDS)
            .readTimeout(READ, TimeUnit.SECONDS)
            .cache(
                Cache(
                    File(application.cacheDir, NAME),
                    Memory.calculateCacheSize(context = application, size = .25f)
                )
            )
            .build()

    private fun getAuthInterceptor() =
        Interceptor { chain ->
            var request: Request = chain.request()

            val httpUrl =
                request
                    .url()
                    .newBuilder()
                    .addQueryParameter(
                        "api_key",
                        API_KEY
                    )
                    .addQueryParameter(
                        "format",
                        API_RESPONSE_FORMAT
                    )
                    .addQueryParameter(
                        "nojsoncallback",
                        "1"
                    )
                    .build()

            request = request.newBuilder().url(httpUrl).build()

            chain.proceed(request)
        }

    @Provides
    @ApplicationScoped
    fun provideOkHttpClient(application: Application): OkHttpClient = buildOkHttpClient(application)

    @Provides
    @ApplicationScoped
    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit =
        Retrofit
            .Builder()
            .baseUrl(API_BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()

    @Provides
    @ApplicationScoped
    fun providePhotosRemoteService(retrofit: Retrofit): PhotosRemoteService =
        retrofit.create(PhotosRemoteService::class.java)
}
