package com.sirdave.marvelcomicsapp.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Thumbnail(
    val path: String? = null,
    val extension: String? = null
):Parcelable