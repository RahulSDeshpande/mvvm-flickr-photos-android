package com.rahulografy.zflickrphotos.di.module

import com.rahulografy.zflickrphotos.data.repo.photos.PhotosDataSource
import com.rahulografy.zflickrphotos.data.source.remote.photos.datasource.PhotosRemoteDataSource
import com.rahulografy.zflickrphotos.di.qualifier.RemoteData
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
