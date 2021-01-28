package com.ravn.core.model.starwars.detail

import com.ravn.core.model.util.DetailViewType

class ItemModel<T> {
    val viewType: DetailViewType = DetailViewType.HEADER
    val itemValue: T? = null
}