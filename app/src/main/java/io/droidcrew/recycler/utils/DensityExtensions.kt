package io.droidcrew.recycler.utils

import android.content.res.Resources

private val displayMetrics = Resources.getSystem().displayMetrics

val Int.dpf: Float
    get() = this * displayMetrics.density

val Int.dp: Int
    @JvmName("dpToPx")
    get() = dpf.toInt()