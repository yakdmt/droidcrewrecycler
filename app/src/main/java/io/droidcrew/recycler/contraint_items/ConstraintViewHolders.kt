package io.droidcrew.recycler.contraint_items

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import io.droidcrew.recycler.R
import io.droidcrew.recycler.list.HeavyViewHolderFactory.TYPE_ORANGE
import io.droidcrew.recycler.list.HeavyViewHolderFactory.TYPE_GREEN
import io.droidcrew.recycler.list.HeavyViewHolderFactory.TYPE_RED
import io.droidcrew.recycler.list.HeavyViewHolderFactory.TYPE_YELLOW
import io.droidcrew.recycler.models.HeavyModel
import io.droidcrew.recycler.snippet.items.*
import java.lang.IllegalArgumentException

object ConstraintViewHolderFactory {

    fun createHolder(parent: ViewGroup, viewType: Int) : ConstraintViewHolder {
        val view = if (viewType == TYPE_RED || viewType == TYPE_ORANGE) {
            LayoutInflater.from(parent.context).inflate(R.layout.constraint_list_item, parent, false)
        } else {
            LayoutInflater.from(parent.context).inflate(R.layout.constraint_list_item_alternative, parent, false)
        }
        //Simulation of long view creation
        Thread.sleep(40)
        return when (viewType) {
            TYPE_RED -> RedConstraintViewHolder(view)
            TYPE_ORANGE -> OrangeConstraintViewHolder(view)
            TYPE_YELLOW -> YellowConstraintViewHolder(view)
            TYPE_GREEN -> GreenConstraintViewHolder(view)
            else -> throw IllegalArgumentException("Unknown viewType")
        }
    }
}

abstract class ConstraintViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    abstract val color: Int

    private val title = view.findViewById<TitleView>(R.id.title)
    private val description = view.findViewById<DescriptionView>(R.id.description)
    private val image = view.findViewById<SomeImageView>(R.id.image)
    private val button1 = view.findViewById<ButtonView>(R.id.button1)
    private val button2 = view.findViewById<ButtonView>(R.id.button2)

    fun bind(viewModel: HeavyModel) {
        title.render(TitleViewState(viewModel.title))
        description.render(DescriptionViewState(viewModel.description))
        image.render(ImageViewState(viewModel.widePicture))
        if (viewModel.withButtons) {
            button1.render(ButtonViewState("Button"))
            button2.render(ButtonViewState("Button"))
            button1.visibility = View.VISIBLE
            button2.visibility = View.VISIBLE
        } else {
            button1.visibility = View.GONE
            button2.visibility = View.GONE
        }
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