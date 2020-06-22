package io.droidcrew.recycler.snippet.items

import android.content.Context
import android.util.AttributeSet
import android.view.ViewGroup
import android.view.ViewGroup.LayoutParams.MATCH_PARENT
import androidx.appcompat.widget.AppCompatTextView
import io.droidcrew.recycler.snippet.SnippetViewHolder
import io.droidcrew.recycler.snippet.SnippetViewState
import io.droidcrew.recycler.snippet.StateRenderer

data class ImageViewState(val isWide: Boolean) :
    SnippetViewState

open class SomeImageView @JvmOverloads constructor(context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0) :
    AppCompatTextView(context, attrs, defStyleAttr),
    StateRenderer<ImageViewState> {

    override fun render(state: ImageViewState) {
        val layoutParams = layoutParams
        if (state.isWide) {
            layoutParams.height = 256
            layoutParams.width = MATCH_PARENT
        } else {
            layoutParams.height = 128
            layoutParams.width = 128
        }
    }
}

class ImageViewHolder(view: SomeImageView) : SnippetViewHolder(view) {

    companion object {
        fun create(context: Context) =
            ImageViewHolder(
                SomeImageView(context)
            )
    }

    private val image = itemView as SomeImageView

    override fun render(state: SnippetViewState) {
        image.render(state as ImageViewState)
    }
}