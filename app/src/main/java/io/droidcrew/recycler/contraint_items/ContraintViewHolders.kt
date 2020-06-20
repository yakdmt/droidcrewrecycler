package io.droidcrew.recycler.contraint_items

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import io.droidcrew.recycler.R
import io.droidcrew.recycler.list.HeavyViewHolderFactory.TYPE_ORANGE
import io.droidcrew.recycler.list.HeavyViewHolderFactory.TYPE_BLUE
import io.droidcrew.recycler.list.HeavyViewHolderFactory.TYPE_BROWN
import io.droidcrew.recycler.list.HeavyViewHolderFactory.TYPE_FUCHSIA
import io.droidcrew.recycler.list.HeavyViewHolderFactory.TYPE_GOLD
import io.droidcrew.recycler.list.HeavyViewHolderFactory.TYPE_GREEN
import io.droidcrew.recycler.list.HeavyViewHolderFactory.TYPE_INDIGO
import io.droidcrew.recycler.list.HeavyViewHolderFactory.TYPE_RED
import io.droidcrew.recycler.list.HeavyViewHolderFactory.TYPE_VIOLET
import io.droidcrew.recycler.list.HeavyViewHolderFactory.TYPE_YELLOW
import java.lang.IllegalArgumentException

object ConstraintViewHolderFactory {

    fun createHolder(parent: ViewGroup, viewType: Int) : ConstraintViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.contraint_list_item, parent, false)
        //Simulation of long view creation
//        Thread.sleep(20)
        return when (viewType) {
            TYPE_RED -> RedConstraintViewHolder(view)
            TYPE_ORANGE -> OrangeConstraintViewHolder(view)
            TYPE_YELLOW -> YellowConstraintViewHolder(view)
            TYPE_GREEN -> GreenConstraintViewHolder(view)
            TYPE_BLUE -> BlueConstraintViewHolder(view)
            TYPE_INDIGO -> IndigoConstraintViewHolder(view)
            TYPE_VIOLET -> VioletConstraintViewHolder(view)
            TYPE_BROWN -> BrownConstraintViewHolder(view)
            TYPE_FUCHSIA -> FuchsiaConstraintViewHolder(view)
            TYPE_GOLD -> GoldConstraintViewHolder(view)
            else -> throw IllegalArgumentException("Unknown viewType")
        }
    }
}

abstract class ConstraintViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    abstract val color: Int

    private val titleView = view.findViewById<TextView>(R.id.title)

    fun bind(text: String) {
        titleView.text = text
        itemView.setBackgroundColor(color)
    }
}

class RedConstraintViewHolder(view: View): ConstraintViewHolder(view) {
    override val color: Int = view.context.getColor(R.color.holder_red)
}

class OrangeConstraintViewHolder(view: View): ConstraintViewHolder(view) {
    override val color: Int = view.context.getColor(R.color.holder_orange)
}

class YellowConstraintViewHolder(view: View): ConstraintViewHolder(view) {
    override val color: Int = view.context.getColor(R.color.holder_yellow)
}

class GreenConstraintViewHolder(view: View): ConstraintViewHolder(view) {
    override val color: Int = view.context.getColor(R.color.holder_green)
}

class BlueConstraintViewHolder(view: View): ConstraintViewHolder(view) {
    override val color: Int = view.context.getColor(R.color.holder_blue)
}

class IndigoConstraintViewHolder(view: View): ConstraintViewHolder(view) {
    override val color: Int = view.context.getColor(R.color.holder_indigo)
}

class VioletConstraintViewHolder(view: View): ConstraintViewHolder(view) {
    override val color: Int = view.context.getColor(R.color.holder_violet)
}

class BrownConstraintViewHolder(view: View): ConstraintViewHolder(view) {
    override val color: Int = view.context.getColor(R.color.holder_brown)
}

class FuchsiaConstraintViewHolder(view: View): ConstraintViewHolder(view) {
    override val color: Int = view.context.getColor(R.color.holder_fuchsia)
}

class GoldConstraintViewHolder(view: View): ConstraintViewHolder(view) {
    override val color: Int = view.context.getColor(R.color.holder_gold)
}