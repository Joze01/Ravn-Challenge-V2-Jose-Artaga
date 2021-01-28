package com.ravn.ravn_challenge_v2_jose_arteaga.presentation.util

import android.view.View
import androidx.databinding.BindingAdapter

object BindingAdapter {
    @JvmStatic
    @BindingAdapter("visibleOrGone")
    fun View.visibleOrGone(visible: Boolean) {
        visibility = if (visible) View.VISIBLE else View.GONE
    }

}