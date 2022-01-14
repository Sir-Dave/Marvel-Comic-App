package com.sirdave.marvelcomicsapp.network

import com.sirdave.marvelcomicsapp.network.responses.CharacterResponse
import com.sirdave.marvelcomicsapp.util.Constants
import retrofit2.http.GET
import retrofit2.http.Query


interface CharacterService {
    @GET("characters")
    suspend fun getAllCharacters(
        @Query("ts") ts: String = Constants.TIMESTAMP,
        @Query("apikey") apikey: String = Constants.API_KEY,
        @Query("hash") hash: String = Constants.hash(),
        @Query("limit") limit: String = Constants.limit,
    ): CharacterResponse

}