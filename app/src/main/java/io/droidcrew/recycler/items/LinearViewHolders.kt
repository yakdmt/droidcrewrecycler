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

object LinearViewHolderFactory {

    const val LINEAR_TYPE_STYLE_NORMAL = 10
    const val LINEAR_TYPE_STYLE_ALTERNATIVE = 11
    const val LINEAR_TYPE_STYLE_ONE_BUTTON = 12
    const val LINEAR_TYPE_STYLE_ALTERNATIVE_ONE_BUTTON = 13
    const val LINEAR_TYPE_STYLE_NO_SUBLINE = 14

    fun createHolder(parent: ViewGroup, viewType: Int) : BaseLinearViewHolder {
        val view = if (viewType == LINEAR_TYPE_STYLE_ALTERNATIVE || viewType == LINEAR_TYPE_STYLE_ONE_BUTTON) {
            LayoutInflater.from(parent.context).inflate(R.layout.linear_list_item_alternative, parent, false)
        } else {
            LayoutInflater.from(parent.context).inflate(R.layout.linear_list_item, parent, false)
        }
        //Simulation of long view creation
//        Thread.sleep(40)
        return when (viewType) {
            LINEAR_TYPE_STYLE_NORMAL -> Style1ViewHolder(view)
            LINEAR_TYPE_STYLE_ALTERNATIVE -> Style2ViewHolder(view)
            LINEAR_TYPE_STYLE_ONE_BUTTON -> Style3ViewHolder(view)
            LINEAR_TYPE_STYLE_ALTERNATIVE_ONE_BUTTON -> Style4ViewHolder(view)
            LINEAR_TYPE_STYLE_NO_SUBLINE-> Style5ViewHolder(view)
            else -> throw IllegalArgumentException("Unknown viewType")
        }
    }
}

abstract class BaseLinearViewHolder(view: View) : RecyclerView.ViewHolder(view) {

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
    }
}

class Style1ViewHolder(view: View): BaseLinearViewHolder(view)

class Style2ViewHolder(view: View): BaseLinearViewHolder(view)

class Style3ViewHolder(view: View): BaseLinearViewHolder(view)

class Style4ViewHolder(view: View): BaseLinearViewHolder(view)

class Style5ViewHolder(view: View): BaseLinearViewHolder(view)