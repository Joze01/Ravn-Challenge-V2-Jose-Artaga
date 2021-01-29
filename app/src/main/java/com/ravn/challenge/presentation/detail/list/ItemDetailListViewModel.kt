package com.ravn.challenge.presentation.detail.list

import androidx.databinding.ObservableField
import androidx.lifecycle.ViewModel
import com.ravn.core.model.starwars.detail.DetailItemModel

class ItemDetailListViewModel(val detailItemModel: DetailItemModel) : ViewModel() {
    val labelField = ObservableField("")
    val labelValue = ObservableField("")

    fun bindData() {
        labelField.set(detailItemModel.itemValue?.first)
        labelValue.set(detailItemModel.itemValue?.second)
    }
}
