package com.nirwashh.android.mycryptoapp.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.nirwashh.android.mycryptoapp.R
import com.nirwashh.android.mycryptoapp.activities.ChartActivity
import java.math.BigDecimal

class CurrenciesAdapter : BaseAdapter<CurrenciesAdapter.CurrencyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CurrencyViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.recycler_view_item, parent, false)
        return CurrencyViewHolder(v)
    }

    class CurrencyViewHolder(view: View) : BaseAdapter.BaseViewHolder(view) {

        var id: String = ""
        var symbol: String = ""
        var name: String = ""
        var image: String = ""
        var marketCap: String = ""
        var marketCapRank: Int = 0
        var marketCapChangePercentage24h: Double = 0.0
        var priceChangePercentage24h: Double = 0.0
        var totalVolume: Double = 0.0
        var ath: Double = 0.0
        var athChangePercentage: Double = 0.0
        var circulatingSupply: Double = 0.0
        var totalSupply: Double = 0.0


        init {
            itemView.setOnClickListener {
                var intent = Intent(itemView.context, ChartActivity::class.java)
                intent.putExtra("id", id)
                    .putExtra("name",name)
                    .putExtra("symbol",symbol)
                    .putExtra("image",image)
                    .putExtra("marketCapRank",marketCapRank)
                    .putExtra("marketCap",marketCap)
                    .putExtra("marketCapChangePercentage24h",marketCapChangePercentage24h)
                    .putExtra("priceChangePercentage24h",priceChangePercentage24h)
                    .putExtra("totalVolume",totalVolume)
                    .putExtra("ath",ath)
                    .putExtra("athChangePercentage",athChangePercentage)
                    .putExtra("circulatingSupply",circulatingSupply)
                    .putExtra("totalSupply",totalSupply)
                itemView.context.startActivity(intent)
            }
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
                id = item.id
                symbol = item.symbol
                name = item.name
                image = item.image
                marketCapRank = item.marketCapRank
                marketCapChangePercentage24h = item.marketCapChangePercentage24h
                priceChangePercentage24h = item.priceChangePercentage24h
                totalVolume = item.totalVolume
                ath = item.ath
                athChangePercentage = item.athChangePercentage
                circulatingSupply = item.circulatingSupply
                totalSupply = item.totalSupply
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