package io.droidcrew.recycler.snippet

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import io.droidcrew.recycler.R
import io.droidcrew.recycler.list.HeavyViewHolderFactory
import java.lang.IllegalArgumentException

object ConstraintViewHolderFactory {

    fun createHolder(parent: ViewGroup, viewType: Int) : ConstraintViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.constraint_list_item, parent, false)
        //Simulation of long view creation
//        Thread.sleep(20)
        return when (viewType) {
            HeavyViewHolderFactory.TYPE_RED -> RedConstraintViewHolder(view)
            HeavyViewHolderFactory.TYPE_ORANGE -> OrangeConstraintViewHolder(view)
            HeavyViewHolderFactory.TYPE_YELLOW -> YellowConstraintViewHolder(view)
            HeavyViewHolderFactory.TYPE_GREEN -> GreenConstraintViewHolder(view)
            HeavyViewHolderFactory.TYPE_BLUE -> BlueConstraintViewHolder(view)
            HeavyViewHolderFactory.TYPE_INDIGO -> IndigoConstraintViewHolder(view)
            HeavyViewHolderFactory.TYPE_VIOLET -> VioletConstraintViewHolder(view)
            HeavyViewHolderFactory.TYPE_BROWN -> BrownConstraintViewHolder(view)
            HeavyViewHolderFactory.TYPE_FUCHSIA -> FuchsiaConstraintViewHolder(view)
            HeavyViewHolderFactory.TYPE_GOLD -> GoldConstraintViewHolder(view)
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