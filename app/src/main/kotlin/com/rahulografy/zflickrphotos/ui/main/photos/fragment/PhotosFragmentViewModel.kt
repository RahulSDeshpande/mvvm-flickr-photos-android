package com.rahulografy.zflickrphotos.ui.main.photos.fragment

import androidx.databinding.ObservableBoolean
import com.rahulografy.zflickrphotos.data.repo.photos.PhotosRepository
import com.rahulografy.zflickrphotos.data.source.remote.photos.model.PhotosModel
import com.rahulografy.zflickrphotos.ui.base.view.BaseViewModel
import com.rahulografy.zflickrphotos.util.SingleLiveEvent
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class PhotosFragmentViewModel
@Inject constructor(
    private val photosRepository: PhotosRepository
) : BaseViewModel() {

    companion object {
        const val METHOD_GET_RECENT = "flickr.photos.getRecent"
    }

    val isDataProcessing = ObservableBoolean(false)

    var photosMutableLiveData = SingleLiveEvent<PhotosModel>()

    fun getPhotosForced() {
        getPhotos(force = true)
    }

    fun getPhotos(
        force: Boolean = false,
        showLoader: Boolean = true,
        method: String = METHOD_GET_RECENT
    ) {
        if (force || photosMutableLiveData.value == null) {

            if (showLoader) {
                isDataProcessing.set(true)
            }

            addDisposable(
                disposable = photosRepository
                    .getPhotos(method = method)
                    .subscribeOn(Schedulers.io())
                    .observeOn(scheduleInMainThread())
                    .subscribe(
                        {
                            onPhotosReceived(photos = it)
                        },
                        { error ->
                            photosMutableLiveData.value = null
                            error.printStackTrace()
                        }
                    )
            )
        } else {
            if (showLoader) {
                isDataProcessing.set(false)
            }
            photosMutableLiveData.value = photosMutableLiveData.value
        }
    }

    private fun onPhotosReceived(photos: PhotosModel?) {
        photosMutableLiveData.value = photos
        isDataProcessing.set(false)
    }
}
