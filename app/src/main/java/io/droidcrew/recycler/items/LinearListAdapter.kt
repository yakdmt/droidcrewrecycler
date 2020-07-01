package io.droidcrew.recycler.items

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import io.droidcrew.recycler.models.DataModel

class LinearListAdapter(private val items: List<DataModel>): RecyclerView.Adapter<BaseLinearViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseLinearViewHolder {
        return LinearViewHolderFactory.createHolder(parent, viewType)
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: BaseLinearViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemViewType(position: Int): Int {
        return items[position].itemStyle.ordinal + 10
    }
}
