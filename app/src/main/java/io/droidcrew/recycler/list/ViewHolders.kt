package io.droidcrew.recycler.list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import io.droidcrew.recycler.R
import java.lang.IllegalArgumentException

object HeavyViewHolderFactory {

    const val TYPE_SMALL_IMAGE_WITH_BUTTONS = 0
    const val TYPE_SMALL_IMAGE = 1
    const val TYPE_WIDE_IMAGE_WITH_BUTTONS = 2
    const val TYPE_WIDE_IMAGE = 3

    fun createHolder(parent: ViewGroup, viewType: Int) : HeavyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)
        //Simulation of long view creation
//        Thread.sleep(20)
        return when (viewType) {
            TYPE_SMALL_IMAGE_WITH_BUTTONS -> RedViewHolder(view)
            TYPE_SMALL_IMAGE -> OrangeViewHolder(view)
            TYPE_WIDE_IMAGE_WITH_BUTTONS -> YellowViewHolder(view)
            TYPE_WIDE_IMAGE -> GreenViewHolder(view)
            else -> throw IllegalArgumentException("Unknown viewType")
        }
    }
}

abstract class HeavyViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    abstract val color: Int

    private val textView = view.findViewById<TextView>(R.id.title)

    fun bind(text: String) {
        textView.text = text
        itemView.setBackgroundColor(color)
    }
}

class RedViewHolder(view: View): HeavyViewHolder(view) {
    override val color: Int = view.context.getColor(R.color.holder_red)
}

class OrangeViewHolder(view: View): HeavyViewHolder(view) {
    override val color: Int = view.context.getColor(R.color.holder_orange)
}

class YellowViewHolder(view: View): HeavyViewHolder(view) {
    override val color: Int = view.context.getColor(R.color.holder_yellow)
}

class GreenViewHolder(view: View): HeavyViewHolder(view) {
    override val color: Int = view.context.getColor(R.color.holder_green)
}

class BlueViewHolder(view: View): HeavyViewHolder(view) {
    override val color: Int = view.context.getColor(R.color.holder_blue)
}

class IndigoViewHolder(view: View): HeavyViewHolder(view) {
    override val color: Int = view.context.getColor(R.color.holder_indigo)
}

class VioletViewHolder(view: View): HeavyViewHolder(view) {
    override val color: Int = view.context.getColor(R.color.holder_violet)
}

class BrownViewHolder(view: View): HeavyViewHolder(view) {
    override val color: Int = view.context.getColor(R.color.holder_brown)
}

class FuchsiaViewHolder(view: View): HeavyViewHolder(view) {
    override val color: Int = view.context.getColor(R.color.holder_fuchsia)
}

class GoldViewHolder(view: View): HeavyViewHolder(view) {
    override val color: Int = view.context.getColor(R.color.holder_gold)
}