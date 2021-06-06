package com.rahulografy.zflickerphotos.data.source.remote.photos.model

import com.google.gson.annotations.SerializedName

data class Photo(
    @SerializedName("id") val id: String?,
    @SerializedName("server") val server: String?,
    @SerializedName("secret") val secret: String?,
    @SerializedName("title") val title: String?
)
