package com.sirdave.marvelcomicsapp.network.responses

import com.google.gson.annotations.SerializedName


class CharacterResponse (
    @SerializedName("code")
    val code: Int? = null,

    @SerializedName("status")
    val status: String? = null,

    @SerializedName("data")
    val data: Data? = null
)

class Data(
    @SerializedName("offset")
    var offset: Int? = null,

    @SerializedName("limit")
    var limit: Int? = null,

    @SerializedName("total")
    var total: Int? = null,

    @SerializedName("count")
    var count: Int? = null,

    @SerializedName("results")
    var results: List<CharacterDto> = listOf()
)