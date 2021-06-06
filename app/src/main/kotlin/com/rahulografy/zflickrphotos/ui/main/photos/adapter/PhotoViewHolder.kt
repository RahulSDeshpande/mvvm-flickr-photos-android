package com.rahulografy.zflickrphotos.ui.main.photos.adapter

import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.rahulografy.zflickrphotos.data.source.remote.photos.model.Photo
import com.rahulografy.zflickrphotos.databinding.ItemPhotoBinding
import com.rahulografy.zflickrphotos.util.Constants.Network.Api.API_SECRET

class PhotoViewHolder(private val binding: ItemPhotoBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(photo: Photo) {
        binding.apply {

            this.photo = photo

            Glide
                .with(ivPhoto)
                .load(
                    getPhotoUrl(
                        serverId = photo.server,
                        photoId = photo.id
                    )
                )

            tvTitle.text = photo.title

            executePendingBindings()
        }
    }

    private fun getPhotoUrl(serverId: String?, photoId: String?) =
        "https://live.staticflickr.com/$serverId/${photoId}_$API_SECRET.jpg"
}
