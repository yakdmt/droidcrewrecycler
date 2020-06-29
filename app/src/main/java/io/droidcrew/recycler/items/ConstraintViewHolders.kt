package io.droidcrew.recycler.items

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.constraintlayout.widget.ConstraintSet
import androidx.recyclerview.widget.RecyclerView
import io.droidcrew.recycler.R
import io.droidcrew.recycler.models.DataModel
import io.droidcrew.recycler.models.ItemStyle
import io.droidcrew.recycler.models.isAlternative
import io.droidcrew.recycler.models.isOneButton
import io.droidcrew.recycler.snippet.items.*
import io.droidcrew.recycler.utils.dp
import java.lang.IllegalArgumentException

object ConstraintViewHolderFactory {

    const val CONSTRAINT_TYPE_STYLE_NORMAL = 0
    const val CONSTRAINT_TYPE_STYLE_ALTERNATIVE = 1
    const val CONSTRAINT_TYPE_STYLE_ONE_BUTTON = 2
    const val CONSTRAINT_TYPE_STYLE_ALTERNATIVE_ONE_BUTTON = 3
    const val CONSTRAINT_TYPE_STYLE_NO_SUBLINE = 4

    fun createHolder(parent: ViewGroup, viewType: Int) : BaseConstraintViewHolder {
        val view = if (viewType == CONSTRAINT_TYPE_STYLE_ALTERNATIVE || viewType == CONSTRAINT_TYPE_STYLE_ALTERNATIVE_ONE_BUTTON) {
            LayoutInflater.from(parent.context).inflate(R.layout.constraint_list_item_alternative, parent, false)
        } else {
            LayoutInflater.from(parent.context).inflate(R.layout.constraint_list_item, parent, false)
        }
        //Simulation of long view creation
//        Thread.sleep(40)
        return when (viewType) {
            CONSTRAINT_TYPE_STYLE_NORMAL -> Constraint1ViewHolder(view)
            CONSTRAINT_TYPE_STYLE_ALTERNATIVE -> Constraint2ViewHolder(view)
            CONSTRAINT_TYPE_STYLE_ONE_BUTTON -> Constraint3ViewHolder(view)
            CONSTRAINT_TYPE_STYLE_ALTERNATIVE_ONE_BUTTON -> Constraint4ViewHolder(view)
            CONSTRAINT_TYPE_STYLE_NO_SUBLINE-> Constraint5ViewHolder(view)
            else -> throw IllegalArgumentException("Unknown viewType")
        }
    }
}

abstract class BaseConstraintViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    private val title = view.findViewById<TitleView>(R.id.title)
    private val description = view.findViewById<DescriptionView>(R.id.description)
    private val image = view.findViewById<SomeImageView>(R.id.image)
    private val button1 = view.findViewById<ButtonView>(R.id.button1)
    private val button2 = view.findViewById<ButtonView>(R.id.button2)
    private val sublineView = view.findViewById<SublineView>(R.id.subline)

    fun bind(viewModel: DataModel) {
        title.render(TitleViewState(viewModel.title))
        description.render(DescriptionViewState(viewModel.description))
        image.render(ImageViewState(viewModel.isAlternative()))
        button1.render(ButtonViewState(viewModel.buttonText))

        if (viewModel.isOneButton()) {
            button2.visibility = View.GONE
        } else {
            button2.render(ButtonViewState("Share"))
            button2.visibility = View.VISIBLE
        }

        if (viewModel.itemStyle == ItemStyle.STYLE_NO_SUBLINE) {
            sublineView.visibility = View.GONE
        } else {
            sublineView.visibility = View.VISIBLE
            sublineView.render(SublineViewState(viewModel.sublineText))
        }

        itemView as ConstraintLayout

        val constraintSet = ConstraintSet().apply {
            clone(itemView)
            clear(description.id, ConstraintSet.END)
            clear(description.id, ConstraintSet.BOTTOM)

            when (viewModel.itemStyle) {
                ItemStyle.STYLE_ALTERNATIVE_ONE_BUTTON -> {
                    connect(description.id, ConstraintSet.END, itemView.id, ConstraintSet.END, 0)
                }
                ItemStyle.STYLE_ALTERNATIVE -> {
                    connect(description.id, ConstraintSet.END, button2.id, ConstraintSet.START, 16.dp)
                }
                ItemStyle.STYLE_NO_SUBLINE -> {
                    connect(description.id, ConstraintSet.END, image.id, ConstraintSet.START, 16.dp)
                    connect(description.id, ConstraintSet.BOTTOM, button1.id, ConstraintSet.TOP, 24.dp)
                }
                else -> connect(description.id, ConstraintSet.END, image.id, ConstraintSet.START, 16.dp)
            }
        }
        constraintSet.applyTo(itemView)
    }
}

class Constraint1ViewHolder(view: View): BaseConstraintViewHolder(view)

class Constraint2ViewHolder(view: View): BaseConstraintViewHolder(view)

class Constraint3ViewHolder(view: View): BaseConstraintViewHolder(view)

class Constraint4ViewHolder(view: View): BaseConstraintViewHolder(view)

class Constraint5ViewHolder(view: View): BaseConstraintViewHolder(view)