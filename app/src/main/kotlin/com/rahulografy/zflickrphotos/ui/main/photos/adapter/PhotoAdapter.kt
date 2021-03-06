package com.rahulografy.zflickrphotos.ui.main.photos.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.rahulografy.zflickrphotos.R
import com.rahulografy.zflickrphotos.data.source.remote.photos.model.Photo
import com.rahulografy.zflickrphotos.ui.base.adapter.BaseListAdapter

class PhotoAdapter :
    BaseListAdapter<Photo, PhotoViewHolder>(
        diffCallback = PhotosDiffUtilItemCallback()
    ) {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ) = PhotoViewHolder(
        DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.item_photo,
            parent,
            false
        )
    )

    override fun onBindViewHolder(
        viewHolder: PhotoViewHolder,
        position: Int
    ) = viewHolder.bind(
        photo = getItem(position)
    )

    override fun setData(data: List<Photo>?) {
        submitList(data)
    }

    override fun addData(data: List<Photo>?) {
        // TODO | API PAGINATION
    }
}
