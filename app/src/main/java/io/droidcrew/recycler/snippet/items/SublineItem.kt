package io.droidcrew.recycler.snippet.items

import android.content.Context
import android.graphics.Typeface
import android.util.AttributeSet
import android.util.TypedValue
import android.widget.TextView
import androidx.appcompat.widget.AppCompatTextView
import io.droidcrew.recycler.snippet.SnippetViewHolder
import io.droidcrew.recycler.snippet.SnippetViewState
import io.droidcrew.recycler.snippet.StateRenderer


data class SublineViewState(val text: String) :
    SnippetViewState

class SublineView @JvmOverloads constructor(context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0) :
    AppCompatTextView(context, attrs, defStyleAttr),
    StateRenderer<SublineViewState> {

    init {
        setTypeface(Typeface.MONOSPACE, Typeface.NORMAL)
        setTextSize(TypedValue.COMPLEX_UNIT_SP,16f)
    }

    override fun render(state: SublineViewState) {
        text = state.text
    }
}

class SublineViewHolder(view: SublineView) : SnippetViewHolder(view) {

    companion object {
        fun create(context: Context) =
            SublineViewHolder(
                SublineView(context)
            )
    }

    private val textView = itemView as TextView

    override fun render(state: SnippetViewState) {
        textView.text = (state as SublineViewState).text
    }
}