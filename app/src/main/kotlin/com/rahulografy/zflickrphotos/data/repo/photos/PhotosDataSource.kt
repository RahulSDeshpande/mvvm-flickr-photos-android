package com.rahulografy.zflickrphotos.data.repo.photos

import com.rahulografy.zflickrphotos.data.source.remote.photos.model.PhotosModel
import io.reactivex.Single

interface PhotosDataSource {

    fun getPhotos(method: String): Single<PhotosModel>
}
