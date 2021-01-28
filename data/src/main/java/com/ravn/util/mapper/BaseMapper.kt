package com.ravn.util.mapper

import com.google.gson.GsonBuilder

// Used to have a simple function to parse identical models within various modules
// Clean Architecture

abstract class BaseMapper {

    inline fun <reified T> parse(src: Any): T {
        with(
            GsonBuilder()
                .disableHtmlEscaping()
                .create()
        ) {
            return fromJson(
                toJson(src),
                T::class.java
            )
        }
    }

}