package com.rahulografy.zflickrphotos.data.source.remote.photos.service

import com.rahulografy.zflickrphotos.data.source.remote.photos.model.PhotosModel
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface PhotosRemoteService {

    @GET(".")
    fun getPhotos(@Query("method") method: String): Single<PhotosModel>
}
