package io.droidcrew.recycler.snippet.layout

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

internal class SnippetLayoutManager : RecyclerView.LayoutManager() {

    private val layouter = SnippetLayouter(this)

    var snippetLayoutType: SnippetLayoutType = SnippetLayoutType.NORMAL

    override fun generateDefaultLayoutParams() = RecyclerView.LayoutParams(
        ViewGroup.LayoutParams.WRAP_CONTENT,
        ViewGroup.LayoutParams.WRAP_CONTENT
    )

    override fun onLayoutChildren(recycler: RecyclerView.Recycler, state: RecyclerView.State) {
        detachAndScrapAttachedViews(recycler)
        if (state.itemCount == 0) return

        layouter.layout(recycler, state, snippetLayoutType)
    }

    override fun canScrollVertically(): Boolean = false

    override fun isAutoMeasureEnabled(): Boolean = true

    override fun collectInitialPrefetchPositions(adapterItemCount: Int, layoutPrefetchRegistry: LayoutPrefetchRegistry) {
        for (i in 0 until adapterItemCount) {
            layoutPrefetchRegistry.addPosition(i, 0)
        }
    }

}