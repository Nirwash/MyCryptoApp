package com.nirwashh.android.mycryptoapp.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.highlight.Highlight
import com.github.mikephil.charting.listener.OnChartValueSelectedListener
import com.nirwashh.android.mycryptoapp.chart.LatestChart
import com.nirwashh.android.mycryptoapp.databinding.ActivityChartBinding
import com.nirwashh.android.mycryptoapp.di.App
import com.nirwashh.android.mycryptoapp.mvp.contract.LatestChartContract
import com.nirwashh.android.mycryptoapp.mvp.presenter.LatestChartPresenter
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
        val marketCapChangePercentage24h = intent?.getFloatExtra("marketCapChange", 0.0f)
        // TODO val priceChangePercentage24h =
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
        TODO("Not yet implemented")
    }

    override fun showProgress() {
        TODO("Not yet implemented")
    }

    override fun hideProgress() {
        TODO("Not yet implemented")
    }

    override fun showErrorMessage(error: String?) {
        TODO("Not yet implemented")
    }

    override fun refresh() {
        TODO("Not yet implemented")
    }
}