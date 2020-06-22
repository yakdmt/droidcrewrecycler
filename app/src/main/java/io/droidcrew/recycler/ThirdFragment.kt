package io.droidcrew.recycler

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import io.droidcrew.recycler.models.HeavyModelFactory
import io.droidcrew.recycler.snippet.SnippetListAdapter
import io.droidcrew.recycler.snippet.SnippetRecyclerViewState
import io.droidcrew.recycler.snippet.items.*

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class ThirdFragment : Fragment() {

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_third, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<RecyclerView>(R.id.recycler_view).apply {
            adapter = SnippetListAdapter(HeavyModelFactory.create(500).map { SnippetRecyclerViewState(
                listOfNotNull(
                    TitleViewState(it.title),
                    DescriptionViewState(it.title),
                    ImageViewState(it.widePicture),
                    if (it.withButtons) ButtonViewState(it.title) else null,
                    SublineViewState("Subline")
                )
            ) })
            layoutManager = LinearLayoutManager(activity)
            adapter?.notifyDataSetChanged()
//            setRecycledViewPool((activity as MainActivity).viewPool)
        }
    }
}