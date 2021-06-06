package com.rahulografy.zflickerphotos.di.component

import com.rahulografy.zflickerphotos.App
import com.rahulografy.zflickerphotos.di.ApplicationScoped
import com.rahulografy.zflickerphotos.di.module.*
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule

@ApplicationScoped
@Component(
    modules = [
        AndroidSupportInjectionModule::class,
        AppModule::class,
        ActivityBindingModule::class,
        ViewModelModule::class,
        NetworkModule::class,
        RepositoryModule::class
    ]
)
interface AppComponent : AndroidInjector<App> {

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(application: App): Builder

        fun build(): AppComponent
    }
}
