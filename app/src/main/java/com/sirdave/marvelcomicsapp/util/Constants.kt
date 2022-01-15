package com.sirdave.marvelcomicsapp.util

import com.sirdave.marvelcomicsapp.BuildConfig
import java.math.BigInteger
import java.security.MessageDigest


object Constants {
    const val API_KEY: String = BuildConfig.PUBLIC_KEY
    const val PRIVATE_KEY = BuildConfig.PRIVATE_KEY
    const val limit = "100"
    const val BASE_URL = "https://gateway.marvel.com/v1/public/"
    val TIMESTAMP = System.currentTimeMillis().toString()


    fun hash(): String{
        val input = "$TIMESTAMP$PRIVATE_KEY$API_KEY"
        val md = MessageDigest.getInstance("MD5")
        return BigInteger(1, md.digest(input.toByteArray()))
            .toString(16).padStart(32, '0')
    }
}