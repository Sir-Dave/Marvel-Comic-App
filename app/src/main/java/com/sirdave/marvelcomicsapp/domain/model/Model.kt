package com.sirdave.marvelcomicsapp.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Model (
    val available: Int? = null,
    val returned: Int? = null,
    val collectionURI: String? = null,
    val items: List<Item> = listOf()
): Parcelable