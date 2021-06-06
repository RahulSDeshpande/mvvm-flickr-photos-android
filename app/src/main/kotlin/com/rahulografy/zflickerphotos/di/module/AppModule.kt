package com.rahulografy.zflickerphotos.di.module

import android.app.Application
import android.content.Context
import com.rahulografy.zflickerphotos.App
import com.rahulografy.zflickerphotos.di.ApplicationScoped
import com.rahulografy.zflickerphotos.di.qualifier.ApplicationContext
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
