package com.sirdave.marvelcomicsapp.repository

import com.sirdave.marvelcomicsapp.domain.model.Character

interface CharacterRepository {
    suspend fun getAllCharacters(ts: String, apikey: String,
                                 hash: String, limit: String): List<Character>

    suspend fun getCharacterById(id: Int, ts: String, apikey: String,
                                 hash: String, limit: String): Character
}