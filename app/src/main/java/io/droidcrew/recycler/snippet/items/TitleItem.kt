package io.droidcrew.recycler.snippet.items

import android.content.Context
import android.graphics.Typeface
import android.util.AttributeSet
import android.util.TypedValue
import androidx.appcompat.widget.AppCompatTextView
import io.droidcrew.recycler.snippet.SnippetViewHolder
import io.droidcrew.recycler.snippet.SnippetViewState
import io.droidcrew.recycler.snippet.StateRenderer


data class TitleViewState(val text: String) :
    SnippetViewState

class TitleView @JvmOverloads constructor(context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0) :
    AppCompatTextView(context, attrs, defStyleAttr),
    StateRenderer<TitleViewState> {

    init {
        setTypeface(null, Typeface.BOLD)
        setTextSize(TypedValue.COMPLEX_UNIT_SP,18f)
    }

    override fun render(state: TitleViewState) {
        text = state.text
    }
}

class TitleViewHolder(view: TitleView) : SnippetViewHolder(view) {

    companion object {
        fun create(context: Context) =
            TitleViewHolder(
                TitleView(context)
            )
    }

    private val textView = itemView as TitleView

    override fun render(state: SnippetViewState) {
        textView.render(state as TitleViewState)
    }
}