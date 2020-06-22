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


data class DescriptionViewState(val text: String) :
    SnippetViewState

class DescriptionView @JvmOverloads constructor(context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0) :
    AppCompatTextView(context, attrs, defStyleAttr),
    StateRenderer<DescriptionViewState> {

    init {
        setTypeface(null, Typeface.ITALIC)
        setTextSize(TypedValue.COMPLEX_UNIT_SP,14f)
    }

    override fun render(state: DescriptionViewState) {
        text = state.text
    }
}

class DescriptionViewHolder(view: DescriptionView) : SnippetViewHolder(view) {

    companion object {
        fun create(context: Context) =
            DescriptionViewHolder(
                DescriptionView(context)
            )
    }

    private val textView = itemView as TextView

    override fun render(state: SnippetViewState) {
        textView.text = (state as DescriptionViewState).text
    }
}