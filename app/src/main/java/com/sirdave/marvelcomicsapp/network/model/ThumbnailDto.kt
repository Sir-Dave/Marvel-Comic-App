package com.sirdave.marvelcomicsapp.network.model

import com.google.gson.annotations.SerializedName


data class ThumbnailDto(
    @SerializedName("path")
    val path: String? = null,

    @SerializedName("extension")
    val extension: String? = null
)