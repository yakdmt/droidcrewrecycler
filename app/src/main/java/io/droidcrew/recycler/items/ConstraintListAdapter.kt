package io.droidcrew.recycler.items

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import io.droidcrew.recycler.models.DataModel

class ConstraintListAdapter(private val items: List<DataModel>): RecyclerView.Adapter<BaseConstraintViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseConstraintViewHolder {
        return ConstraintViewHolderFactory.createHolder(parent, viewType)
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: BaseConstraintViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemViewType(position: Int): Int {
        return items[position].itemStyle.ordinal
    }
}