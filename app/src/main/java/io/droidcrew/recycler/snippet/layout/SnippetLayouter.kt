package io.droidcrew.recycler.snippet.layout

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import io.droidcrew.recycler.utils.dp
import kotlin.math.max

internal class SnippetLayouter(private val lm: RecyclerView.LayoutManager) {
    private val views = SnippetViews()

    private val dp16 = 16.dp
    private val dp4 = 4.dp

    private var leftItemBottom = 0
    private var rightItemBottom = 0
    private var rightItemLeft = 0
    private var widthUsed = 0


    fun layout(recycler: RecyclerView.Recycler, state: RecyclerView.State, snippetLayoutType: SnippetLayoutType) {
        views.fill(recycler, state, snippetLayoutType)

        leftItemBottom = lm.paddingTop
        rightItemBottom = lm.paddingTop
        rightItemLeft = lm.width - lm.paddingRight
        widthUsed = 0

        views.topRightView?.layoutRight(0)

        views.titleView?.layoutLeft(0)
        if (views.scheduleView != null) {
            views.descriptionViews.firstOrNull()?.layoutLeft(dp4)
            views.scheduleView?.layoutLeft(8.dp)
            if (views.descriptionViews.size > 1) {
                views.descriptionViews[1].layoutLeft(dp16)
            }
        } else {
            views.descriptionViews.forEach { it.layoutLeft(dp4) }
        }
        views.belowDescriptionView?.layoutLeft(8.dp)

        moveNextLeftItemBelowRight()

        val allViews = views.middleViews
        allViews.forEachIndexed { index, view ->
            when {
                index == 0 || lm.getItemViewType(allViews[index - 1]) != lm.getItemViewType(view) -> view.layoutLeft(dp16)
                else -> view.layoutLeft(dp4)
            }
        }

        val paddingTop = dp16
        views.rightBasementView?.layoutRight(paddingTop)
        views.leftBasementView?.layoutLeft(paddingTop)
    }

    private fun View.addAndMeasure(widthUsed: Int) {
        lm.addView(this)
        lm.measureChildWithMargins(this, widthUsed, 0)
    }

    private fun View.layoutLeft(paddingTop: Int, excludePadding: Boolean = this is RecyclerView) {
        val belowRight = leftItemBottom + paddingTop >= rightItemBottom

        addAndMeasure(
            when {
                excludePadding -> -(lm.paddingLeft + lm.paddingRight)
                !belowRight -> widthUsed - lm.paddingRight
                else -> 0
            }
        )

        val left = if (!excludePadding) lm.paddingLeft else 0
        val right = left + lm.getDecoratedMeasuredWidth(this)

        if (!belowRight && right > rightItemLeft) moveNextLeftItemBelowRight()

        val top = leftItemBottom + paddingTop
        val bottom = top + lm.getDecoratedMeasuredHeight(this)

        lm.layoutDecoratedWithMargins(this, left, top, right, bottom)

        leftItemBottom = bottom
    }

    private fun View.layoutRight(paddingTop: Int) {
        addAndMeasure(0)

        val width = lm.getDecoratedMeasuredWidth(this)

        val right = lm.width - lm.paddingRight
        val left = right - width
        val top = leftItemBottom + paddingTop
        val bottom = top + lm.getDecoratedMeasuredHeight(this)

        lm.layoutDecoratedWithMargins(this, left, top, right, bottom)

        rightItemBottom = bottom

        rightItemLeft = left
        widthUsed = lm.width - left
        if (widthUsed != 0) {
            widthUsed += dp16
            rightItemLeft += dp16
        }
    }

    private fun moveNextLeftItemBelowRight() {
        leftItemBottom = max(leftItemBottom, rightItemBottom)
    }
}