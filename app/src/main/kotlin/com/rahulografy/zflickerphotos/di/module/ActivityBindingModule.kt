package com.rahulografy.zflickerphotos.di.module

import com.rahulografy.zflickerphotos.di.ActivityScoped
import com.rahulografy.zflickerphotos.ui.main.activity.MainActivity
import com.rahulografy.zflickerphotos.ui.main.activity.MainActivityModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
internal abstract class ActivityBindingModule {

    @ActivityScoped
    @ContributesAndroidInjector(modules = [MainActivityModule::class])
    internal abstract fun bindHomeActivity(): MainActivity
}
