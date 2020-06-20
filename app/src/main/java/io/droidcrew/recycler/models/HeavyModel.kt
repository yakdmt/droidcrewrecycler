package io.droidcrew.recycler.models

data class HeavyModel(val text: String)

object HeavyModelFactory {

    fun create(howMany: Int) : List<HeavyModel> {
        val result = mutableListOf<HeavyModel>()
        for (i in 0..howMany) {
            result.add(HeavyModel(i.toString()))
        }
        return result
    }
}