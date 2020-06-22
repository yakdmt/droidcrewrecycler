package io.droidcrew.recycler.snippet

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import io.droidcrew.recycler.snippet.SnippetViewHolderFactory.TYPE_BUTTON
import io.droidcrew.recycler.snippet.SnippetViewHolderFactory.TYPE_DESCRIPTION
import io.droidcrew.recycler.snippet.SnippetViewHolderFactory.TYPE_IMAGE
import io.droidcrew.recycler.snippet.SnippetViewHolderFactory.TYPE_SUBLINE
import io.droidcrew.recycler.snippet.SnippetViewHolderFactory.TYPE_TITLE
import io.droidcrew.recycler.snippet.items.*
import java.lang.IllegalArgumentException

class SnippetRecyclerAdapter: RecyclerView.Adapter<SnippetViewHolder>() {

    var items: List<SnippetViewState> = emptyList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SnippetViewHolder {
        return SnippetViewHolderFactory.createHolder(parent, viewType)
    }

    override fun getItemCount(): Int = items.size

    override fun getItemViewType(position: Int): Int {
        return when (items[position]) {
            is TitleViewState -> TYPE_TITLE
            is DescriptionViewState -> TYPE_DESCRIPTION
            is ImageViewState -> TYPE_IMAGE
            is ButtonViewState -> TYPE_BUTTON
            is SublineViewState -> TYPE_SUBLINE
            else -> throw IllegalArgumentException("Unknown viewType")
        }
    }

    override fun onBindViewHolder(holder: SnippetViewHolder, position: Int) {
        holder.render(items[position])
    }
}