package com.rahulografy.zflickerphotos.ui.component.bindindadapter

import androidx.databinding.BindingAdapter
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout

@BindingAdapter("app:isRefreshing")
fun SwipeRefreshLayout.isRefreshing(isRefreshing: Boolean) {
    this.isRefreshing = isRefreshing
}

@BindingAdapter("app:onRefreshListener")
fun SwipeRefreshLayout.setOnRefreshListener(function: () -> Unit) {
    setOnRefreshListener { function() }
}
