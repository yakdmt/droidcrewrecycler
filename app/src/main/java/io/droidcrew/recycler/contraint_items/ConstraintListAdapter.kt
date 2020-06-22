package io.droidcrew.recycler.contraint_items

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import io.droidcrew.recycler.models.HeavyModel

class ConstraintListAdapter(private val items: List<HeavyModel>): RecyclerView.Adapter<ConstraintViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ConstraintViewHolder {
        return ConstraintViewHolderFactory.createHolder(parent, viewType)
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: ConstraintViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemViewType(position: Int): Int {
        return (position / 4) % 4
    }
}