package io.droidcrew.recycler.snippet

import android.view.ViewGroup
import io.droidcrew.recycler.snippet.items.*
import java.lang.IllegalArgumentException

object SnippetViewHolderFactory {

    const val TYPE_TITLE = 100
    const val TYPE_DESCRIPTION = 101
    const val TYPE_IMAGE = 102
    const val TYPE_BUTTON = 103
    const val TYPE_SUBLINE = 104

    fun createHolder(parent: ViewGroup, viewType: Int) : SnippetViewHolder {
        //Simulation of long view creation
//        Thread.sleep(20)
        return when (viewType) {
            TYPE_TITLE -> TitleViewHolder.create(parent.context)
            TYPE_DESCRIPTION -> DescriptionViewHolder.create(parent.context)
            TYPE_IMAGE -> ImageViewHolder.create(parent.context)
            TYPE_BUTTON -> ButtonViewHolder.create(parent.context)
            TYPE_SUBLINE -> SublineViewHolder.create(parent.context)
            else -> throw IllegalArgumentException("Unknown viewType")
        }
    }
}