package io.droidcrew.recycler

import android.app.Activity
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ProgressBar
import android.widget.Switch
import android.widget.TextView
import androidx.navigation.fragment.findNavController
import io.droidcrew.recycler.api.PrefetchRecycledViewPool
import io.droidcrew.recycler.api.PrefetchedViewsCountListener
import io.droidcrew.recycler.contraint_items.ConstraintViewHolderFactory
import io.droidcrew.recycler.list.HeavyViewHolderFactory.TYPE_SMALL_IMAGE
import io.droidcrew.recycler.list.HeavyViewHolderFactory.TYPE_SMALL_IMAGE_WITH_BUTTONS
import io.droidcrew.recycler.list.HeavyViewHolderFactory.TYPE_WIDE_IMAGE
import io.droidcrew.recycler.list.HeavyViewHolderFactory.TYPE_WIDE_IMAGE_WITH_BUTTONS

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
                viewPool.setPrefetchedViewsCount(TYPE_SMALL_IMAGE_WITH_BUTTONS, 10) { fakeParent, viewType ->
                    ConstraintViewHolderFactory.createHolder(fakeParent, viewType)
                }
                viewPool.setPrefetchedViewsCount(TYPE_SMALL_IMAGE, 10) { fakeParent, viewType ->
                    ConstraintViewHolderFactory.createHolder(fakeParent, viewType)
                }
                viewPool.setPrefetchedViewsCount(TYPE_WIDE_IMAGE_WITH_BUTTONS, 10) { fakeParent, viewType ->
                    ConstraintViewHolderFactory.createHolder(fakeParent, viewType)
                }
                viewPool.setPrefetchedViewsCount(TYPE_WIDE_IMAGE, 10) { fakeParent, viewType ->
                    ConstraintViewHolderFactory.createHolder(fakeParent, viewType)
                }
            } else {
                viewPool.clear()
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