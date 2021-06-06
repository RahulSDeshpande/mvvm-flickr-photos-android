package com.rahulografy.zflickerphotos.di.module

import com.rahulografy.zflickerphotos.data.repo.photos.PhotosDataSource
import com.rahulografy.zflickerphotos.data.source.remote.photos.datasource.PhotosRemoteDataSource
import com.rahulografy.zflickerphotos.di.qualifier.RemoteData
import dagger.Binds
import dagger.Module

@Module
abstract class RepositoryModule {

    @Binds
    @RemoteData
    abstract fun bindPhotosRemoteDataSource(
        photosRemoteDataSource: PhotosRemoteDataSource
    ): PhotosDataSource
}
