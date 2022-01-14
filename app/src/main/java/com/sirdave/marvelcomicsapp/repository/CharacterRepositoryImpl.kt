package com.sirdave.marvelcomicsapp.repository

import com.sirdave.marvelcomicsapp.domain.model.Character
import com.sirdave.marvelcomicsapp.network.CharacterService
import com.sirdave.marvelcomicsapp.network.model.CharacterDtoMapper

class CharacterRepositoryImpl(
    private val characterService: CharacterService,
    private val mapper: CharacterDtoMapper): CharacterRepository {
    override suspend fun getAllCharacters(ts: String,
        apikey: String, hash: String, limit: String): List<Character> {
        val response = characterService
            .getAllCharacters(ts, apikey, hash, limit).data?.results!!
        return mapper.toDomainList(response)
    }

    override suspend fun getCharacterById(id: Int, ts: String,
        apikey: String, hash: String, limit: String): Character {
        val response = characterService
            .getCharacterById(id, ts, apikey, hash, limit).data?.results!!
        return mapper.mapToDomainModel(response[0])
    }
}