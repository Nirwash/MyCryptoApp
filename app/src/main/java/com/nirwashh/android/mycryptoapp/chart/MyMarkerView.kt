package com.nirwashh.android.mycryptoapp.chart

import android.annotation.SuppressLint
import android.content.Context
import android.widget.TextView
import com.github.mikephil.charting.components.MarkerView
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.highlight.Highlight
import com.github.mikephil.charting.utils.MPPointF
import com.nirwashh.android.mycryptoapp.R
import com.nirwashh.android.mycryptoapp.dateToString

@SuppressLint("ViewConstructor")
class MyMarkerView(context: Context, layoutResource: Int) : MarkerView(context, layoutResource) {

    private val tvContent: TextView = findViewById(R.id.tvContent)


    override fun refreshContent(e: Entry?, highlight: Highlight?) {
        val text = "${e?.y?.toString()}\n ${e?.x?.dateToString("MMM dd, yyyy")}"
        tvContent.text = text
        super.refreshContent(e, highlight)
    }

    override fun getOffset(): MPPointF {
        return MPPointF((-(width/2)).toFloat(), (-height).toFloat())
    }
}