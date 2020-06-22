package io.droidcrew.recycler.snippet

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import io.droidcrew.recycler.R

class SnippetListAdapter(val items: List<SnippetRecyclerViewState>): RecyclerView.Adapter<SnippetRecyclerViewHolder>() {

//    var items: List<SnippetRecyclerViewState> = emptyList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SnippetRecyclerViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.snippet_list_item, parent, false) as SnippetRecyclerView
        return SnippetRecyclerViewHolder(view)
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: SnippetRecyclerViewHolder, position: Int) {
        holder.render(items[position])
    }
}