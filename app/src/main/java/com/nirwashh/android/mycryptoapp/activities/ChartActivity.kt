package com.nirwashh.android.mycryptoapp.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.bumptech.glide.Glide
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.highlight.Highlight
import com.github.mikephil.charting.listener.OnChartValueSelectedListener
import com.nirwashh.android.mycryptoapp.chart.LatestChart
import com.nirwashh.android.mycryptoapp.databinding.ActivityChartBinding
import com.nirwashh.android.mycryptoapp.di.App
import com.nirwashh.android.mycryptoapp.mvp.contract.LatestChartContract
import com.nirwashh.android.mycryptoapp.mvp.presenter.LatestChartPresenter
import java.text.DecimalFormat
import javax.inject.Inject

class ChartActivity : AppCompatActivity(), OnChartValueSelectedListener, LatestChartContract.View {
    private lateinit var binding: ActivityChartBinding
    @Inject
    lateinit var latestChart: LatestChart
    @Inject
    lateinit var presenter: LatestChartPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityChartBinding.inflate(layoutInflater)
        setContentView(binding.root)

        App.appComponent.inject(this)
        presenter.attach(this)

        val name = intent.getStringExtra("name")
        val marketCapRank = intent.getIntExtra("marketCapRank", 0)
        val symbol = intent.getStringExtra("symbol")
        val marketCap = intent.getStringExtra("marketCap")
        val marketCapChangePercentage24h = intent?.getDoubleExtra("marketCapChangePercentage24h", 0.0)
        val priceChangePercentage24h = intent?.getDoubleExtra("priceChangePercentage24h", 0.0)
        val totalVolume = intent?.getDoubleExtra("totalVolume", 0.0)
        val ath = intent?.getDoubleExtra("ath", 0.0)
        val athChangePercentage = intent?.getDoubleExtra("athChangePercentage", 0.0)
        val circulationSupply = intent?.getDoubleExtra("circulationSupply", 0.0)
        val totalSupply = intent?.getDoubleExtra("totalSupply", 0.0)
        val image = intent?.getStringExtra("image")

        Glide.with(this).load(image).into(binding.ivCurrencyDetailIcon)
        val df = DecimalFormat("#")
        df.maximumFractionDigits = 2

        with(binding) {
            tvDetailMarketCapRank.text = marketCap.toString()
            tvMarketCapChange.text = marketCapChangePercentage24h.toString()
            tvATH.text = ath.toString()
            tvAthChange.text = df.format(athChangePercentage)
            tvCirculatingSupply.text = df.format(circulationSupply)
            tvTotalSupply.text = totalSupply.toString()
        }

        intent.getStringExtra("id")?.let { presenter.makeChart(it) }
        latestChart.initChart(binding.chartCurrency)
    }

    override fun onValueSelected(e: Entry?, h: Highlight?) {
        TODO("Not yet implemented")
    }

    override fun onNothingSelected() {
        TODO("Not yet implemented")
    }

    override fun addEntryToChart(value: Float, date: String) {
        TODO("Not yet implemented")
    }

    override fun addEntryToChart(date: Float, value: Float) {
        latestChart.addEntry(value, date)
    }

    override fun showProgress() {
        binding.progressChart.visibility = View.VISIBLE
    }

    override fun hideProgress() {
        binding.progressChart.visibility = View.INVISIBLE
    }

    override fun showErrorMessage(error: String?) {
        Toast.makeText(this, error, Toast.LENGTH_SHORT).show()
    }

    override fun refresh() {
        TODO("Not yet implemented")
    }

    override fun onResume() {
        super.onResume()
        presenter.attach(this)
    }

    override fun onPause() {
        super.onPause()
        presenter.detach()
    }
}