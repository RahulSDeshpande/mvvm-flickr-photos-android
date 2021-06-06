package com.rahulografy.zflickrphotos.di.module

import android.app.Application
import android.content.Context
import com.rahulografy.zflickrphotos.App
import com.rahulografy.zflickrphotos.di.ApplicationScoped
import com.rahulografy.zflickrphotos.di.qualifier.ApplicationContext
import dagger.Binds
import dagger.Module

@Module
abstract class AppModule {

    @Binds
    @ApplicationScoped
    @ApplicationContext
    abstract fun bindApplicationContext(app: App): Context

    @Binds
    @ApplicationScoped
    abstract fun bindApplication(app: App): Application
}
