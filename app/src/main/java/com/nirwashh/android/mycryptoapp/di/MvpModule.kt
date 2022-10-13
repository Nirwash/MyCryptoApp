package com.nirwashh.android.mycryptoapp.di

import com.nirwashh.android.mycryptoapp.mvp.presenter.CurrenciesPresenter
import com.nirwashh.android.mycryptoapp.mvp.presenter.LatestChartPresenter
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class MvpModule {

    @Provides
    @Singleton
    fun provideCurrenciesPresenter(): CurrenciesPresenter = CurrenciesPresenter()

    @Provides
    @Singleton
    fun provideLatestChartPresenter(): LatestChartPresenter = LatestChartPresenter()

}