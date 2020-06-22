package io.droidcrew.recycler.snippet.items

import android.content.Context
import android.util.AttributeSet
import android.widget.TextView
import androidx.appcompat.widget.AppCompatTextView
import io.droidcrew.recycler.snippet.SnippetViewHolder
import io.droidcrew.recycler.snippet.SnippetViewState
import io.droidcrew.recycler.snippet.StateRenderer


data class DescriptionViewState(val text: String) :
    SnippetViewState

open class DescriptionView @JvmOverloads constructor(context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0) :
    AppCompatTextView(context, attrs, defStyleAttr),
    StateRenderer<DescriptionViewState> {

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