package com.rahulografy.zflickrphotos.ui.main.photos.fragment

import com.rahulografy.zflickrphotos.BR
import com.rahulografy.zflickrphotos.R
import com.rahulografy.zflickrphotos.data.source.remote.photos.model.PhotosModel
import com.rahulografy.zflickrphotos.databinding.FragmentPhotosBinding
import com.rahulografy.zflickrphotos.ui.base.view.BaseFragment
import com.rahulografy.zflickrphotos.ui.main.activity.MainActivity
import com.rahulografy.zflickrphotos.ui.main.photos.adapter.PhotoAdapter
import com.rahulografy.zflickrphotos.util.ext.show

class PhotosFragment :
    BaseFragment<FragmentPhotosBinding, PhotosFragmentViewModel>() {

    override val layoutRes get() = R.layout.fragment_photos

    override var viewModelClass = PhotosFragmentViewModel::class.java

    override val bindingVariable = BR.viewModel

    override fun initUi() {
        getPhotos()
        viewDataBinding.apply {
            photoAdapter = PhotoAdapter()
            executePendingBindings()
        }
    }

    private fun getPhotos() {
        viewModel.getPhotos()
    }

    override fun initObservers() {
        viewModel
            .photosMutableLiveData
            .observe(
                lifecycleOwner = this@PhotosFragment,
                observer = { photosModel ->
                    initPhotosRecyclerView(photosModel = photosModel)
                }
            )
    }

    private fun initPhotosRecyclerView(photosModel: PhotosModel) {
        if (photosModel.photos?.photo.isNullOrEmpty().not()) {
            showPhotosRecyclerView(show = true)
            viewDataBinding.photoAdapter?.submitList(photosModel.photos?.photo)
        } else {
            showPhotosRecyclerView(show = false)
        }
    }

    private fun showPhotosRecyclerView(show: Boolean) {
        viewDataBinding.apply {
            rvPhotos.show(show = show)
            layoutNoData.show(show = show.not())
            (activity as MainActivity).showSnackbar(message = getString(R.string.msg_photos_loaded))
        }
    }
}
