package com.sirdave.marvelcomicsapp.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Item(
    val resourceURI: String? = null,
    val name: String? = null,
    val type: String? = null
): Parcelable