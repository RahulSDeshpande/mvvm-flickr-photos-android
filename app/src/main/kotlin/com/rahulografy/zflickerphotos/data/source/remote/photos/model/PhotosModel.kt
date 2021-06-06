package com.rahulografy.zflickerphotos.data.source.remote.photos.model

import com.google.gson.annotations.SerializedName

data class PhotosModel(
    @SerializedName("photos") val photos: Photos?,
    @SerializedName("stat") val stat: String?
)
