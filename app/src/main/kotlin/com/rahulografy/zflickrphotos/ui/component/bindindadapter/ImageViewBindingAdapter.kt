package com.rahulografy.zflickrphotos.ui.component.bindindadapter

import androidx.appcompat.widget.AppCompatImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions.withCrossFade
import com.bumptech.glide.request.RequestOptions
import com.rahulografy.zflickrphotos.R
import com.rahulografy.zflickrphotos.data.source.remote.photos.model.Photo
import com.rahulografy.zflickrphotos.util.Constants.Network.Api.PHOTO_BASE_URL

@BindingAdapter("app:url")
fun AppCompatImageView?.setUrl(url: String) {
    this?.apply {
        Glide
            .with(this)
            .load(url)
    }
}

@BindingAdapter("app:photo")
fun AppCompatImageView?.setPhoto(photo: Photo) {
    this?.apply {
        Glide
            .with(this.context)
            .setDefaultRequestOptions(
                RequestOptions()
                    .placeholder(R.drawable.flickr_logo)
                    .error(R.drawable.flickr_logo)
            )
            .load("$PHOTO_BASE_URL/${photo.server}/${photo.id}_${photo.secret}.jpg")
            .transition(withCrossFade())
            .into(this)
    }
}
