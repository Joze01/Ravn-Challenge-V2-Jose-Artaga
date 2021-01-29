package com.ravn.ravn_challenge_v2_jose_arteaga.presentation.util

import android.content.Context
import android.content.res.Resources
import androidx.annotation.StringRes

class RavnResourceManager(context: Context) {
    private var manager: Resources = context.resources

    fun getString(@StringRes resourceId: Int): String = manager.getString(resourceId)
}