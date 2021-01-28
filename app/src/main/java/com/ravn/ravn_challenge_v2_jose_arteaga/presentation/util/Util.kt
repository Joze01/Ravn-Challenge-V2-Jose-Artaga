package com.ravn.ravn_challenge_v2_jose_arteaga.presentation.util

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData

// Sets an observer on a certaing LiveData, it's just a shortcut
inline fun <Type> LiveData<Type?>.setObserver(
    owner: LifecycleOwner,
    crossinline action: (Type) -> Unit
) {
    observe(owner, { value -> value?.let { action(it) } })
}