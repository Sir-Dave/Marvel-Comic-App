package com.sirdave.marvelcomicsapp.domain

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import java.util.*

@Parcelize
data class Character(
    val id: Int? = null,
    val name: String? = null,
    val description: String? = null,
    val modified: Date? = null,
    val featuredImage: String? = null,
): Parcelable
