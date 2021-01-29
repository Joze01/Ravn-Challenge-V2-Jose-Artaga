package com.ravn.core.model.util

enum class DetailViewType(val value: Int) {
    HEADER(HEADER_VALUE),
    ATRIBUTE(ATTRIBUTE_VALUE),
    VEHICLE(VEHICLE_VALUE)
}

const val HEADER_VALUE = 1
const val ATTRIBUTE_VALUE = 2
const val VEHICLE_VALUE = 3
