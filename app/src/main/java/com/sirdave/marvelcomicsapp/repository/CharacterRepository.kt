package com.sirdave.marvelcomicsapp.repository

import com.sirdave.marvelcomicsapp.db.entity.Favourite
import com.sirdave.marvelcomicsapp.domain.Character
import kotlinx.coroutines.flow.Flow

interface CharacterRepository {
    suspend fun getAllCharacters(ts: String, apikey: String,
                                 hash: String): List<Character>

    suspend fun getCharacterById(id: Int, ts: String, apikey: String,
                                 hash: String): Character

    fun getAllFavourites(): Flow<List<Favourite>>

    suspend fun getOneFavourite(id: Int): Favourite?

    suspend fun addNewFavourite(favourite: Favourite)

    suspend fun deleteFavourite(favourite: Favourite)
}