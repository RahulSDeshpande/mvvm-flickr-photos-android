package com.rahulografy.zflickrphotos.ui.main.photos.adapter

import androidx.recyclerview.widget.DiffUtil
import com.rahulografy.zflickrphotos.data.source.remote.photos.model.Photo

class PhotosDiffUtilItemCallback : DiffUtil.ItemCallback<Photo>() {

    override fun areItemsTheSame(
        oldItem: Photo,
        newItem: Photo
    ) = oldItem.id == newItem.id

    override fun areContentsTheSame(
        oldItem: Photo,
        newItem: Photo
    ) = oldItem.id == newItem.id
}
