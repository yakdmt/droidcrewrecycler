package io.droidcrew.recycler.snippet.layout

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import io.droidcrew.recycler.snippet.items.*

internal class SnippetViews {

    val middleViews = mutableListOf<View>()
    var topRightView: View? = null
    var titleView: View? = null
    var scheduleView: View? = null
    val descriptionViews = mutableListOf<View>()
    var belowDescriptionView: View? = null
    var leftBasementView: View? = null
    var rightBasementView: View? = null

    fun fill(recycler: RecyclerView.Recycler, state: RecyclerView.State, snippetLayoutType: SnippetLayoutType) {
        clear()

        val ratingView: View? = null
        var buttonView: View? = null

        var firstSublineView: View? = null

        for (i in 0 until state.itemCount) {
            when (val view = recycler.getViewForPosition(i)) {
                is SomeImageView -> if (topRightView == null) topRightView = view else IllegalStateException("More than one topRightView in layout! $topRightView and $view existed")
                is TitleView -> if (titleView == null) titleView = view else IllegalStateException("More than one header in layout!")
                is DescriptionView -> if (descriptionViews.size < 2) descriptionViews.add(view) else IllegalStateException("More than two descriptions in layout!")
                is ButtonView -> if (buttonView == null) buttonView = view else IllegalStateException("More than one estimate time in layout!")
                is SublineView -> {
                    if (firstSublineView == null) firstSublineView = view
                    middleViews += view
                }
                else -> middleViews += view
            }
        }

        leftBasementView = when (snippetLayoutType) {
            SnippetLayoutType.NORMAL -> buttonView
            SnippetLayoutType.ALTERNATIVE -> {
                topRightView.also { topRightView = null }
            }
        }

        rightBasementView = when (snippetLayoutType) {
            SnippetLayoutType.NORMAL -> firstSublineView?.also { middleViews -= it }
            SnippetLayoutType.ALTERNATIVE -> buttonView
        }

        belowDescriptionView = ratingView ?: firstSublineView.takeIf { it !== leftBasementView }?.also { middleViews -= it }
    }

    private fun clear() {
        middleViews.clear()
        topRightView = null
        titleView = null
        descriptionViews.clear()
        belowDescriptionView = null
        leftBasementView = null
        rightBasementView = null
        scheduleView = null
    }
}