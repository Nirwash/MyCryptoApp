package com.nirwashh.android.mycryptoapp.di

import com.nirwashh.android.mycryptoapp.activities.MainActivity
import dagger.Component
import javax.inject.Singleton

@Component(modules = [AppModule::class, RestModule::class, MvpModule::class, ChartModule::class])
@Singleton
interface AppComponent {

    fun inject(mainActivity: MainActivity)
}