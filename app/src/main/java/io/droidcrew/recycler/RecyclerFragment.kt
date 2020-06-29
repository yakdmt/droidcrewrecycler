package io.droidcrew.recycler

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import io.droidcrew.recycler.models.ItemStyle
import io.droidcrew.recycler.snippet.SnippetListAdapter
import io.droidcrew.recycler.snippet.SnippetRecyclerViewState
import io.droidcrew.recycler.snippet.items.*

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class RecyclerFragment : Fragment() {

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_recycler, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<RecyclerView>(R.id.recycler_view).apply {
            setRecycledViewPool((activity as MainActivity).viewPool)
            adapter = SnippetListAdapter((activity as MainActivity).viewPool, (activity as MainActivity).data.map {
                val alternativeStyle = it.itemStyle == ItemStyle.STYLE_ALTERNATIVE || it.itemStyle == ItemStyle.STYLE_ALTERNATIVE_ONE_BUTTON
                val oneButton = it.itemStyle == ItemStyle.STYLE_ONE_BUTTON || it.itemStyle == ItemStyle.STYLE_ALTERNATIVE_ONE_BUTTON
                SnippetRecyclerViewState(
                    listOfNotNull(
                        TitleViewState(it.title),
                        DescriptionViewState(it.description),
                        ImageViewState(alternativeStyle),
                        ButtonViewState(it.buttonText),
                        if (!oneButton) ButtonViewState("Share") else null,
                        if (it.itemStyle != ItemStyle.STYLE_NO_SUBLINE) SublineViewState(it.sublineText) else null
                    ),
                alternative = it.itemStyle == ItemStyle.STYLE_ALTERNATIVE || it.itemStyle == ItemStyle.STYLE_ALTERNATIVE_ONE_BUTTON
            ) })
            layoutManager = LinearLayoutManager(activity)
            adapter?.notifyDataSetChanged()
        }
    }
}