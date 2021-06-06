package com.rahulografy.zflickrphotos.di.module

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.rahulografy.zflickrphotos.di.ApplicationScoped
import com.rahulografy.zflickrphotos.di.ViewModelKey
import com.rahulografy.zflickrphotos.ui.main.activity.MainActivityViewModel
import com.rahulografy.zflickrphotos.ui.main.photos.fragment.PhotosFragmentViewModel
import com.rahulografy.zflickrphotos.util.ViewModelFactory
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module(
    includes = [
        AppModule::class,
        RepositoryModule::class
    ]
)
abstract class ViewModelModule {

    @ApplicationScoped
    @Binds
    abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(MainActivityViewModel::class)
    abstract fun bindHomeActivityViewModel(viewModel: MainActivityViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(PhotosFragmentViewModel::class)
    abstract fun bindPhotosFragmentViewModel(viewModel: PhotosFragmentViewModel): ViewModel
}
