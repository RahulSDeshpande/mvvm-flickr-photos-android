package com.rahulografy.zflickerphotos.di.module

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.ViewDataBinding
import com.rahulografy.zflickerphotos.di.ActivityScoped
import com.rahulografy.zflickerphotos.ui.base.view.BaseActivity
import com.rahulografy.zflickerphotos.ui.base.view.BaseViewModel
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
