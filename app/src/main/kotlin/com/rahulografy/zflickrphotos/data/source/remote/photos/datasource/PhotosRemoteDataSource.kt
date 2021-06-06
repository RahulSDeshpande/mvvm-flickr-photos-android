package com.rahulografy.zflickrphotos.data.source.remote.photos.datasource

import com.rahulografy.zflickrphotos.data.repo.photos.PhotosDataSource
import com.rahulografy.zflickrphotos.data.source.remote.photos.service.PhotosRemoteService
import com.rahulografy.zflickrphotos.di.ApplicationScoped
import javax.inject.Inject

@ApplicationScoped
class PhotosRemoteDataSource
@Inject constructor(
    private val photosRemoteService: PhotosRemoteService
) : PhotosDataSource {

    override fun getPhotos(method: String) =
        photosRemoteService.getPhotos(method = method)
}
