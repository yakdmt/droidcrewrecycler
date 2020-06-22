package io.droidcrew.recycler

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import io.droidcrew.recycler.contraint_items.ConstraintListAdapter
import io.droidcrew.recycler.models.HeavyModelFactory

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment() {

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_first, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<RecyclerView>(R.id.recycler_view).apply {
            adapter = ConstraintListAdapter(HeavyModelFactory.create(500))
            layoutManager = LinearLayoutManager(activity)
            adapter?.notifyDataSetChanged()
//            setRecycledViewPool((activity as MainActivity).viewPool)
        }



    }
}