package com.sirdave.marvelcomicsapp.di

import com.sirdave.marvelcomicsapp.db.dao.FavouriteDao
import com.sirdave.marvelcomicsapp.network.CharacterService
import com.sirdave.marvelcomicsapp.repository.CharacterRepository
import com.sirdave.marvelcomicsapp.repository.CharacterRepositoryImpl
import com.sirdave.marvelcomicsapp.util.CharacterDtoMapper
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {
    @Singleton
    @Provides
    fun provideCharacterRepository(characterService: CharacterService,
                                   characterDtoMapper: CharacterDtoMapper,
                                   favouriteDao: FavouriteDao): CharacterRepository {
        return CharacterRepositoryImpl(characterService, characterDtoMapper, favouriteDao)
    }


}