package com.ravn.challenge.presentation.util

import android.content.Context
import android.content.res.Resources
import androidx.annotation.StringRes

class RavnResourceManager(context: Context) {
    private var manager: Resources = context.resources

    fun getString(@StringRes resourceId: Int): String = manager.getString(resourceId)
}
