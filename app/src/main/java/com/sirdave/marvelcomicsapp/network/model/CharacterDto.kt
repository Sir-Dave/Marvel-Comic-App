package com.sirdave.marvelcomicsapp.network.model

import com.google.gson.annotations.SerializedName
import com.sirdave.marvelcomicsapp.domain.model.Model
import com.sirdave.marvelcomicsapp.domain.model.Thumbnail
import com.sirdave.marvelcomicsapp.domain.model.Url
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

    @SerializedName("urls")
    val urls: List<Url>? = null,

    @SerializedName("thumbnails")
    val thumbnail: Thumbnail? = null,

    @SerializedName("comics")
    val comics: Model? = null,

    @SerializedName("stories")
    val stories: Model? = null,

    @SerializedName("events")
    val events: Model? = null,

    @SerializedName("series")
    val series: Model? = null,

    @SerializedName("etag")
    val etag: String? = null
)