package io.droidcrew.recycler.snippet.items

import android.content.Context
import android.graphics.Typeface
import android.util.AttributeSet
import android.util.TypedValue
import androidx.appcompat.widget.AppCompatTextView
import androidx.core.text.PrecomputedTextCompat
import androidx.core.widget.TextViewCompat
import io.droidcrew.recycler.R
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
        val text = context.resources.getString(R.string.description_text_template, state.text)
        setTextFuture(
            PrecomputedTextCompat.getTextFuture(text,
            TextViewCompat.getTextMetricsParams(this),
            /*optional custom executor*/ null))
    }
}

class DescriptionViewHolder(view: DescriptionView) : SnippetViewHolder(view) {

    companion object {
        fun create(context: Context) =
            DescriptionViewHolder(
                DescriptionView(context)
            )
    }

    private val textView = itemView as DescriptionView

    override fun render(state: SnippetViewState) {
        textView.render(state as DescriptionViewState)
    }
}