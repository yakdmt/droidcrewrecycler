package io.droidcrew.recycler.snippet

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import io.droidcrew.recycler.R
import io.droidcrew.recycler.snippet.SnippetViewHolderFactory.TYPE_SNIPPET_RECYCLER

class SnippetListAdapter(val viewPool : RecyclerView.RecycledViewPool, val items: List<SnippetRecyclerViewState>): RecyclerView.Adapter<SnippetRecyclerViewHolder>() {

//    var items: List<SnippetRecyclerViewState> = emptyList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SnippetRecyclerViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.snippet_list_item, parent, false) as SnippetRecyclerView
        view.setRecycledViewPool(viewPool)
        return SnippetRecyclerViewHolder(view)
    }

    override fun getItemCount(): Int = items.size

    override fun getItemViewType(position: Int): Int {
        return TYPE_SNIPPET_RECYCLER
    }

    override fun onBindViewHolder(holder: SnippetRecyclerViewHolder, position: Int) {
        holder.render(items[position])
    }
}

