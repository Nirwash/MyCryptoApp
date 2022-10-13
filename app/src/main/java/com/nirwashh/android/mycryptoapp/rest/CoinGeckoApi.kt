package com.nirwashh.android.mycryptoapp.rest

import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Part
import retrofit2.http.Query

interface CoinGeckoApi {

    @GET("coins/markets")
    fun getCoinMarket(
        @Query("vs_currency") vs: String = "usd",
        @Query("order") order: String = "market_cap_desc",
        @Query("per_page") perPage: String = "100",
        @Query("page") page: String = "1",
        @Query("sparkline") sparkLine: String = "false"
    ): Observable<List<GeckoCoin>>

    @GET("coins/{id}/market_chart")
    fun getCoinMarketChart(
        @Part("id") id: String,
        @Query("vs_currency") vsCurrency: String = "usd",
        @Query("days") days: String = "max"
    ): Observable<GeckoCoinChart>
}