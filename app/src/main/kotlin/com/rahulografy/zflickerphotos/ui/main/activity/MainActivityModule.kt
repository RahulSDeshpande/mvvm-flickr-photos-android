package com.rahulografy.zflickerphotos.ui.main.activity

import com.rahulografy.zflickerphotos.di.FragmentScoped
import com.rahulografy.zflickerphotos.ui.main.photos.fragment.PhotosFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class MainActivityModule {

    @FragmentScoped
    @ContributesAndroidInjector
    abstract fun bindPhotosFragment(): PhotosFragment
}
