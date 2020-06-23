package io.droidcrew.recycler.snippet

import android.content.Context
import android.util.AttributeSet
import androidx.recyclerview.widget.RecyclerView
import io.droidcrew.recycler.snippet.layout.SnippetLayoutManager
import io.droidcrew.recycler.snippet.layout.SnippetLayoutType

data class SnippetRecyclerViewState(val items: List<SnippetViewState>, val alternative: Boolean)

class SnippetRecyclerView @JvmOverloads constructor(context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0) :
    RecyclerView(context, attrs, defStyleAttr) {

    private val adapter = SnippetRecyclerAdapter()

    init {
        this.layoutManager = SnippetLayoutManager()
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
        (recycler.layoutManager as SnippetLayoutManager).snippetLayoutType = if (state.alternative) {
            SnippetLayoutType.ALTERNATIVE
        } else {
            SnippetLayoutType.NORMAL
        }
    }
}