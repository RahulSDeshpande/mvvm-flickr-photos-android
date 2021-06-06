package com.rahulografy.zflickrphotos.di.module

import com.rahulografy.zflickrphotos.di.ActivityScoped
import com.rahulografy.zflickrphotos.ui.main.activity.MainActivity
import com.rahulografy.zflickrphotos.ui.main.activity.MainActivityModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
internal abstract class ActivityBindingModule {

    @ActivityScoped
    @ContributesAndroidInjector(modules = [MainActivityModule::class])
    internal abstract fun bindHomeActivity(): MainActivity
}
