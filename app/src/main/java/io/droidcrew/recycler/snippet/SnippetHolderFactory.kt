package io.droidcrew.recycler.snippet

import android.view.ViewGroup
import io.droidcrew.recycler.snippet.items.TitleViewHolder
import java.lang.IllegalArgumentException

object SnippetViewHolderFactory {

    const val TYPE_TEXT = 0
    const val TYPE_DESCRIPTION = 1
    const val TYPE_IMAGE = 2
    const val TYPE_BUTTON = 3

    fun createHolder(parent: ViewGroup, viewType: Int) : SnippetViewHolder {
        //Simulation of long view creation
//        Thread.sleep(20)
        return when (viewType) {
            TYPE_TEXT -> TitleViewHolder.create(parent.context)
            else -> throw IllegalArgumentException("Unknown viewType")
        }
    }
}