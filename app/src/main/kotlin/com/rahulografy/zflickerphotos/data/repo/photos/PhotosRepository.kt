package com.rahulografy.zflickerphotos.data.repo.photos

import com.rahulografy.zflickerphotos.data.source.remote.photos.service.PhotosRemoteService
import com.rahulografy.zflickerphotos.di.ApplicationScoped
import com.rahulografy.zflickerphotos.di.qualifier.RemoteData
import javax.inject.Inject

@ApplicationScoped
class PhotosRepository @Inject constructor(
    @RemoteData private val photosDataSource: PhotosDataSource,
) : PhotosRemoteService {

    override fun getPhotos(method: String) =
        photosDataSource.getPhotos(method = method)
}
