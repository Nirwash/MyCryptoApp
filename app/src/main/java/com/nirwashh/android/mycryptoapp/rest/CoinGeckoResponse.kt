package com.nirwashh.android.mycryptoapp.rest

import java.math.BigDecimal

data class GeckoCoin(
    val ath: Double,
    val ath_change_percentage: Double,
    val circulating_supply: Double,
    val current_price: Double,
    val id: String,
    val image: String,
    val market_cap: Long,
    val market_cap_change_percentage_24h: Double,
    val market_cap_rank: Int,
    val name: String,
    val price_change_percentage_24h: Double,
    val symbol: String,
    val total_supply: Double,
    val total_volume: Double
)

data class GeckoCoinChart(
    var prices: List<List<Float>>
)