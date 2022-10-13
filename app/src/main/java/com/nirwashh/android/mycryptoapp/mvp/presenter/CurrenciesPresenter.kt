package com.nirwashh.android.mycryptoapp.mvp.presenter

import com.nirwashh.android.mycryptoapp.adapter.CurrenciesAdapter
import com.nirwashh.android.mycryptoapp.di.App
import com.nirwashh.android.mycryptoapp.formatThousands
import com.nirwashh.android.mycryptoapp.mvp.contract.CurrenciesContract
import com.nirwashh.android.mycryptoapp.rest.CoinGeckoApi
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class CurrenciesPresenter : CurrenciesContract.Presenter() {

    @Inject
    lateinit var geckoApi: CoinGeckoApi

    init {
        App.appComponent.inject(this)
    }

    override fun makeList() {
        view.showProgress()
        subscribe(geckoApi.getCoinMarket()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .flatMap { Observable.fromIterable(it) }
            .doOnNext {
                view.addCurrency(
                    CurrenciesAdapter.Currency(
                        it.ath,
                        it.ath_change_percentage,
                        it.circulating_supply,
                        it.current_price,
                        it.id,
                        it.image,
                        it.market_cap,
                        it.market_cap_change_percentage_24h,
                        it.market_cap_rank,
                        it.name,
                        it.price_change_percentage_24h,
                        it.symbol,
                        it.total_supply,
                        it.total_volume
                    )
                )
            }
            .doOnComplete {
                view.hideProgress()
            }
            .subscribe(
                {
                    view.hideProgress()
                    view.notifyAdapter()
                }, {
                    view.showErrorMessage(it.message)
                    view.hideProgress()
                    it.printStackTrace()
                }
            ))
    }

    override fun refreshList() {
        view.refresh()
        makeList()
    }
}