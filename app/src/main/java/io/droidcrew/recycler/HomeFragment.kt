package io.droidcrew.recycler

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import android.widget.Switch
import android.widget.TextView
import io.droidcrew.recycler.api.PrefetchRecycledViewPool
import io.droidcrew.recycler.api.PrefetchedViewsCountListener
import io.droidcrew.recycler.items.ConstraintViewHolderFactory
import io.droidcrew.recycler.items.ConstraintViewHolderFactory.CONSTRAINT_TYPE_STYLE_ALTERNATIVE
import io.droidcrew.recycler.items.ConstraintViewHolderFactory.CONSTRAINT_TYPE_STYLE_ALTERNATIVE_ONE_BUTTON
import io.droidcrew.recycler.items.ConstraintViewHolderFactory.CONSTRAINT_TYPE_STYLE_NORMAL
import io.droidcrew.recycler.items.ConstraintViewHolderFactory.CONSTRAINT_TYPE_STYLE_NO_SUBLINE
import io.droidcrew.recycler.items.ConstraintViewHolderFactory.CONSTRAINT_TYPE_STYLE_ONE_BUTTON
import io.droidcrew.recycler.items.LinearViewHolderFactory
import io.droidcrew.recycler.items.LinearViewHolderFactory.LINEAR_TYPE_STYLE_ALTERNATIVE
import io.droidcrew.recycler.items.LinearViewHolderFactory.LINEAR_TYPE_STYLE_ALTERNATIVE_ONE_BUTTON
import io.droidcrew.recycler.items.LinearViewHolderFactory.LINEAR_TYPE_STYLE_NORMAL
import io.droidcrew.recycler.items.LinearViewHolderFactory.LINEAR_TYPE_STYLE_NO_SUBLINE
import io.droidcrew.recycler.items.LinearViewHolderFactory.LINEAR_TYPE_STYLE_ONE_BUTTON
import io.droidcrew.recycler.snippet.SnippetViewHolderFactory
import io.droidcrew.recycler.snippet.SnippetViewHolderFactory.TYPE_BUTTON
import io.droidcrew.recycler.snippet.SnippetViewHolderFactory.TYPE_DESCRIPTION
import io.droidcrew.recycler.snippet.SnippetViewHolderFactory.TYPE_IMAGE
import io.droidcrew.recycler.snippet.SnippetViewHolderFactory.TYPE_SNIPPET_RECYCLER
import io.droidcrew.recycler.snippet.SnippetViewHolderFactory.TYPE_SUBLINE
import io.droidcrew.recycler.snippet.SnippetViewHolderFactory.TYPE_TITLE

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class HomeFragment : Fragment() {

    private lateinit var viewCounter: TextView
    private lateinit var progress: ProgressBar
    private lateinit var usePrefetcherSwitch: Switch
    private lateinit var useGapworkerSwitch: Switch

    private lateinit var viewPool: PrefetchRecycledViewPool

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewPool = (activity as MainActivity).viewPool

        viewCounter = view.findViewById(R.id.view_counter)
        progress = view.findViewById(R.id.progress)
        usePrefetcherSwitch = view.findViewById(R.id.use_prefetcher_switch)
        usePrefetcherSwitch.setOnCheckedChangeListener { _, value ->
            if (value) {

                viewPool.setMaxRecycledViews(CONSTRAINT_TYPE_STYLE_NORMAL, 10)
                viewPool.setPrefetchedViewsCount(CONSTRAINT_TYPE_STYLE_NORMAL, 10) { fakeParent, viewType ->
                    ConstraintViewHolderFactory.createHolder(fakeParent, viewType)
                }
                viewPool.setMaxRecycledViews(CONSTRAINT_TYPE_STYLE_ALTERNATIVE, 10)
                viewPool.setPrefetchedViewsCount(CONSTRAINT_TYPE_STYLE_ALTERNATIVE, 10) { fakeParent, viewType ->
                    ConstraintViewHolderFactory.createHolder(fakeParent, viewType)
                }
                viewPool.setMaxRecycledViews(CONSTRAINT_TYPE_STYLE_ONE_BUTTON, 10)
                viewPool.setPrefetchedViewsCount(CONSTRAINT_TYPE_STYLE_ONE_BUTTON, 10) { fakeParent, viewType ->
                    ConstraintViewHolderFactory.createHolder(fakeParent, viewType)
                }
                viewPool.setMaxRecycledViews(CONSTRAINT_TYPE_STYLE_ALTERNATIVE_ONE_BUTTON, 10)
                viewPool.setPrefetchedViewsCount(CONSTRAINT_TYPE_STYLE_ALTERNATIVE_ONE_BUTTON, 10) { fakeParent, viewType ->
                    ConstraintViewHolderFactory.createHolder(fakeParent, viewType)
                }
                viewPool.setMaxRecycledViews(CONSTRAINT_TYPE_STYLE_NO_SUBLINE, 10)
                viewPool.setPrefetchedViewsCount(CONSTRAINT_TYPE_STYLE_NO_SUBLINE, 10) { fakeParent, viewType ->
                    ConstraintViewHolderFactory.createHolder(fakeParent, viewType)
                }

                viewPool.setMaxRecycledViews(LINEAR_TYPE_STYLE_NORMAL, 10)
                viewPool.setPrefetchedViewsCount(LINEAR_TYPE_STYLE_NORMAL, 10) { fakeParent, viewType ->
                    LinearViewHolderFactory.createHolder(fakeParent, viewType)
                }
                viewPool.setMaxRecycledViews(LINEAR_TYPE_STYLE_ALTERNATIVE, 10)
                viewPool.setPrefetchedViewsCount(LINEAR_TYPE_STYLE_ALTERNATIVE, 10) { fakeParent, viewType ->
                    LinearViewHolderFactory.createHolder(fakeParent, viewType)
                }
                viewPool.setMaxRecycledViews(LINEAR_TYPE_STYLE_ONE_BUTTON, 10)
                viewPool.setPrefetchedViewsCount(LINEAR_TYPE_STYLE_ONE_BUTTON, 10) { fakeParent, viewType ->
                    LinearViewHolderFactory.createHolder(fakeParent, viewType)
                }
                viewPool.setMaxRecycledViews(LINEAR_TYPE_STYLE_ALTERNATIVE_ONE_BUTTON, 10)
                viewPool.setPrefetchedViewsCount(LINEAR_TYPE_STYLE_ALTERNATIVE_ONE_BUTTON, 10) { fakeParent, viewType ->
                    LinearViewHolderFactory.createHolder(fakeParent, viewType)
                }
                viewPool.setMaxRecycledViews(LINEAR_TYPE_STYLE_NO_SUBLINE, 10)
                viewPool.setPrefetchedViewsCount(LINEAR_TYPE_STYLE_NO_SUBLINE, 10) { fakeParent, viewType ->
                    LinearViewHolderFactory.createHolder(fakeParent, viewType)
                }

                viewPool.setMaxRecycledViews(TYPE_SNIPPET_RECYCLER, 10)
                viewPool.setPrefetchedViewsCount(TYPE_SNIPPET_RECYCLER, 10) { fakeParent, viewType ->
                    SnippetViewHolderFactory.createRecyclerHolder(fakeParent, viewType)
                }
                viewPool.setMaxRecycledViews(TYPE_TITLE, 10)
                viewPool.setPrefetchedViewsCount(TYPE_TITLE, 10) { fakeParent, viewType ->
                    SnippetViewHolderFactory.createHolder(fakeParent, viewType)
                }
                viewPool.setMaxRecycledViews(TYPE_DESCRIPTION, 10)
                viewPool.setPrefetchedViewsCount(TYPE_DESCRIPTION, 10) { fakeParent, viewType ->
                    SnippetViewHolderFactory.createHolder(fakeParent, viewType)
                }
                viewPool.setMaxRecycledViews(TYPE_IMAGE, 10)
                viewPool.setPrefetchedViewsCount(TYPE_IMAGE, 10) { fakeParent, viewType ->
                    SnippetViewHolderFactory.createHolder(fakeParent, viewType)
                }
                viewPool.setMaxRecycledViews(TYPE_BUTTON, 10)
                viewPool.setPrefetchedViewsCount(TYPE_BUTTON, 10) { fakeParent, viewType ->
                    SnippetViewHolderFactory.createHolder(fakeParent, viewType)
                }
                viewPool.setMaxRecycledViews(TYPE_SUBLINE, 10)
                viewPool.setPrefetchedViewsCount(TYPE_SUBLINE, 10) { fakeParent, viewType ->
                    SnippetViewHolderFactory.createHolder(fakeParent, viewType)
                }
            }
        }
        useGapworkerSwitch = view.findViewById(R.id.use_gapworker_switch)

        viewPool.listener = object : PrefetchedViewsCountListener {
            override fun onViewCountChanged(count: Int) {
                viewCounter.text = "Views prefetched: $count"
                progress.progress = count
            }
        }

    }
}