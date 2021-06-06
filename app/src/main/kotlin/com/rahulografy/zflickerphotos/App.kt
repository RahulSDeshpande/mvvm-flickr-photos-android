package com.rahulografy.zflickerphotos

import android.content.Context
import android.preference.PreferenceManager
import androidx.multidex.MultiDex
import com.facebook.stetho.Stetho
import com.rahulografy.zflickerphotos.di.component.DaggerAppComponent
import com.rahulografy.zflickerphotos.util.ext.prefs
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication

open class App : DaggerApplication() {

    private lateinit var androidInjector: AndroidInjector<out DaggerApplication>

    override fun onCreate() {
        super.onCreate()

        // Init Stetho
        Stetho.initializeWithDefaults(this)

        prefs = PreferenceManager.getDefaultSharedPreferences(this)
    }

    override fun attachBaseContext(base: Context?) {
        super.attachBaseContext(base)

        MultiDex.install(this)

        androidInjector = DaggerAppComponent.builder().application(this).build()
    }

    public override fun applicationInjector() = androidInjector
}
