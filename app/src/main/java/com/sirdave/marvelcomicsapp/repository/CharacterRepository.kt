package com.sirdave.marvelcomicsapp.repository

import com.sirdave.marvelcomicsapp.db.entity.Favourite
import com.sirdave.marvelcomicsapp.domain.Character

interface CharacterRepository {
    suspend fun getAllCharacters(ts: String, apikey: String,
                                 hash: String, limit: String): List<Character>

    suspend fun getCharacterById(id: Int, ts: String, apikey: String,
                                 hash: String, limit: String): Character

    suspend fun getAllFavourites(): List<Favourite>

    suspend fun getOneFavourite(id: Long): Favourite

    suspend fun addNewFavourite(favourite: Favourite)

    suspend fun deleteFavourite(favourite: Favourite)
}