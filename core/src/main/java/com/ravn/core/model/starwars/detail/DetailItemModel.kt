package com.ravn.core.model.starwars.detail

import com.ravn.core.model.util.DetailViewType

data class DetailItemModel (
    var viewType: DetailViewType = DetailViewType.HEADER,
    var itemValue: Pair<String, String?>? = null
)