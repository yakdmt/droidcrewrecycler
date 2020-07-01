package io.droidcrew.recycler.models

data class DataModel(val title: String, val description: String, val sublineText: String, val buttonText: String, val itemStyle: ItemStyle)

fun DataModel.isAlternative() = itemStyle == ItemStyle.STYLE_ALTERNATIVE || itemStyle == ItemStyle.STYLE_ALTERNATIVE_ONE_BUTTON
fun DataModel.isOneButton() = itemStyle == ItemStyle.STYLE_ONE_BUTTON || itemStyle == ItemStyle.STYLE_ALTERNATIVE_ONE_BUTTON

enum class ItemStyle {
    STYLE_NORMAL,
    STYLE_ALTERNATIVE,
    STYLE_ONE_BUTTON,
    STYLE_ALTERNATIVE_ONE_BUTTON,
    STYLE_NO_SUBLINE
}

object DataModelsFactory {

    fun create(howMany: Int) : List<DataModel> {
        val result = mutableListOf<DataModel>()
        for (i in 0..howMany) {
            result.add(
                DataModel(
                    "Title of $i item",
                    "Description of $i item. Lorem ipsum dolor sit amet, consectetur adipiscing elit",
                    "Subline $i",
                    "Button $i",
                    itemStyle = when (i / 10) {
                        0 -> ItemStyle.STYLE_NORMAL
                        1 -> ItemStyle.STYLE_ALTERNATIVE
                        2 -> ItemStyle.STYLE_ONE_BUTTON
                        3 -> ItemStyle.STYLE_ALTERNATIVE_ONE_BUTTON
                        else -> ItemStyle.STYLE_NORMAL
                    }
                )
            )
        }
        return result
    }
}