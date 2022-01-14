package com.sirdave.marvelcomicsapp.network.model

import com.google.gson.annotations.SerializedName

data class ItemDto(
    @SerializedName("resourceURI")
    val resourceURI: String? = null,

    @SerializedName("name")
    val name: String? = null,

    @SerializedName("type")
    val type: String? = null
)