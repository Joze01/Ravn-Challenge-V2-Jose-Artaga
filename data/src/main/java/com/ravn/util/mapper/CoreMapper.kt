package com.ravn.util.mapper

// Used to map the EntityModel to a DomainModel
// Clean Architecture

abstract class CoreMapper<Model : Any> : BaseMapper() {

    abstract fun toCoreModel(): Model
}
