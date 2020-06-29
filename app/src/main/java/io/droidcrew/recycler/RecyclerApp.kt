package io.droidcrew.recycler

import android.app.Application
import timber.log.Timber

class RecyclerApp : Application() {

    override fun onCreate() {
        super.onCreate()

        Timber.plant(Timber.DebugTree())
    }
}