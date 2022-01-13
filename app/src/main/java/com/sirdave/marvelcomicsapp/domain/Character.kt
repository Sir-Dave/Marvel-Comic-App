package com.sirdave.marvelcomicsapp.domain

import java.util.*

data class Character(
    var id: Int,
    var name: String,
    var description: String,
    var modified: Date,
    val resourceURI: String,
    var urls: List<String>,
    var thumbnail: List<String>
)
