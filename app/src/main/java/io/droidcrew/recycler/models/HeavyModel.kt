package io.droidcrew.recycler.models

data class HeavyModel(val title: String, val description: String, val withButtons: Boolean, val widePicture: Boolean)

object HeavyModelFactory {

    fun create(howMany: Int) : List<HeavyModel> {
        val result = mutableListOf<HeavyModel>()
        for (i in 0..howMany) {
            result.add(
                HeavyModel(
                    "Item $i title",
                    "Description of $i item. Lorem ipsum dolor sit amet, consectetur adipiscing elit",
                    withButtons = i % 2 == 0,
                    widePicture = (i / 2) % 2 == 0
                )
            )
        }
        return result
    }
}