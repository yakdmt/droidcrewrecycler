package io.droidcrew.recycler.models

interface DataUpdater {
    fun onNewData(data: List<DataModel>)
}