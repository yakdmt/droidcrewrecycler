package io.droidcrew.recycler.snippet

import android.content.Context
import android.util.AttributeSet
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

data class SnippetRecyclerViewState(val items: List<SnippetViewState>)

class SnippetRecyclerView @JvmOverloads constructor(context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0) :
    RecyclerView(context, attrs, defStyleAttr) {

    private val adapter = SnippetRecyclerAdapter()

    init {
        this.layoutManager = LinearLayoutManager(this.context) //TODO custom layout manager
        setAdapter(adapter)
    }

    fun render(state: SnippetRecyclerViewState) {
        adapter.items = state.items
        adapter.notifyDataSetChanged()
    }

}

class SnippetRecyclerViewHolder(view: SnippetRecyclerView) : RecyclerView.ViewHolder(view) {

    private val recycler = itemView as SnippetRecyclerView

    fun render(state: SnippetRecyclerViewState) {
        recycler.render(state)
    }
}