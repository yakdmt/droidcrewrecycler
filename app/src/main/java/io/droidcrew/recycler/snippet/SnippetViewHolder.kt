package io.droidcrew.recycler.snippet

import android.view.View
import androidx.recyclerview.widget.RecyclerView

abstract class SnippetViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    abstract fun render(state: SnippetViewState)

}