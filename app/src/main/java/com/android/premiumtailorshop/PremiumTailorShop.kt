package com.android.premiumtailorshop

import android.app.Application

class PremiumTailorShop: Application() {
    companion object {
        lateinit var instance: Application
    }
    init {
        instance = this
    }

    override fun onCreate() {
        super.onCreate()
    }

    override fun onTerminate() {
        super.onTerminate()
    }
}