package com.rahulografy.zflickerphotos.ui.component.bindindadapter

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.rahulografy.zflickerphotos.ui.main.photos.adapter.PhotoAdapter
import com.rahulografy.zflickerphotos.util.ext.list

@BindingAdapter("app:adapter")
fun RecyclerView?.setPhotoAdapter(
    photoAdapter: PhotoAdapter?
) {
    this?.apply {
        list()
        adapter = photoAdapter
    }
}
