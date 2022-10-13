package com.nirwashh.android.mycryptoapp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.nirwashh.android.mycryptoapp.R
import java.math.BigDecimal

class CurrenciesAdapter : BaseAdapter<CurrenciesAdapter.CurrencyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CurrencyViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.recycler_view_item, parent, false)
        return CurrencyViewHolder(v)
    }

    class CurrencyViewHolder(view: View) : BaseAdapter.BaseViewHolder(view) {

        init {
            itemView.setOnClickListener {  }
        }
        private val ivCurrencyIcon: ImageView = view.findViewById(R.id.ivCurrencyIcon)
        private val tvCurrencySym: TextView = view.findViewById(R.id.tvCurrencySym)
        private val tvCurrencyName: TextView = view.findViewById(R.id.tvCurrencyName)
        private val tvCurrencyMarketCap: TextView = view.findViewById(R.id.tvCurrencyMarketCap)
        private val tvCurrencyPrice: TextView = view.findViewById(R.id.tvCurrencyPrice)

        override fun bind(item: Any) {
            let {
                item as Currency
                Glide.with(view.context).load(item.image).into(ivCurrencyIcon)
                tvCurrencySym.text = item.symbol
                tvCurrencyName.text = item.name
                tvCurrencyMarketCap.text = item.marketCap.toString()
                tvCurrencyPrice.text = item.currentPrice.toString()
            }
        }

    }

    data class Currency(
        val ath: Double,
        val athChangePercentage: Double,
        val circulatingSupply: Double,
        val currentPrice: Double,
        val id: String,
        val image: String,
        val marketCap: Long,
        val marketCapChangePercentage24h: Double,
        val marketCapRank: Int,
        val name: String,
        val priceChangePercentage24h: Double,
        val symbol: String,
        val totalSupply: Double,
        val totalVolume: Double
    )

}