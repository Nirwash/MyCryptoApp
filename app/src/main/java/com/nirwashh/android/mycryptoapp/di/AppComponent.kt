package com.nirwashh.android.mycryptoapp.di

import com.nirwashh.android.mycryptoapp.activities.MainActivity
import com.nirwashh.android.mycryptoapp.chart.LatestChart
import com.nirwashh.android.mycryptoapp.fragments.CurrenciesListFragment
import com.nirwashh.android.mycryptoapp.mvp.presenter.CurrenciesPresenter
import com.nirwashh.android.mycryptoapp.mvp.presenter.LatestChartPresenter
import dagger.Component
import javax.inject.Singleton

@Component(modules = [AppModule::class, RestModule::class, MvpModule::class, ChartModule::class])
@Singleton
interface AppComponent {

    fun inject(mainActivity: MainActivity)
    fun inject(presenter: CurrenciesPresenter)
    fun inject(presenter: LatestChartPresenter)
    fun inject(fragment: CurrenciesListFragment)
    fun inject(chart: LatestChart)
}