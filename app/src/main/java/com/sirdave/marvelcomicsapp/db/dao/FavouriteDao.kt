package com.sirdave.marvelcomicsapp.db.dao

import androidx.room.*
import com.sirdave.marvelcomicsapp.db.entity.Favourite
import kotlinx.coroutines.flow.Flow

@Dao
interface FavouriteDao {

    @Query("SELECT * FROM favourites where id = :id")
    fun getOneFavourite(id: Long): Flow<Favourite>

    @Query("SELECT * FROM favourites")
    fun getAllFavourites(): Flow<List<Favourite>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addNewFavourite(favourite: Favourite)

    @Delete
    suspend fun deleteFavourite(favourite: Favourite)
}