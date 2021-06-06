package com.rahulografy.zflickrphotos.ui.main.activity

import com.rahulografy.zflickrphotos.di.FragmentScoped
import com.rahulografy.zflickrphotos.ui.main.photos.fragment.PhotosFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class MainActivityModule {

    @FragmentScoped
    @ContributesAndroidInjector
    abstract fun bindPhotosFragment(): PhotosFragment
}
