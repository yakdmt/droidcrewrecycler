package io.droidcrew.recycler.snippet


interface StateRenderer<T : SnippetViewState> {
    fun render(state: T)
}