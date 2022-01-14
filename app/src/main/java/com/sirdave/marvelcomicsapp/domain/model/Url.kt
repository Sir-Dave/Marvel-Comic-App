package com.sirdave.marvelcomicsapp.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Url(
    val type: String? = null,
    val url: String? = null
): Parcelable
