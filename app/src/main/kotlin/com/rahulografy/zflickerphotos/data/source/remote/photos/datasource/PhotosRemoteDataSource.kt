package com.rahulografy.zflickerphotos.data.source.remote.photos.datasource

import com.rahulografy.zflickerphotos.data.repo.photos.PhotosDataSource
import com.rahulografy.zflickerphotos.data.source.remote.photos.service.PhotosRemoteService
import com.rahulografy.zflickerphotos.di.ApplicationScoped
import javax.inject.Inject

@ApplicationScoped
class PhotosRemoteDataSource
@Inject constructor(
    private val photosRemoteService: PhotosRemoteService
) : PhotosDataSource {

    override fun getPhotos(method: String) =
        photosRemoteService.getPhotos(method = method)
}
