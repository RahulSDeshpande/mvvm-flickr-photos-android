package com.rahulografy.zflickerphotos.data.repo.photos

import com.rahulografy.zflickerphotos.data.source.remote.photos.model.PhotosModel
import io.reactivex.Single

interface PhotosDataSource {

    fun getPhotos(method: String): Single<PhotosModel>
}
