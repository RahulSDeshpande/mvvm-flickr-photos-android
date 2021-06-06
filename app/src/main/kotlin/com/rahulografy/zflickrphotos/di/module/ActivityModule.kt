package com.rahulografy.zflickrphotos.di.module

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.ViewDataBinding
import com.rahulografy.zflickrphotos.di.ActivityScoped
import com.rahulografy.zflickrphotos.ui.base.view.BaseActivity
import com.rahulografy.zflickrphotos.ui.base.view.BaseViewModel
import dagger.Binds
import dagger.Module
import dagger.Provides

@Module
abstract class ActivityModule {

    @Module
    companion object {

        @JvmStatic
        @Provides
        @ActivityScoped
        fun provideFragmentManager(activity: AppCompatActivity) = activity.supportFragmentManager
    }

    @Binds
    @ActivityScoped
    abstract fun bindAppCompatActivity(activity: BaseActivity<ViewDataBinding, BaseViewModel>): AppCompatActivity

    @Binds
    @ActivityScoped
    abstract fun bindActivity(activity: AppCompatActivity): Activity
}
