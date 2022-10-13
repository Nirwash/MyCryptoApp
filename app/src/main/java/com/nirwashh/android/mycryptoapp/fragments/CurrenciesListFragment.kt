package com.nirwashh.android.mycryptoapp.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.nirwashh.android.mycryptoapp.activities.MainActivity.Companion.progress
import com.nirwashh.android.mycryptoapp.adapter.BaseAdapter
import com.nirwashh.android.mycryptoapp.adapter.CurrenciesAdapter
import com.nirwashh.android.mycryptoapp.databinding.FragmentCurrenciesListBinding
import com.nirwashh.android.mycryptoapp.di.App
import com.nirwashh.android.mycryptoapp.mvp.contract.CurrenciesContract
import com.nirwashh.android.mycryptoapp.mvp.presenter.CurrenciesPresenter
import javax.inject.Inject

class CurrenciesListFragment : BaseListFragment(), CurrenciesContract.View {
    private var _binding: FragmentCurrenciesListBinding? = null
    private val binding get() = _binding!!

    @Inject
    lateinit var presenter: CurrenciesPresenter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentCurrenciesListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        App.appComponent.inject(this)
        presenter.attach(this)
        presenter.makeList()
    }

    override fun createAdapterInstance(): BaseAdapter<*> {
        return CurrenciesAdapter()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun addCurrency(currency: CurrenciesAdapter.Currency) {
        viewAdapter.add(currency)
    }

    override fun notifyAdapter() {
        viewAdapter.notifyDataSetChanged()
    }

    override fun showProgress() {
        progress?.visibility = View.VISIBLE
    }

    override fun hideProgress() {
        progress?.visibility = View.INVISIBLE
    }

    override fun showErrorMessage(error: String?) {
        Toast.makeText(context, error, Toast.LENGTH_LONG).show()
    }

    override fun refresh() {
        viewAdapter.items.clear()
        viewAdapter.notifyDataSetChanged()
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