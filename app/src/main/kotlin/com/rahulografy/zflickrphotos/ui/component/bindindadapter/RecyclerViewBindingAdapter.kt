package com.rahulografy.zflickrphotos.ui.component.bindindadapter

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.rahulografy.zflickrphotos.ui.main.photos.adapter.PhotoAdapter
import com.rahulografy.zflickrphotos.util.ext.list

@BindingAdapter("app:adapter")
fun RecyclerView?.setPhotoAdapter(
    photoAdapter: PhotoAdapter?
) {
    this?.apply {
        list()
        adapter = photoAdapter
    }
}
