package com.sirdave.marvelcomicsapp.network

import com.sirdave.marvelcomicsapp.network.responses.CharacterResponse
import com.sirdave.marvelcomicsapp.util.Constants
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query


interface CharacterService {
    @GET("characters")
    suspend fun getAllCharacters(
        @Query("ts") ts: String,
        @Query("apikey") apikey: String,
        @Query("hash") hash: String
    ): CharacterResponse


    @GET("characters/{id}")
    suspend fun getCharacterById(
        @Path("id") id: Int,
        @Query("ts") ts: String,
        @Query("apikey") apikey: String,
        @Query("hash") hash: String
    ): CharacterResponse
}