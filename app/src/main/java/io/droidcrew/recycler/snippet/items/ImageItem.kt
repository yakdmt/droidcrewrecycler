package io.droidcrew.recycler.snippet.items

import android.content.Context
import android.util.AttributeSet
import android.view.ViewGroup
import android.view.ViewGroup.LayoutParams.MATCH_PARENT
import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.AppCompatTextView
import io.droidcrew.recycler.R
import io.droidcrew.recycler.snippet.SnippetViewHolder
import io.droidcrew.recycler.snippet.SnippetViewState
import io.droidcrew.recycler.snippet.StateRenderer
import io.droidcrew.recycler.utils.dp

data class ImageViewState(val isWide: Boolean) :
    SnippetViewState

class SomeImageView @JvmOverloads constructor(context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0) :
    AppCompatImageView(context, attrs, defStyleAttr),
    StateRenderer<ImageViewState> {

    init {
        layoutParams = ViewGroup.LayoutParams(72.dp, 72.dp)
    }

    override fun render(state: ImageViewState) {
        if (state.isWide) {
            setImageResource(R.drawable.bookmark_16)
        } else {
            setImageResource(R.drawable.navi_24)
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