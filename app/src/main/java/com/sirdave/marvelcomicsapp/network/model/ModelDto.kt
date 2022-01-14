package com.sirdave.marvelcomicsapp.network.model

import com.google.gson.annotations.SerializedName
import com.sirdave.marvelcomicsapp.domain.model.Item

data class ModelDto (
    @SerializedName("available")
    val available: Int? = null,

    @SerializedName("returned")
    val returned: Int? = null,

    @SerializedName("collectionURI")
    val collectionURI: String? = null,

    @SerializedName("items")
    val items: List<Item> = listOf()
)