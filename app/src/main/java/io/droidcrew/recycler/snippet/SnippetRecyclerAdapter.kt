package io.droidcrew.recycler.snippet

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class SnippetRecyclerAdapter: RecyclerView.Adapter<SnippetViewHolder>() {

    var items: List<SnippetViewState> = emptyList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SnippetViewHolder {
        return SnippetViewHolderFactory.createHolder(parent, viewType)
    }

    override fun getItemCount(): Int = items.size

    override fun getItemViewType(position: Int): Int {
        return super.getItemViewType(position)
    }

    override fun onBindViewHolder(holder: SnippetViewHolder, position: Int) {
        holder.render(items[position])
    }
}