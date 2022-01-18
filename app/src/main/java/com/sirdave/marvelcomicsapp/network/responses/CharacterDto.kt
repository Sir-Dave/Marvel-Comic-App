package com.sirdave.marvelcomicsapp.network.responses

import com.google.gson.annotations.SerializedName
import com.sirdave.marvelcomicsapp.domain.Thumbnail
import java.util.*


data class CharacterDto (
    @SerializedName("id")
    val id: Int? = null,

    @SerializedName("name")
    val name: String? = null,

    @SerializedName("description")
    val description: String? = null,

    @SerializedName("modified")
    val modified: Date? = null,

    @SerializedName("resourceURI")
    val resourceURI: String? = null,

    @SerializedName("thumbnail")
    val thumbnail: Thumbnail? = null,
)

data class ThumbnailDto(
    @SerializedName("path")
    val path: String? = null,

    @SerializedName("extension")
    val extension: String? = null
)
