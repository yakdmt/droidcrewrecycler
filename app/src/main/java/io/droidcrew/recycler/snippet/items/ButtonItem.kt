package io.droidcrew.recycler.snippet.items

import android.content.Context
import android.util.AttributeSet
import android.view.ContextThemeWrapper
import android.widget.Toast
import androidx.appcompat.widget.AppCompatButton
import io.droidcrew.recycler.R
import io.droidcrew.recycler.snippet.SnippetViewHolder
import io.droidcrew.recycler.snippet.SnippetViewState
import io.droidcrew.recycler.snippet.StateRenderer

data class ButtonViewState(val text: String) :
    SnippetViewState

class ButtonView @JvmOverloads constructor(context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = R.attr.buttonViewStyle) :
    AppCompatButton(ContextThemeWrapper(context, R.style.SnippetTheme), attrs, defStyleAttr),
    StateRenderer<ButtonViewState> {

    override fun render(state: ButtonViewState) {
        text = state.text
        setOnClickListener {
            Toast.makeText(context, "OnClick: $text", Toast.LENGTH_LONG).show()
        }
    }
}

class ButtonViewHolder(view: ButtonView) : SnippetViewHolder(view) {

    companion object {
        fun create(context: Context) =
            ButtonViewHolder(
                ButtonView(context)
            )
    }

    private val button = itemView as ButtonView

    override fun render(state: SnippetViewState) {
        button.render(state as ButtonViewState)
    }
}