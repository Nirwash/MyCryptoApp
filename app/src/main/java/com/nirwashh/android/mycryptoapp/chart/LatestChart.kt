package com.nirwashh.android.mycryptoapp.chart

import android.content.Context
import android.graphics.Color
import com.github.mikephil.charting.charts.LineChart
import com.github.mikephil.charting.components.XAxis
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.data.LineData
import com.github.mikephil.charting.data.LineDataSet
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet
import com.nirwashh.android.mycryptoapp.R
import com.nirwashh.android.mycryptoapp.YearValueFormatter
import com.nirwashh.android.mycryptoapp.di.App
import javax.inject.Inject

class LatestChart {

    @Inject
    lateinit var context: Context

    @Inject
    lateinit var formatter: YearValueFormatter


    lateinit var chart: LineChart

    init {
        App.appComponent.inject(this)
    }

    fun initChart(chart: LineChart) {
        this.chart = chart
        with(chart) {
            description.isEnabled = false
            setTouchEnabled(true)
            isDragEnabled = true
            setScaleEnabled(false)
            isScaleXEnabled = true
            setDrawGridBackground(false)
            isDoubleTapToZoomEnabled = false
            setPinchZoom(false)
            maxHighlightDistance = 300F
            val data = LineData()
            data.setValueTextColor(Color.BLACK)
            this.data = data
            legend.isEnabled = true
            setDrawMarkers(true)
            marker = MyMarkerView(context, R.layout.custom_marker_view)

        }
        val xl = chart.xAxis
        with(xl) {
            textColor = android.graphics.Color.BLACK
            position = com.github.mikephil.charting.components.XAxis.XAxisPosition.BOTTOM
            setDrawGridLines(false)
            valueFormatter = formatter
            labelCount = 3
            granularity = 48F
            setAvoidFirstLastClipping(true)
            isEnabled = true
        }
        val leftAxis = chart.axisLeft
        leftAxis.textColor = Color.BLACK
        leftAxis.setDrawGridLines(true)
        val rightAxis = chart.axisRight
        rightAxis.isEnabled = true
    }

    fun addEntry(value: Float, date: Float) {
        val data = chart.data

        if (data != null) {
            var set: ILineDataSet? = data.getDataSetByIndex(0)
            if (set == null) {
                set = createSet()
                data.addDataSet(set)
            }

            data.addEntry(Entry(date, value), 0)
            data.notifyDataChanged()
            chart.notifyDataSetChanged()
            chart.moveViewToX(date)
            chart.highlightValue(date, 0)
        }
    }

    private fun createSet(): LineDataSet {
        val set = LineDataSet(null, "Price, USD")
        with(set) {
            mode = LineDataSet.Mode.CUBIC_BEZIER
            cubicIntensity = 0.2f
            setDrawFilled(true)
            setDrawCircles(false)
            lineWidth = 1.8f
            circleRadius = 4f
            setCircleColor(Color.BLACK)
            highlightLineWidth = 1.2f
            highLightColor = context.resources.getColor(R.color.colorAccent)
            color = Color.BLACK
            fillColor = Color.BLACK
            enableDashedHighlightLine(10f, 5f, 0f)
            fillAlpha = 100
            setDrawHorizontalHighlightIndicator(true)
            setFillFormatter { _, _ ->
                chart.axisLeft.axisMaximum
            }
            return set
        }
    }


}