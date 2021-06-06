package com.rahulografy.zflickrphotos.data.repo.photos

import com.rahulografy.zflickrphotos.data.source.remote.photos.service.PhotosRemoteService
import com.rahulografy.zflickrphotos.di.ApplicationScoped
import com.rahulografy.zflickrphotos.di.qualifier.RemoteData
import javax.inject.Inject

@ApplicationScoped
class PhotosRepository @Inject constructor(
    @RemoteData private val photosDataSource: PhotosDataSource,
) : PhotosRemoteService {

    override fun getPhotos(method: String) =
        photosDataSource.getPhotos(method = method)
}
