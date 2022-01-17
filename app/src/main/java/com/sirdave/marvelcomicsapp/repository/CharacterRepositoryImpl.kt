package com.sirdave.marvelcomicsapp.repository

import androidx.annotation.WorkerThread
import com.sirdave.marvelcomicsapp.db.dao.FavouriteDao
import com.sirdave.marvelcomicsapp.db.entity.Favourite
import com.sirdave.marvelcomicsapp.domain.model.Character
import com.sirdave.marvelcomicsapp.network.CharacterService
import com.sirdave.marvelcomicsapp.network.model.CharacterDtoMapper
import kotlinx.coroutines.flow.Flow

class CharacterRepositoryImpl(
    private val characterService: CharacterService,
    private val mapper: CharacterDtoMapper,
    private val favouriteDao: FavouriteDao): CharacterRepository {

    @WorkerThread
    override suspend fun getAllFavourites(): List<Favourite> {
        return favouriteDao.getAllFavourites()
    }

    @WorkerThread
    override suspend fun getOneFavourite(id: Long): Favourite {
        return favouriteDao.getOneFavourite(id)
    }

    @WorkerThread
    override suspend fun addNewFavourite(favourite: Favourite) {
        favouriteDao.addNewFavourite(favourite)
    }

    @WorkerThread
    override suspend fun deleteFavourite(favourite: Favourite) {
        favouriteDao.deleteFavourite(favourite)
    }

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