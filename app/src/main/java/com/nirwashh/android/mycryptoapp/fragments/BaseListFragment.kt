package com.nirwashh.android.mycryptoapp.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.nirwashh.android.mycryptoapp.R
import com.nirwashh.android.mycryptoapp.adapter.BaseAdapter

abstract class BaseListFragment : Fragment() {
    private lateinit var recyclerView: RecyclerView
    protected lateinit var viewAdapter: BaseAdapter<*>
    private lateinit var viewManager: RecyclerView.LayoutManager

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewManager = LinearLayoutManager(context)
        viewAdapter = createAdapterInstance()

        recyclerView = view.findViewById<RecyclerView?>(R.id.list).apply {
            setHasFixedSize(true)
            layoutManager = viewManager
            adapter = viewAdapter
        }
    }

    abstract fun createAdapterInstance(): BaseAdapter<*>
}