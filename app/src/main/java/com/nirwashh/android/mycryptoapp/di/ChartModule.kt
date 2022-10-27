package com.nirwashh.android.mycryptoapp.di

import com.nirwashh.android.mycryptoapp.YearValueFormatter
import com.nirwashh.android.mycryptoapp.chart.LatestChart
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class ChartModule {
    @Provides
    @Singleton
    fun provideLatestChart() = LatestChart()



    @Provides
    @Singleton
    fun provideYearFormatter() = YearValueFormatter()
}